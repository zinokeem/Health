package org.znkim.health.biz;

public class Person {
	private int perposeFloor;
	private int currentFloor;
	private int status;		// 1:up, -1: down, 0:그자리그대로
	public Person(int perposeFloor, int currentFloor) {
		this.perposeFloor = perposeFloor;
		this.currentFloor = currentFloor;
		if(perposeFloor>currentFloor) this.status = 1;
		else if(perposeFloor<currentFloor) this.status =-1;
		else this.status =0;
	}
	public boolean compare(int elevatorFloor) {
		return true;
	}
}
