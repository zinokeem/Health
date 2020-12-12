package org.znkim.health.biz;

import java.util.ArrayList;

public class Floor {
	boolean up, down; // 현재 층의 올라감 버튼, 내림 활성화 상태
	ArrayList<Person> waitPeoples; // 기다리고 있는 사람들

	public Floor(ArrayList<Person> waitPeoples, boolean up, boolean down) {
		this.up = up;
		this.down = down;
		this.waitPeoples = waitPeoples;
	}
}
