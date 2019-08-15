package com.chen.dataStructure.self.tree;

/**
 * @author :  chen weijie
 * @Date: 2019-04-08 11:17 AM
 */
public interface Tree {


    /**
     * 查找节点
     *
     * @param key
     * @return
     */
    Node find(int key);

    /**
     * 插入节点
     *
     * @param key
     * @return
     */
    boolean insert(int key);

    /**
     * 删除节点
     *
     * @param key
     * @return
     */
    boolean delete(int key);


}
