package com.point.collection;

/**
 * Created by lzhijin Cotter on 2021/4/5.
 */
public class MyHashMapV01 {
    MapEntry[] mayEntryArray = new MapEntry[1024];
    int size;

    public void put(Object key, Object value){
        MapEntry mapEntry = new MapEntry(key, value);
        for (int i=0; i<size; i++) {
            if (mayEntryArray[i].getKey().equals(key)) {
                mayEntryArray[i].setValue(value);
                return;
            }
        }
        mayEntryArray[size++] = mapEntry;
    }

    public Object get(Object key){
        for (int i=0; i<size; i++) {
            if (mayEntryArray[i].getKey().equals(key)) {
                return mayEntryArray[i].getValue();
            }
        }
        return null;
    }

}

class MapEntry{
    private Object key;

    private Object value;

    public MapEntry(Object key, Object value) {
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
