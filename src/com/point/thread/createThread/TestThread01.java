package com.point.thread.createThread;

/**
 * Created by lzhijin Cotter on 2020/3/20.
 *
 * 一、通过继承Thread 类创建多线程
 *
 * 1、继承Thread类
 * 2、重写run()方法
 * 3、实例化对象并进入就绪状态（.start()）
 *
 * 缺点：
 *      使得该类无法继承其他类
 *      不便于共享资源
 */
public class TestThread01 extends Thread{

    TestThread01(){}

    TestThread01(String name){
        super(name);
    }

    @Override
    public void run() {
        // 线程体
        int count = 20;
        while (count > 0){
            System.out.println(Thread.currentThread().getName() +"thread count" + count);

            count --;
        }
    }

    public static void main(String[] args) {
        for (int i=0; i<5; i++){
            TestThread01 createUseThread = new TestThread01("线程" + i);
            createUseThread.start();
        }
    }
}
