package org.znkim.health.model;

import java.util.ArrayList;

import org.znkim.health.biz.Floor;

public class ElevatorModel {
	int status; // -1은 내려감, 0은 중립, 1은 올라가고 있음
	int floorCount; // 건물의 층수
	int currentFloor; // 현재 엘리베이터의 층
	int min,max;
	String data; // 기타 데이터
	ArrayList<Floor> floorList; // 층마다의 데이터
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getFloorCount() {
		return floorCount;
	}
	public void setFloorCount(int floorCount) {
		this.floorCount = floorCount;
	}
	public int getCurrentFloor() {
		return currentFloor;
	}
	public void setCurrentFloor(int currentFloor) {
		this.currentFloor = currentFloor;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public int getMin() {
		return min;
	}
	public void setMin(int min) {
		this.min = min;
	}
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
	}
	public ArrayList<Floor> getFloorList() {
		return floorList;
	}
	public void setFloorList(ArrayList<Floor> floorList) {
		this.floorList = floorList;
	}
}
