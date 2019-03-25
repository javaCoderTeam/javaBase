package com.chen.api.util.event;

import java.util.EventObject;

/**
 * 事件监听类型
 *
 * @author :  chen weijie
 * @Date: 2019-03-20 11:06 AM
 */
public class MethodMonitorEvent extends EventObject {


    /**
     * 时间戳，用于记录方法开始执行的时间
     */
    public long timestamp;


    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public MethodMonitorEvent(Object source) {
        super(source);
    }
}
