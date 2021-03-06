package org.znkim.health.biz;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.znkim.health.model.ElevatorModel;

public class ElevatorLogic {
	ElevatorModel model;
	int max, min;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public ElevatorLogic() {
		model = new ElevatorModel();
		model.setCurrentFloor(10);
		model.setFloorCount(1);
		model.setStatus(0);
	}
	
	public void excute() {
		logger.info("[info]excute 실행 :: ");
	}
	
	public ElevatorModel getServerData() {
		return model;
	}	
	public void compare(int newFloor) { // 현재 층과 처음으로 버튼 누른 층 비교
		int status = model.getStatus();
		int currentFloor = model.getCurrentFloor();
		if (status == 0) {
			if(currentFloor < newFloor) {
				model.setMax(newFloor);
				status = 1;
			}
			else if (currentFloor > newFloor) {
				model.setMin(newFloor);
				status = -1;
			}
		} else {
			if(max < newFloor) {
				model.setMax(newFloor);
				status = 1;
			}
			else if(min > newFloor) {
				model.setMin(newFloor);
				status = -1;
			}
		}
	}
	public void moving(int newFloor) { // 여기서 부터 아직 만드는 중 
		int status = model.getStatus();
		int currentFloor = model.getCurrentFloor();
		if (status == 1) {
			for (int i = currentFloor; i <= max; i++) {
				model.setCurrentFloor(i);
				model.getFloorList().get(i).getInsideTheElevator().addAll(model.getFloorList().get(i-1).getInsideTheElevator());
				person_out(status,i,model.getCurrentFloor());
				 person_In(status,i);
				 creatUnit();		// 임시
			}
		} else if(status == -1) {
			for (int i = currentFloor; i >= min; i--) {
				model.setCurrentFloor(i);
				model.getFloorList().get(i).getInsideTheElevator().addAll(model.getFloorList().get(i+1).getInsideTheElevator());
				 person_out(status,i,model.getCurrentFloor());
				 person_In(status,i);
				 creatUnit();		//임시
			}
		}
	}
	public void initFloor() {						// 각 층 초기화
		int floorcount = model.getFloorCount();
		for(int i=0; i<floorcount; i++) {
		Floor floor = new Floor();
		model.getFloorList().add(floor);	 
		}
	}
	public void creatUnit() {						// 각 층에 사람을 랜덤으로 넣음
	randomNum rand = new randomNum();
	Person person;
	int floorcount = model.getFloorCount();
	for(int i=0; i<rand.personAssignment(floorcount);i++) {	//랜덤값으로 인원 배정한 만큼 반복
		person = new Person(rand.perposeFloorNum(floorcount),rand.waitFloorNum(floorcount));	//사람생성
		model.getFloorList().get(rand.waitFloorNum(floorcount)).getWaitPeoples().add(person);//사람을 각 층에 대기하는 사람 리스트에 넣음
	}	
}
	public void person_In(int status,int n) {				//각 층의 사람들 상태에 맞게 엘레베이터에 탑승시킴
		ArrayList<Person> array = new ArrayList<Person>();
		array.addAll(model.getFloorList().get(n).getWaitPeoples());
		if(status ==1) {
			for(Person p : array) {
				if(1==p.getStatus()) { 
					model.getFloorList().get(n).getInsideTheElevator().add(p);       	// 엘레베이터 내부에 탑승
					model.getFloorList().get(n).getWaitPeoples().remove(p);			//엘레베이터 외부의 대기 사람 제거
					delay(1);									//한명이 탑승하는 시간 
				}else continue;
			}
		}
		else if(status == -1) {
			for(Person p : array) {
				if(-1==p.getStatus()) { 
					//floor[n].getInsideTheElevator().add(p);
					model.getFloorList().get(n).getInsideTheElevator().add(p);		// 엘레베이터 내부에 탑승
					model.getFloorList().get(n).getWaitPeoples().remove(p);		//엘레베이터 외부의 대기 사람 제거
					delay(1);
				}else continue;
			}
		}
	}
	public void person_out(int status, int n,int currentFloor) {		// 목적 층에 도착한 사람들 엘레베이터에서 제거
		ArrayList<Person> array = new ArrayList<Person>();
		array.addAll(model.getFloorList().get(n).getInsideTheElevator());
		for(Person p : array) {
		if(currentFloor == p.getPerposeFloor()) {
			delay(500);
			model.getFloorList().get(n).getInsideTheElevator().remove(p);
		}else continue;
		}
	}
	public void delay(int second) {
		try {
			Thread.sleep(second);
		}
		catch(InterruptedException e) {
			System.err.format("IOException: %s%n", e);
		}
	}
}