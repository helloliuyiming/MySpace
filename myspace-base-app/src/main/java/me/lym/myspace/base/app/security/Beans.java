package me.lym.myspace.base.app.security;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.cache.CuratorCache;
import org.apache.curator.framework.recipes.cache.CuratorCacheListener;
import org.apache.curator.framework.recipes.cache.CuratorCacheListenerBuilder;
import org.apache.curator.framework.recipes.cache.NodeCacheListener;
import org.apache.zookeeper.AddWatchMode;
import org.apache.zookeeper.data.Stat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Configuration
public class Beans{

    @Value("${spring.application.name}")
    private String applicationName;
    Gson gson;

    public Beans(){
        gson = new Gson();
    }

    @Autowired
    private CuratorFramework curatorFramework;

    @Bean(name = "allowServerSet")
    public Set<String> allowServerSet() throws Exception {
        String zookeeperPath = "/myspace/app/" + applicationName;
        if (applicationName == null) {
            throw new NullPointerException("spring.application.name can't be null");
        }
        Set<String> set = new HashSet<>();
        Stat stat = curatorFramework.checkExists().forPath(zookeeperPath);
        if (stat == null) {
            curatorFramework.create().forPath(zookeeperPath);
        }
        CuratorCache curatorCache = CuratorCache.build(curatorFramework,zookeeperPath);
        CuratorCacheListener curatorCacheListener = CuratorCacheListener.builder()
                .forNodeCache(() -> {
                    byte[] data = curatorFramework.getData().forPath(zookeeperPath);
                    JsonObject jsonObject = gson.fromJson(new String(data), JsonObject.class);
                    Map<String,Object> map = gson.fromJson(new String(data), Map.class);
                    set = (Set<String>) map.get("allowServer");
                })
                .build();
        curatorCache.listenable().addListener(curatorCacheListener);
        return set;
    }
}
