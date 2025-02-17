package com.beaver.dec134.avengers;


import com.beaver.dec134.driver.Driver;
import com.beaver.dec134.smoker.Smoker;

public class IronMan extends Avengers implements Smoker, Driver{ // dlrtmxpsem 먼저
	private String money; // 이거 하는 이유가 안보여주려고?
	
	public IronMan() {
		// TODO Auto-generated constructor stub
	}

	public IronMan(String name, int age, String money) {
		super(name, age);
		this.money = money;
	}

	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
	}
	
	@Override
	public void printInfo() {
		super.printInfo();
		System.out.printf("재산 : %s\n",  money);
	}
	@Override
	public void attack() {
		System.out.println("10조빔 발사 !");
	}
	
	@Override
	public void cigar() {
		System.out.println("너넨 이런거 피지 마라");
	}

	public void drive() {
		System.out.println("운전 쌉가능");
	}
	
	
}
