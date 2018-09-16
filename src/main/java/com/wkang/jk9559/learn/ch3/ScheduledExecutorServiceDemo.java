package com.wkang.jk9559.learn.ch3;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/*
* scheduleAtFixedRate 以一定速率运行线程，第一个任务执行开始时间为 initialDelay
* 第二个任务开始执行时间为 initialDelay+period*1 第三个为 initialDelay+period*2
* 若开始时间到了而上一个任务未执行完毕，则等待
* scheduleWithFixedDelay 任务开始于 initialDelay
* 后续任务将会按照给定period执行，即上一个任务的结束时间到下一个任务开始时间的时间差*/

public class ScheduledExecutorServiceDemo {
    public static void main(String[] args) {
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(10);
        ses.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    System.out.println(System.currentTimeMillis()/1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },0,2,TimeUnit.SECONDS);
    }
}
