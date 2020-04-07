package com.point.thread;

/**
 * Created by lzhijin Cotter on 2020/3/24.
 * 1、实现Runnable接口
 * 2、实现run()方法
 * 3、实例化对象并进入就绪状态（.start()）
 */
public class CreateUseRunnable implements Runnable{

    // 线程体
    public void run() {
        int count = 100;
        while (count > 0){
            System.out.println(Thread.currentThread().getName() +"thread count" + count);
            count --;
        }
    }

    public static void main(String[] args) {
        CreateUseRunnable runnable = new CreateUseRunnable();
        Thread thread1 = new Thread(runnable, "线程1");
        thread1.start();
    }
}
