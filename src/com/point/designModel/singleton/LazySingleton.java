package com.point.designModel.singleton;

/**
 * Created by lzhijin Cotter on 2020/5/12.
 * 懒汉单例模式
 */
public class LazySingleton {

    private static volatile LazySingleton instance = null;  // 统一从内存中获取instance,保证线程同步
    private LazySingleton(){} // 构造方法私有化

    public static LazySingleton getInstance(){
        if (instance == null){
            synchronized (LazySingleton.class){
                if (instance == null){
                    instance = new LazySingleton();
                }
            }
        }
        return instance;
    }

}
