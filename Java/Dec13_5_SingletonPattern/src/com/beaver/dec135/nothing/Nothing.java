package com.beaver.dec135.nothing;

public class Nothing {
	private String name;
	private int age;
	private String nickname;
	
	private static final Nothing NOTHING = new Nothing("마루", 5, "돼지");
	
	public static Nothing getNothing() {
		return NOTHING;
	}

	public Nothing() {
	}

	public Nothing(String name, int age, String nickname) {
		super();
		this.name = name;
		this.age = age;
		this.nickname = nickname;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public void printInfo() {
		System.out.printf("이름 : %s\n", name);
		System.out.printf("나이 : %d\n", age);
		System.out.printf("별명 : %s\n", nickname);
	}
}
