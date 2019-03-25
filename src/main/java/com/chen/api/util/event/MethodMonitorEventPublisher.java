package com.chen.api.util.event;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 事件监听器接口针对不同的事件发布实际提供相应的处理方法定义，最重要的是，
 * 其方法只接收MethodMonitorEvent参数，说明这个监听器类只负责监听器对应的事件并进行处理。
 * 有了事件和监听器，剩下的就是发布事件，然后让相应的监听器监听并处理。通常情况，我们会有一个
 * 事件发布者，它本身作为事件源，在合适的时机，将相应的事件发布给对应的事件监听器：
 *
 * @author :  chen weijie
 * @Date: 2019-03-20 11:25 AM
 */
public class MethodMonitorEventPublisher {


    private List<MothodMonitorEventListener> listeners = new ArrayList<>();


    public void methodMonitor() {

        MethodMonitorEvent event = new MethodMonitorEvent(this);
        publishEvent("begin", event);
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        publishEvent("end", event);
    }


    private void publishEvent(String status, MethodMonitorEvent event) {


        List<MothodMonitorEventListener> copyListeners = new ArrayList<>(listeners);

        for (MothodMonitorEventListener listener : copyListeners) {

            if ("begin".equals(status)) {

                listener.onMethodBegin(event);
            } else {
                listener.onMethodEnd(event);

            }
        }

    }


    public static void main(String[] args) {

        MethodMonitorEventPublisher publisher = new MethodMonitorEventPublisher();
        publisher.addEventLisner(new MothodMonitorEventListenerImpl());
        publisher.methodMonitor();
    }


    public void addEventLisner(MothodMonitorEventListener eventLister) {
    }

    public void removeEventLisner(MothodMonitorEventListener eventLister) {
    }

    public void removeAllEventLisner() {
    }


}
