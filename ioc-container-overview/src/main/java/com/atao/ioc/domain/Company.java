package com.atao.ioc.domain;

/**
 * @author by ztsong
 * @Date 2022/8/9
 */
public class Company {

	String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Company{" +
				"name='" + name + '\'' +
				'}';
	}
}
