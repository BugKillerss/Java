package com.java.reinforce.model.decorator;

public class Chicken extends Food{
    private Food basic_name;

    public Chicken(Food basic_name) {
        this.basic_name = basic_name;
    }

    public String make(){
        return basic_name.make()+"+鸡腿";
    }
}
