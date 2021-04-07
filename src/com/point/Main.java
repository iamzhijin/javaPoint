package com.point;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	    Integer[] intArray = new Integer[]{1,2,9,7,2,1,6,8,7};
	    // 方式1 转换后的list不支持增删
        List<Integer> intList1 = Arrays.asList(intArray);
        // 方式2 支持增删
        List<Integer> intList2 = new ArrayList<Integer>(Arrays.asList(intArray));
        //方式3 使用collections
        List<Integer> intList3 = new ArrayList<>();
        Collections.addAll(intList3, intArray);
//        for (Integer i: intList3) {
//            System.out.println(i);
//        }

        Set<Integer> set = new HashSet<>();
        Iterator<Integer> ot = set.iterator();
    }
}
