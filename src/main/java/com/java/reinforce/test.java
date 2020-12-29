package com.java.reinforce;

import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] agrs) throws Exception {
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("9");
        List<String> fwuuid = new ArrayList<String>();
        if (list.size() <= 2) {
            System.out.println("小于等于2");
        } else {
            while(list.size()>2) {
                String id = list.remove(2);
                fwuuid.add(id);
            }
        }
    }
}
