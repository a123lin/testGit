package com.laman.zookeeper;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.junit.Test;

import java.io.IOException;

/**
 * @ClassName Testzookeeper
 * @Description TODO
 * @Author Laman
 * @Date 2019/4/9 18:55
 * @Version 1.0
 **/

public class Testzookeeper {
    private String connectString = "192.168.46.130:2181,192.168.46.131:2181,192.168.46.132:2181";
    private int sessionTimeout=2000;
    private ZooKeeper zkClient;

    @Test
    public void init() throws IOException {
            zkClient = new ZooKeeper(connectString, sessionTimeout, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {

            }
        });
    }

}
