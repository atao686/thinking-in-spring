package com.atao.bean.factory;

import com.atao.ioc.domain.User;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author by ztsong
 * @Date 2022/8/9
 */
public class UserFactoryBean implements FactoryBean {
	@Override
	public Object getObject() throws Exception {
		return User.createUser();
	}

	@Override
	public Class<?> getObjectType() {
		return User.class;
	}
}
