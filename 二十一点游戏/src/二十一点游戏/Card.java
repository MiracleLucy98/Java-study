package ��ʮһ����Ϸ;

public class Card {
	private int value = 0;  //ֽ����ֵ
	private int type = 0;  //ֽ�ƻ�ɫ
	public Card(int type, int value) {
		this.value = value;
		this.type = type;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
}
