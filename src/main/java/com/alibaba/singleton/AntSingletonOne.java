package com.alibaba.singleton;

/**
 * @Author: fengjian
 * @Description:内部静态类实现单例
 * @Date: Create in 12:51 PM 2018/11/6
 * @Version: 1.0.0
 */
public class AntSingletonOne {

    private AntSingletonOne() {
    }

    /**
     * 内部静态类实现单例
     */
    private static class SingletonHolder {
        private static final AntSingletonOne INSTANCE = new AntSingletonOne();
    }

    public AntSingletonOne getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
