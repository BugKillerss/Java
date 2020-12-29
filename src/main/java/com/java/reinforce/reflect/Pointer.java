package com.java.reinforce.reflect;

public class Pointer {
	int x;
	int y;
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "Pointer{" +
				"x=" + x +
				", y=" + y +
				'}';
	}
}
