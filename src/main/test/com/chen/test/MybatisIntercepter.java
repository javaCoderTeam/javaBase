package com.chen.test;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Invocation;

import java.util.Properties;

/**
 * @author :  chen weijie
 * @Date: 2020-04-15 01:59
 */
public class MybatisIntercepter implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        return null;
    }

    @Override
    public Object plugin(Object o) {
        return null;
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
