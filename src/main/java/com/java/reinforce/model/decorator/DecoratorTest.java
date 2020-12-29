package com.java.reinforce.model.decorator;

public class DecoratorTest {
    public static void main(String[] args) {
        Food food = new Bread(new Chicken(new Vegetables(new Food("奶油"))));
                System.out.println(food.make());
    }

}
