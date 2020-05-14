package com.point.designModel.prototype;

/**
 * Created by lzhijin Cotter on 2020/5/14.
 * 原型模式
 */
public class Prototype implements Cloneable{
    public Prototype(){
        System.out.println("创建了 原型");
    }

    @Override
    protected Prototype clone() throws CloneNotSupportedException {
        System.out.println("复制了原型");
        return (Prototype)super.clone();
    }

    static class TestPrototype{
        public static void main(String[] args) {
            Prototype prototype1 = new Prototype();
            try {
                Prototype prototype2 = prototype1.clone();
                System.out.println(prototype1 == prototype2);
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }

        }
    }
}
