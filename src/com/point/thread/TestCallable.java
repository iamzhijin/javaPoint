package com.point.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * Created by lzhijin Cotter on 2020/4/4.
 */
public class TestCallable {

    public static void main(String[] args) {
        // 使用FutureTask
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        CreateThreadUseCallable callable1 = new CreateThreadUseCallable();
        CreateThreadUseCallable callable2 = new CreateThreadUseCallable();
        FutureTask<Integer> futureTask1 = new FutureTask<Integer>(callable1);
        FutureTask<Integer> futureTask2 = new FutureTask<Integer>(callable2);
        executorService.submit(futureTask1);
        executorService.submit(futureTask2);
        executorService.shutdown();

//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e1) {
//            e1.printStackTrace();
//        }

        System.out.println("主线程在执行任务");
        try {
            System.out.println("task1运行结果"+futureTask1.get());
            System.out.println("task1运行结果"+futureTask2.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
