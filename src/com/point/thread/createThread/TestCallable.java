package com.point.thread.createThread;

import java.util.concurrent.*;

/**
 * Created by lzhijin Cotter on 2020/4/4.
 *
 * 三、通过实现Callable 接口 创建多线程
 *
 *  1、创建Callable 实现类，并重写call
 *  2、借助调度服务ExecutorService ,获取Future 对象
 *  3、future.get()获取结果
 *  4、service.shutdownNow()停止服务
 */
public class TestCallable {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 使用FutureTask
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        CallableImpl callable1 = new CallableImpl();
        CallableImpl callable2 = new CallableImpl();
//        Future<Integer> futureTask1 = new FutureTask<Integer>(callable1);
        Future<Integer> futureTask1 = executorService.submit(callable1);
        FutureTask<Integer> futureTask2 = new FutureTask<Integer>(callable2);
        executorService.submit(futureTask2);
        Integer r = futureTask1.get();
        executorService.shutdown();
        System.out.println("-----" + r);
//        System.out.println("主线程在执行任务");
//        try {
//            System.out.println("task1运行结果"+futureTask1.get());
//            System.out.println("task1运行结果"+futureTask2.get());
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }
    }
}
