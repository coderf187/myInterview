package com.alibaba.singleton;

/**
 * @Author: fengjian
 * @Description:懒汉模式的单实例类
 * @Date: Create in 12:51 PM 2018/11/6
 * @Version: 1.0.0
 */
public class AntSingletonTwo {

    private volatile static AntSingletonTwo singleton = null;

    private AntSingletonTwo() {
    }

    /**
     * double check机制懒汉加载
     * @return
     */
    public static AntSingletonTwo getInstance() {

        if (singleton == null) {
            synchronized (AntSingletonTwo.class) {
                if (singleton == null) {
                    singleton = new AntSingletonTwo();
                }
            }
        }
        return singleton;
    }
}
