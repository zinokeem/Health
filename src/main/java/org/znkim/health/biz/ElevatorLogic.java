package org.znkim.health.biz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.znkim.health.model.ElevatorModel;

public class ElevatorLogic {
	int status = 0;		//up : 1 , down : -1 값 
	int max, min;
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public ElevatorLogic() {
		// TODO �뿬湲곗뿉 肄붾뱶吏쒕㈃ �맖
	}
	
	public void excute() {
		logger.info("[info]excute �떎�뻾�맖 :: ");
		// TODO �떎�뻾肄붾뱶
	}
	
	public ElevatorModel getServerData() {
		logger.info("[info]�꽌踰� �뜲�씠�꽣 �깮�꽦 :: ");
		ElevatorModel em = new ElevatorModel();
		em.setFloorCount(0);
		em.setCurrentFloor(0);
		em.setStatus(0);
		return em;
	}	
	public void compare(int currentFloor, int newFloor) {	// 현재 층과 처음으로 버튼 누른 층 비교
		if(status ==0) {
		if(currentFloor<newFloor) {
			max = newFloor;
			status = 1;
		}
		else if(currentFloor>newFloor) {
			min = newFloor;
			status = -1;
		}
	}
		else {
			if(max<newFloor) {
				max = newFloor;
				status = 1;
			}
			else if(min>newFloor) {
				min = newFloor;
				status = -1;
			}
		}
}
	public void Moving(int currentFloor,int newFloor) {		// 여기서 부터 아직 만드는 중 
		if(status == 1) {
			for(int i = currentFloor; i<=max; i++) {
				
			}
		}
		else if(status ==-1) {
			for(int i = currentFloor; i>=min; i--) {
					
			}
		}
	}
}
