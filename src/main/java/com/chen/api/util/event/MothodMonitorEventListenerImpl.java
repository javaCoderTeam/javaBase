package com.chen.api.util.event;

/**
 * 事件监听的实现
 *
 * @author :  chen weijie
 * @Date: 2019-03-20 11:15 AM
 */
public class MothodMonitorEventListenerImpl implements MothodMonitorEventListener {


    @Override
    public void onMethodBegin(MethodMonitorEvent event) {
        event.timestamp = System.currentTimeMillis();
    }

    @Override
    public void onMethodEnd(MethodMonitorEvent event) {

        long duration = System.currentTimeMillis() - event.timestamp;
        System.out.println("耗时：" + duration);
    }

}
