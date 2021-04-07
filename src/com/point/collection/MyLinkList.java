package com.point.collection;

/**
 * Created by lzhijin Cotter on 2021/4/5.
 */
public class MyLinkList {

    private MyLinkNode fistNode;

    private MyLinkNode lastNode;

    private int size;

    public void add(Object obj) {
        MyLinkNode node = new MyLinkNode();
        if (fistNode == null) {
            node.setPrevious(null);
            node.setObj(obj);
            node.setNext(null);
            fistNode = node;
            lastNode = node;
        } else {
            node.setPrevious(lastNode);
            node.setObj(obj);
            node.setNext(null);
            lastNode.setNext(node);
            lastNode = node;
        }
    }

    public Object get(int index) {
        MyLinkNode targetNode = new MyLinkNode();
        if (fistNode != null) {
            targetNode = fistNode;
            for (int i=0; i<index; i++) {
                targetNode = targetNode.getNext();
            }
        }
        return targetNode.getObj();
    }
}
