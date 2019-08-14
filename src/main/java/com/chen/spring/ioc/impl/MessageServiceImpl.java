package com.chen.spring.ioc.impl;

import com.chen.spring.ioc.MessageService;

/**
 * @author :  chen weijie
 * @Date: 2019-08-09 00:07
 */
public class MessageServiceImpl implements MessageService {

    @Override
    public String getMessage() {
        return " hello world";
    }
}
