package com.beaver.franc.Restaurant;

public class Restaurant {
	private String location; 	// 지점
	private String owner;		// 지점장
	private int seat;			// 좌석수

	public Restaurant() {
		// TODO Auto-generated constructor stub
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public int getSeat() {
		return seat;
	}

	public void setSeat(int seat) {
		this.seat = seat;
	}

	public Restaurant(String location, String owner, int seat) {
		super();
		this.location = location;
		this.owner = owner;
		this.seat = seat;
	}
	
	
	
}
