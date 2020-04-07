package com.point.thread;

/**
 * Created by lzhijin Cotter on 2020/3/20.
 * 1、继承Thread类
 * 2、重写run()方法
 * 3、实例化对象并进入就绪状态（.start()）
 */
public class CreateUseThread extends Thread{

    CreateUseThread(){}

    CreateUseThread(String name){
        super(name);
    }

    @Override
    public void run() {
        // 线程体
        int count = 5000;
        while (count > 0){
//            System.out.println(Thread.currentThread().getName() +"thread count" + count);
            count --;
        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (int i=0; i<5; i++){
            CreateUseThread createUseThread = new CreateUseThread("线程" + i);
            createUseThread.start();
        }
//        CreateUseThread createUseThread1 = new CreateUseThread("线程1");
//        createUseThread1.start();
        long end = System.currentTimeMillis();
        System.out.println(start);
        System.out.println(end);
//        CreateUseThread createUseThread1 = new CreateUseThread("线程1");
//        CreateUseThread createUseThread2 = new CreateUseThread("线程2");
//        createUseThread1.start();
//        createUseThread2.start();
    }
}
