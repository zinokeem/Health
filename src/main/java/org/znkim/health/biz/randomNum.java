package org.znkim.health.biz;
import java.util.*;
public class randomNum{
	public int perposeFloorNum(int countFloor) {
		Random random1 = new Random();
		return random1.nextInt(countFloor)+1;
	}
	public int waitFloorNum(int countFloor) {
		Random random2 = new Random();
		return random2.nextInt(countFloor)+1;
	}
	public int personAssignment(int countFloor) {
		Random random3 = new Random();
		return random3.nextInt(countFloor*(30/100))+1;
	}
}
