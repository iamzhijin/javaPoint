package com.point.thread;

import java.util.Random;
import java.util.concurrent.Callable;

/**
 * Created by lzhijin Cotter on 2020/4/4.
 */
public class CreateThreadUseCallable implements Callable<Integer> {

    //实现call方法
    public Integer call() throws Exception {
        Random random = new Random();
        int sum = 0;
        for (int i = 0; i < 10; i++){
            System.out.println(Thread.currentThread().getName() + "开始第" + i + "次求和");
            int start = random.nextInt(100);
            int end = random.nextInt(100);
            sum += (start + end);

        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
        System.out.println("子线程任务结果" + sum);
        return sum;
    }
}
