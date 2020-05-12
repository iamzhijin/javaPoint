package com.point.designModel.singleton;

/**
 * Created by lzhijin Cotter on 2020/5/12.
 * 饿汉式单例模式
 */
public class HungrySingleton {
    private static final HungrySingleton instance = new HungrySingleton();
    private HungrySingleton(){}

    public static HungrySingleton getInstance(){
        return instance;
    }
}
