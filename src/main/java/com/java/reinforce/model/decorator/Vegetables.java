package com.java.reinforce.model.decorator;

public class Vegetables extends Food {
    private Food basic_name;

    public Vegetables(Food basic_name) {
        this.basic_name = basic_name;
    }

    public String make(){
        return basic_name.make()+"+生菜";
    }
}
