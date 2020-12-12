package org.znkim.health.biz;

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
				
			}
		} else if(status == -1) {
			for (int i = currentFloor; i >= min; i--) {
					
			}
		}
	}
}
