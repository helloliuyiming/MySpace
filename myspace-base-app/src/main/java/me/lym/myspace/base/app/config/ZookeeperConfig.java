package me.lym.myspace.base.app.config;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ZookeeperConfig {

    @Value("myspace.resource.zookeeper.host")
    private String zookeeperServer;

    @Bean
    public CuratorFramework curatorFramework(){
        if (zookeeperServer == null) {
            throw new NullPointerException("myspace.resource.zookeeper.host can't be null");
        }
        CuratorFramework curatorFramework = CuratorFrameworkFactory.newClient(zookeeperServer, retryPolicy());
        curatorFramework.start();
        return curatorFramework;
    }

    @Bean
    public RetryPolicy retryPolicy(){
        return new ExponentialBackoffRetry(1000, 3);
    }
}
