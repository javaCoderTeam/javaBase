package com.chen.util.zookeeper.demo1;

import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;
import org.I0Itec.zkclient.serialize.SerializableSerializer;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * https://www.cnblogs.com/liuyang0/p/6800538.html
 * <p>
 * 在zookeeper指定节点（locks）下创建临时顺序节点node_n
 * 获取locks下所有子节点children
 * 对子节点按节点自增序号从小到大排序
 * 判断本节点是不是第一个子节点，若是，则获取锁；若不是，则监听比该节点小的那个节点的删除事件
 * 若监听事件生效，则回到第二步重新进行判断，直到获取到锁
 *
 * @author :  chen weijie
 * @Date: 2019-06-10 15:53
 */
public class DistributedLock implements Lock {



    private static final String ZOOKEEPER_IP_PORT = "127.0.0.1:2182,127.0.0.1:2183,127.0.0.1:2184";
    private static final String LOCK_PATH = "/LOCK";

    private CountDownLatch cdl;

    /**
     * 当前请求的节点前一个节点
     */
    private String beforePath;

    /**
     * 当前请求的节点
     */
    private String currentPath;


    private ZkClient zkClient = new ZkClient(ZOOKEEPER_IP_PORT, 4000, 4000, new SerializableSerializer(), 5);

    /**
     * 判断有没有LOCK目录，没有则创建
     */
    public DistributedLock() {
        if (!this.zkClient.exists(LOCK_PATH)) {
            this.zkClient.createPersistent(LOCK_PATH);
        }
    }

    @Override
    public void lock() {
        //尝试去获取分布式锁失败
        if (!tryLock()) {
            //对次小节点进行监听
            waitForLock();
            lock();
        } else {
            System.out.println(Thread.currentThread().getName() + "获取分布式锁成功！");
        }
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        // 如果currentPath为空则为第一次尝试加锁，第一次加锁赋值currentPath
        if (currentPath == null || currentPath.length() <= 0) {
            // 创建一个临时顺序节点
            currentPath = this.zkClient.createEphemeralSequential(LOCK_PATH + "/", "lock");
            System.out.println("---------------------------->" + currentPath);
        }

        // 获取所有临时节点并排序，临时节点名称为自增长的字符串如：0000000400
        List<String> childrens = this.zkClient.getChildren(LOCK_PATH);
        //由小到大排序所有子节点
        Collections.sort(childrens);
        //判断创建的子节点/LOCK/Node-n是否最小,即currentPath,如果当前节点等于childrens中的最小的一个就占用锁
        if (currentPath.equals(LOCK_PATH + '/' + childrens.get(0))) {
            return true;
        } else {
            //找出比创建的临时顺序节子节点/LOCK/Node-n次小的节点,并赋值给beforePath
            int wz = Collections.binarySearch(childrens, currentPath.substring(6));
            beforePath = LOCK_PATH + '/' + childrens.get(wz - 1);
        }
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    /**
     * 完成业务逻辑以后释放锁
     */
    @Override
    public void unlock() {
        // 删除当前临时节点
        zkClient.delete(currentPath);
    }

    @Override
    public Condition newCondition() {
        return null;
    }

    /**
     * 等待锁,对次小节点进行监听
     */
    private void waitForLock() {
        IZkDataListener listener = new IZkDataListener() {
            @Override
            public void handleDataDeleted(String dataPath) throws Exception {
                System.out.println(Thread.currentThread().getName() + ":捕获到DataDelete事件！---------------------------");
                if (cdl != null) {
                    cdl.countDown();
                }
            }

            @Override
            public void handleDataChange(String dataPath, Object data) throws Exception {

            }
        };

        // 对次小节点进行监听,即beforePath-给排在前面的的节点增加数据删除的watcher
        this.zkClient.subscribeDataChanges(beforePath, listener);
        if (this.zkClient.exists(beforePath)) {
            cdl = new CountDownLatch(1);
            try {
                cdl.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.zkClient.unsubscribeDataChanges(beforePath, listener);
    }

}
