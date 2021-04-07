package com.point.thread.createThread;

/**
 * Created by lzhijin Cotter on 2020/3/24.
 *
 * 二、 通过实现runnable，创建多线程
 *      使用静态代理的设计模式
 *          1、创建真是对象的引用
 *          2、创建代理对象，并引用真实角色对象
 *          3、在代理对象的方法中让真实调用方法
 * 1、实现Runnable接口
 * 2、重写run()方法， 编写线程体
 * 3、实例化对象并进入就绪状态（.start()）
 *
 * 缺点：
 *  无返回值
 *  不能抛出异常
 */
public class TestRunnable01 implements Runnable{

    // 线程体
    public void run() {
        int count = 100;
        while (count > 0){
            System.out.println(Thread.currentThread().getName() +"thread count" + count);
            count --;
        }
    }

    public static void main(String[] args) {
        TestRunnable01 runnable = new TestRunnable01();
        for (int i=0; i<5; i++) {
            Thread thread1 = new Thread(runnable, "线程" + i);
            thread1.start();
        }

    }
}
