package com.wkang.jk9559.learn.ch1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
/*
* 同Object.wait()和notify()方法一样，使用Condition.await()和signal()方法时
* 要求线程持有相关的重入锁，调用await之后，会释放相关重入锁，在调用signal时
* 也要求先持有相关的锁。*/
public class ReenterLockCondition implements Runnable {
    private static ReentrantLock lock = new ReentrantLock();
    private static Condition condition  = lock.newCondition();

    @Override
    public void run() {
        try{
            lock.lock();
            condition.await();
            System.out.println("Thread is going on");
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReenterLockCondition rlc = new ReenterLockCondition();
        Thread t1 = new Thread(rlc);
        t1.start();
        Thread.sleep(2000);
        lock.lock();
        condition.signal();
        lock.unlock();
    }
}
