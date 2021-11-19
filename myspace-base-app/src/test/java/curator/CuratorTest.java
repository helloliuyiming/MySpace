package curator;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.*;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.data.Stat;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

public class CuratorTest {

    private CuratorFramework curatorFramework;

    private String zkHost = "localhost:2181";
    private RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
    private String zookeeperPath = "/hello";
    @Before
    public void init(){
        curatorFramework = CuratorFrameworkFactory.newClient(zkHost, retryPolicy);
        curatorFramework.start();
    }

    @Test
    public void t1() throws Exception {
        System.out.println(curatorFramework);
        Stat stat = curatorFramework.checkExists().forPath("/hello");
        System.out.println(stat.getDataLength());
        byte[] bytes = curatorFramework.getData().forPath("/hello");
        System.out.println(new String(bytes));
    }


    @Test
    public void t2(){

        CuratorCache curatorCache = CuratorCache.build(curatorFramework, zookeeperPath);
        PathChildrenCacheListener pathChildrenCacheListener = new PathChildrenCacheListener() {
            @Override
            public void childEvent(CuratorFramework curatorFramework, PathChildrenCacheEvent pathChildrenCacheEvent) throws Exception {
//                System.out.println("事件路径:" + pathChildrenCacheEvent.getData().getPath() + "事件类型" + pathChildrenCacheEvent.getType());
                System.out.println("CuratorTest.childEvent");
                System.out.println("pathChildrenCacheEvent = " + pathChildrenCacheEvent);
            }
        };
        CuratorCacheListener curatorCacheListener = CuratorCacheListener.builder().forPathChildrenCache(zookeeperPath, curatorFramework, pathChildrenCacheListener).build();

        CuratorCacheListener curatorCacheListener1 = CuratorCacheListener.builder()
                .forCreates(childData -> {
                    System.out.println("create");
                })
                .forDeletes(childData -> System.out.println("delete"))
                .forInitialized(() -> {
                    System.out.println("initialized");
                })
                .forChanges(new CuratorCacheListenerBuilder.ChangeListener() {
                    @Override
                    public void event(ChildData oldNode, ChildData node) {
                        System.out.println("oldNode = " + oldNode);
                        System.out.println("node = " + node);
                    }
                }).build();

        CuratorCacheListener curatorCacheListener2 = CuratorCacheListener.builder().forNodeCache(new NodeCacheListener() {
            @Override
            public void nodeChanged() throws Exception {
                System.out.println("CuratorTest.nodeChanged");
            }
        }).build();
        curatorCache.listenable().addListener(curatorCacheListener);
        curatorCache.start();

        LockSupport.park();
        System.out.println("done");
    }
}
