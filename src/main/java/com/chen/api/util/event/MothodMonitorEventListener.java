package com.chen.api.util.event;

import java.util.EventListener;

/**
 * 定义事件监听
 *
 * @author :  chen weijie
 * @Date: 2019-03-20 11:11 AM
 */
public interface MothodMonitorEventListener extends EventListener {


    /**
     * 处理方法执行之前发布的时间
     *
     * @param event
     */
    void onMethodBegin(MethodMonitorEvent event);

    /**
     * 处理方法执行之后发布的事件
     *
     * @param event
     */
    void onMethodEnd(MethodMonitorEvent event);


}
