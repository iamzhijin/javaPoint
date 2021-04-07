package com.point.collection;

/**
 * Created by lzhijin Cotter on 2021/4/5.
 */
public class MyLinkNode {

    private MyLinkNode previous;

    private Object obj;

    private MyLinkNode next;

    public MyLinkNode getPrevious() {
        return previous;
    }

    public void setPrevious(MyLinkNode previous) {
        this.previous = previous;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public MyLinkNode getNext() {
        return next;
    }

    public void setNext(MyLinkNode next) {
        this.next = next;
    }
}
