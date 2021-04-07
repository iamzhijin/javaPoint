package com.point.collection;

import java.util.LinkedList;

/**
 * Created by lzhijin Cotter on 2021/4/5.
 */
public class MyHashMapV02 {

    LinkedList[] linkedArray = new LinkedList[1024];

    int size;

    public void put(Object key, Object value){
        MapE mapE = new MapE(key, value);

        int hashIndex = key.hashCode() % 999;
        if (linkedArray[hashIndex] == null) {
            LinkedList<MapE> linkedList = new LinkedList<MapE>();
            linkedList.add(mapE);
            linkedArray[hashIndex] = linkedList;
        } else {
            LinkedList<MapE> linkedList = linkedArray[hashIndex];
            linkedList.add(mapE);
        }
    }

}

class MapE{
    private Object key;

    private Object value;

    public MapE(Object key, Object value) {
        this.key = key;
        this.value = value;
    }

    public Object getKey() {
        return key;
    }

    public void setKey(Object key) {
        this.key = key;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
