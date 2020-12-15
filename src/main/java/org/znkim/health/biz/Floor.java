package org.znkim.health.biz;

import java.util.ArrayList;

import org.znkim.health.model.ElevatorModel;

public class Floor {
	boolean up, down; // 현재 층의 올라감 버튼, 내림 활성화 상태
	
	private ArrayList<Person> waitPeoples; // 기다리고 있는 사람들
	private ArrayList<Person> insideTheElevator;  // 엘레베이터에 탑승한 사람들
	public Floor(ArrayList<Person> waitPeoples, boolean up, boolean down) {
		this.up = up;
		this.down = down;
		this.waitPeoples = waitPeoples;
	}
	public Floor() {
	waitPeoples =new ArrayList<Person>();
	insideTheElevator = new ArrayList<Person>();
	this.insideTheElevator = insideTheElevator;
	this.waitPeoples = waitPeoples;
	}
	
	public ArrayList<Person> getWaitPeoples() {
		return waitPeoples;
	}
	public void setWaitPeoples(ArrayList<Person> waitPeoples) {
		this.waitPeoples = waitPeoples;
	}
	public ArrayList<Person> getInsideTheElevator() {
		return insideTheElevator;
	}
	public void setInsideTheElevator(ArrayList<Person> insideTheElevator) {
		this.insideTheElevator = insideTheElevator;
	}
}
