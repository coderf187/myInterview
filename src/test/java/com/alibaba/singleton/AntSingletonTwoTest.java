package com.alibaba.singleton;

import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * @Author: fengjian
 * @Description:
 * @Date: Create in 1:14 PM 2018/11/6
 * @Version: 1.0.0
 */
public class AntSingletonTwoTest {

    /**
     * 存放多线程获取的单例
     */
    private ConcurrentHashMap<Long, AntSingletonTwo> concurrentHashMap = new ConcurrentHashMap(16);
    /**
     * 线程数
     */
    private final Integer THREAD_COUNT = 100;

    private CountDownLatch latch = new CountDownLatch(THREAD_COUNT);

    @Before
    public void before() {
        for (int i = 0; i < THREAD_COUNT; i++) {
            new Thread(() -> {
                concurrentHashMap.put(Thread.currentThread().getId(), AntSingletonTwo.getInstance());
                latch.countDown();
            }).start();
        }
    }

    @Test
    public void getInstance() throws InterruptedException {
        latch.await();
        assertThat(concurrentHashMap.size() == THREAD_COUNT, is(true));
        assertEquals(concurrentHashMap.values().stream().distinct().count(), 1);

    }
}