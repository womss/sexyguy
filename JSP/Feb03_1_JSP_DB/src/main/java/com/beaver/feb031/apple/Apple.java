package com.beaver.feb031.apple;

public class Apple {
	// DB에서의 컬럼명과, Java에서의 멤버변수명, Jsp에서의 요청파라미터명을 전부 동일하게 짓는 습관 필요★★★★★
	private String a_location;
	private String a_color;
	private String a_flavor;
	private int a_price;
	private String a_info;
	
	public Apple() {
		// TODO Auto-generated constructor stub
	}

	public Apple(String a_location, String a_color, String a_flavor, int a_price, String a_info) {
		super();
		this.a_location = a_location;
		this.a_color = a_color;
		this.a_flavor = a_flavor;
		this.a_price = a_price;
		this.a_info = a_info;
	}

	public String getA_location() {
		return a_location;
	}

	public void setA_location(String a_location) {
		this.a_location = a_location;
	}

	public String getA_color() {
		return a_color;
	}

	public void setA_color(String a_color) {
		this.a_color = a_color;
	}

	public String getA_flavor() {
		return a_flavor;
	}

	public void setA_flavor(String a_flavor) {
		this.a_flavor = a_flavor;
	}

	public int getA_price() {
		return a_price;
	}

	public void setA_price(int a_price) {
		this.a_price = a_price;
	}

	public String getA_info() {
		return a_info;
	}

	public void setA_info(String a_info) {
		this.a_info = a_info;
	}
	
	
	
}


