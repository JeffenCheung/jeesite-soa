package com.pactera.jeesite.modules.soa.entity;

public class UserVO {

	public UserVO() {

	}

	public UserVO(String name) {
		super();
		this.name = name;
	}

	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	private int age;
	private String name;

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

	public String getUserVO() {
		// TODO Auto-generated method stub
		return "name:" + this.name + ", age:" + this.age;
	}

}
