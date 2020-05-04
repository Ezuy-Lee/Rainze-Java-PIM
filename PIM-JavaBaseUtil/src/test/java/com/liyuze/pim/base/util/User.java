package com.liyuze.pim.base.util;

public class User {
	
	@Override
	public String toString() {
		return "User [age=" + age + ", name=" + name + ", nickName=" + nickName + ", sex=" + sex + "]";
	}
	private int age;
	private String name;
	private String nickName;
	private int sex;
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public User(int age, String name, String nickName, int sex) {
		super();
		this.age = age;
		this.name = name;
		this.nickName = nickName;
		this.sex = sex;
	}

	
}
