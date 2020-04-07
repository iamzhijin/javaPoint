package com.point.thread;

/**
 * Created by lzhijin Cotter on 2020/4/7.
 */
public class TestExampleTicket {
    public static void main(String[] args) {
        ExampleTicket ticket = new ExampleTicket();
        Thread t1 = new Thread(ticket,"1号窗");
        Thread t2 = new Thread(ticket,"2号窗");
        Thread t3 = new Thread(ticket,"3号窗");
        t1.start();
        t2.start();
        t3.start();
    }
}
