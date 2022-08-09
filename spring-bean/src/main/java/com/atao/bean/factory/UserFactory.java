package com.atao.bean.factory;

import com.atao.ioc.domain.User;

/**
 * 工厂类
 *
 * @author by ztsong
 * @Date 2022/8/9
 */
public interface UserFactory {

	default User createUser() {
		return User.createUser();
	}

}
