package ������;

import java.util.Random;

public class Die {
	private int faceValue;
	public void roll() {
		Random random = new Random();
		this.faceValue = Math.abs(random.nextInt()) % 6 + 1;  //ȡ1~6����������
	}
	
	public int getFaceValue() {
		return this.faceValue;
	}
}
