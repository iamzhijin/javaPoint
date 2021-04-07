package com.point.collection;

/**
 * Created by lzhijin Cotter on 2021/4/5.
 */
public class MyArrayList {

    private Object[] elementDate;

    private int size;

    public MyArrayList(){
        this(10);
    }

    public MyArrayList(int initSize) {
        if (initSize < 0) {
            try {
                throw new Exception("长度不可小于0");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        elementDate = new Object[initSize];
    }

    public void add(Object obj) {
        // 扩容
        if (size == elementDate.length) {
            Object[] newArray = new Object[size*2+1];
            System.arraycopy(elementDate, 0, newArray,0, elementDate.length);
            elementDate = newArray;
        }
        elementDate[size] = obj;
        size++;
    }

    public void remove(int index) {
        // TODO: 2021/4/5 校验index
        int moveNum = size - index - 1;
        if (moveNum > 0) {
            System.arraycopy(elementDate, index+1, elementDate, index, moveNum);
        }
        elementDate[--size] = null;
    }
}
