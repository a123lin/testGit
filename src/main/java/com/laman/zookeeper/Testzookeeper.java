package com.laman.zookeeper;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Id;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * @ClassName Testzookeeper
 * @Description TODO
 * @Author Laman
 * @Date 2019/4/9 18:55
 * @Version 1.0
 **/

public class Testzookeeper {
    private String connectString = "192.168.46.130:2181,192.168.46.131:2181,192.168.46.132:2181";
    private int sessionTimeout=8000;
    private ZooKeeper zkClient;

    @Before
    public void init() throws IOException{
            zkClient = new ZooKeeper(connectString, sessionTimeout, new Watcher() {
            @Override
            //有监听变化时执行
            public void process(WatchedEvent watchedEvent) {
                List<String> children = null;
                try {
                    children = zkClient.getChildren("/", true);
                    for (String child : children) {
                        System.out.println(child);
                    }
                } catch (KeeperException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });

    }
/**
 *功能描述
 * @author Laman
 * @Description //创建节点
 * @date   2019/4/9
 * @param  []
 * @return void
 */
    @Test
    public void createNode() throws KeeperException, InterruptedException {
        String s = zkClient.create("/testbyidea", "test".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        System.out.println(s);
    }
/**
 *功能描述
 * @author Laman
 * @Description //监听节点路径动态变化
 * @date   2019/4/9
 * @param  []
 * @return void
 */
    @Test
    public void getDataAndWatch() throws KeeperException, InterruptedException {
        List<String> children = zkClient.getChildren("/", true);
        Thread.sleep(Long.MAX_VALUE);
    }


}
