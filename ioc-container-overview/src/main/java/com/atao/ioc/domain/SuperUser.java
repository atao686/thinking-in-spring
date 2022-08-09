package com.atao.ioc.domain;

import com.atao.ioc.annotation.Super;

/**
 * @author by ztsong
 * @Date 2022/8/2
 * @Description TODO
 */
@Super
public class SuperUser extends User {

	private String address;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "SuperUser{" +
				"address='" + address + '\'' +
				"} " + super.toString();
	}
}
