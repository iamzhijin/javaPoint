package com.point.thread;

/**
 * Created by lzhijin Cotter on 2020/4/11.
 * 单例模式 懒汉式
 */
public class MyJVM {

    // 1 构造器私有化
    private MyJVM(){}

    // 2 声明一个静态属性(懒汉式)
    private static MyJVM instance = null;

    // 3 提供公共对外方法
    public static MyJVM getInstance(){
        if (instance == null){ // 双重判断增加效率
            synchronized (MyJVM.class){ // 加入同步锁，防止多线程创建多个对象
                if (instance == null){
                    instance = new MyJVM();
                }
            }
        }
        return instance;
    }
}

/**
 * 单例模式 饿汉式
 */
class MyJVM2 {
    // 1 构造器私有化
    private MyJVM2(){}

    // 2 声明一个静态属性并初始化(懒汉式)
    private static MyJVM2 instance = new MyJVM2();

    // 3 提供公共对外方法
    public static MyJVM2 getInstance(){
        return instance;
    }
}

/**
 * 单例模式 饿汉式
 * 延缓初始化的时间 提高效率
 */
class MyJVM3 {
    // 1 构造器私有化
    private MyJVM3(){}

    // 2 创建内部静态类 延缓加载时机
    private static class JVMHolder{
        private static MyJVM3 instance = new MyJVM3();
    }

    // 3 提供公共对外方法
    public static MyJVM3 getInstance(){
        return JVMHolder.instance;
    }
}
