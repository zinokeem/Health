package org.znkim.health.biz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.znkim.health.model.ElevatorModel;

public class ElevatorLogic {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public ElevatorLogic() {
		// TODO 여기에 코드짜면 됨
	}
	
	public void excute() {
		logger.info("[info]excute 실행됨 :: ");
		// TODO 실행코드
	}
	
	public ElevatorModel getServerData() {
		logger.info("[info]서버 데이터 생성 :: ");
		ElevatorModel em = new ElevatorModel();
		em.setFloorCount(0);
		em.setCurrentFloor(0);
		em.setStatus(0);
		return em;
	}
}
