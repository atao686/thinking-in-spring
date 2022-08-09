package com.atao.bean.definition;

import com.atao.bean.factory.DefaultUserFactory;
import com.atao.bean.factory.UserFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * Bean 初始化 Demo
 *
 * @author by ztsong
 * @Date 2022/8/9
 */
@Configuration
public class BeanInitializationDemo {

	public static void main(String[] args) {
		// 创建 BeanFactory 容器
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		// 注册 Configuration Class（配置类）
		applicationContext.register(BeanInitializationDemo.class);
		// 启动 Spring 应用上下文
		applicationContext.refresh();

		// 非延迟初始化在 Spring 应用上下文启动完成后，被初始化
		System.out.println("Spring 应用上下文已启动...");

		// 依赖查找 UserFactory
		UserFactory userFactory = applicationContext.getBean(UserFactory.class);
		System.out.println(userFactory);

		System.out.println("Spring 应用上下文准备关闭...");
		// 关闭 Spring 应用上下文
		applicationContext.close();
		System.out.println("Spring 应用上下文已关闭...");
	}

	@Bean(initMethod = "initUserFactory", destroyMethod = "doDestroy")
	@Lazy(value = false)
	public UserFactory userFactory() {
		return new DefaultUserFactory();
	}

}