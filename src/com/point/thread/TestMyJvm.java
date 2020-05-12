package com.point.thread;

/**
 * Created by lzhijin Cotter on 2020/4/11.
 */
public class TestMyJvm {
    public static void main(String[] args) {
        MyJVM myJVM1 = MyJVM.getInstance();
        MyJVM myJVM2 = MyJVM.getInstance();
        System.out.println(myJVM1==myJVM2);
    }
}
