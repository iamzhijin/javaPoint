package com.point.thread;

import java.util.Random;

/**
 * Created by lzhijin Cotter on 2020/4/7.
 * 多线程售票实例
 * 1、保持剩余总票数一致
 * 2、锁定售票操作
 */
public class ExampleTicket implements Runnable{

    private static Integer totalTicket = 20;

    @Override
    public void run() {
        while (totalTicket > 0){
            synchronized (this){
                if (totalTicket > 0){
                    System.out.println(Thread.currentThread().getName() + "卖出第" + totalTicket + "张票");
                    totalTicket--;
                } else {
                    System.out.println("票卖完了");
                }
            }
            // 模拟网络延迟
            try {
                Random random = new Random();
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
