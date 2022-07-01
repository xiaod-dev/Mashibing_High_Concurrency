package com.mark.concurrent03;

import com.mark.concurrent02.T2;

/**
 * synchronized 对对象加锁
 * 加锁位置：堆内存对象
 *
 * @author MarkShen
 */
public class T {

    private int count = 10;

    public synchronized void m() { // 等同于 synchronized(this)， 锁定当前对象
        count--;
        System.out.println(Thread.currentThread().getName() + "" + count);
    }

    public static void main(String[] args) {
        T t = new T();
        for (int i = 0; i < 10; i++) {
            new Thread(t::m, "thread" + i + "-").start();
        }
    }

}
