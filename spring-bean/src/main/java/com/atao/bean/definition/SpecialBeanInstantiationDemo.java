package com.atao.bean.definition;

import com.atao.bean.factory.DefaultUserFactory;
import com.atao.bean.factory.UserFactory;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * 特殊的 Bean 实例化示例
 *
 * @author by ztsong
 * @Date 2022/8/9
 */
public class SpecialBeanInstantiationDemo {

	public static void main(String[] args) {
		// 配置 XML 配置文件
		// 启动 Spring 应用上下文
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/META-INF/special-bean-instantiation-context.xml");
		// 通过 ApplicationContext 获取 AutowireCapableBeanFactory
		AutowireCapableBeanFactory beanFactory = applicationContext.getAutowireCapableBeanFactory();

		ServiceLoader<UserFactory> serviceLoader = beanFactory.getBean("userFactoryServiceLoader", ServiceLoader.class);

		displayServiceLoader(serviceLoader);

		// 创建 UserFactory 对象，通过 AutowireCapableBeanFactory
		UserFactory userFactory = beanFactory.createBean(DefaultUserFactory.class);
		System.out.println(userFactory.createUser());

	}

	private static void displayServiceLoader(ServiceLoader<UserFactory> serviceLoader) {
		Iterator<UserFactory> iterator = serviceLoader.iterator();
		while (iterator.hasNext()) {
			UserFactory userFactory = iterator.next();
			System.out.println(userFactory.createUser());
		}
	}


}
