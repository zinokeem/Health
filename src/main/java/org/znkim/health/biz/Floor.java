package org.znkim.health.biz;

import java.util.ArrayList;

import org.znkim.health.model.ElevatorModel;

public class Floor {
	boolean up, down; // 현재 층의 올라감 버튼, 내림 활성화 상태
	ArrayList<Person> waitPeoples; // 기다리고 있는 사람들
	ArrayList<Person> insideTheElevator;  // 엘레베이터에 탑승한 사람들
	public Floor(ArrayList<Person> waitPeoples, boolean up, boolean down) {
		this.up = up;
		this.down = down;
		this.waitPeoples = waitPeoples;
	}
	public Floor(ArrayList<Person> insideTheElevator) {
		this.insideTheElevator = insideTheElevator;
	}
}
