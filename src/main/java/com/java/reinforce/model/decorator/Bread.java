package com.java.reinforce.model.decorator;

public class Bread  extends Food{
    private Food basic_name;

    public Bread(Food basic_name) {
        this.basic_name = basic_name;
    }

    public String make(){
        return basic_name.make()+"+奶油";
    }
}
