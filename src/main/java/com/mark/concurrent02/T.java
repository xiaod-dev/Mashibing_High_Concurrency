package com.mark.concurrent02;

/**
 * synchronized关键字
 * 对当前对象加锁
 * @author MarkShen
 */
public class T {

	private int count = 10;

	public void m() {
		// lock current object.
		synchronized(this) { // 任何线程要执行下面的代码， 必须先拿到this的锁, 锁定this对象, 锁对象， 而不是代码块
			count --;
			System.out.println(Thread.currentThread().getName() + "|" + count);
		}
	}

    public static void main(String[] args) {
        T t = new T();
        new Thread(() -> t.m(), "t1").start();
        new Thread(() -> t.m(), "t2").start();
    }
}
