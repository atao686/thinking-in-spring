package com.atao.ioc.dependency.lookup;

import com.atao.ioc.domain.User;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 通过 {@link ObjectProvider} 进行依赖查找
 * @author by ztsong
 * @Date 2022/8/9
 */
public class ObjectProviderDemo {

	public static void main(String[] args) {
		// 创建 BeanFactory 容器
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		// 将当前类 ObjectProviderDemo 作为配置类（Configuration Class）
		applicationContext.register(ObjectProviderDemo.class);
		// 启动应用上下文
		applicationContext.refresh();

		// 依赖查找集合对象
		lookupByObjectProvider(applicationContext);
		lookupIfAvailable(applicationContext);
		lookupByStreamOps(applicationContext);

		// 关闭应用上下文
		applicationContext.close();

	}

	private static void lookupByStreamOps(AnnotationConfigApplicationContext applicationContext) {
		ObjectProvider<String> objectProvider = applicationContext.getBeanProvider(String.class);
//        Iterable<String> stringIterable = objectProvider;
//        for (String string : stringIterable) {
//            System.out.println(string);
//        }
		// Stream -> Method reference
		objectProvider.stream().forEach(System.out::println);
	}

	private static void lookupIfAvailable(AnnotationConfigApplicationContext applicationContext) {
		ObjectProvider<User> userObjectProvider = applicationContext.getBeanProvider(User.class);
		User user = userObjectProvider.getIfAvailable(User::createUser);
		System.out.println("当前 User 对象：" + user);
	}

	private static void lookupByObjectProvider(AnnotationConfigApplicationContext applicationContext) {
		ObjectProvider<String> objectProvider = applicationContext.getBeanProvider(String.class);
		System.out.println(objectProvider.getObject());
	}

}
