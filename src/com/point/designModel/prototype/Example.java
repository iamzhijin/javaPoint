package com.point.designModel.prototype;

/**
 * Created by lzhijin Cotter on 2020/5/14.
 */
public class Example {
    public static void main(String[] args) throws CloneNotSupportedException{
        GoodStudent goodStudent = new GoodStudent("小飞", "2020", "三好学生");
        goodStudent.display();
        GoodStudent goodStudent1 = goodStudent.clone();
        goodStudent1.setName("小青");
        goodStudent1.display();
    }
}

class GoodStudent implements Cloneable{
    private String name;
    private String year;
    private String honor;

    public GoodStudent(String name, String year, String honor) {
        this.name = name;
        this.year = year;
        this.honor = honor;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    protected GoodStudent clone() throws CloneNotSupportedException {
        return (GoodStudent)super.clone();
    }

    public void display(){
        System.out.println(this.name + "在" + this.year + "获得" + this.honor + "荣誉");
    }
}
