package com.dek.entity;

public class User {

	private String id;
	private String userName;
	private Integer age;

	public User() {
		System.out.println("无参构造函数.....");
	}

	public User(String userName, Integer age) {
		System.out.println("有参构造函数 userName:"+userName+",age:"+age);
		this.userName = userName;
		this.age = age;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserName() {

		return userName;
	}

	public void setUserName(String userName) {

		this.userName = userName;
	}

	public Integer getAge() {

		return age;
	}

	public void setAge(Integer age) {

		this.age = age;
	}

	@Override
	public String toString() {
		return "User{" +
				"id='" + id + '\'' +
				", userName='" + userName + '\'' +
				", age=" + age +
				'}';
	}
}
