package com.atao.bean.definition;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * Bean 垃圾回收（GC）示例
 *
 * @author by ztsong
 * @Date 2022/8/9
 */
public class BeanGarbageCollectionDemo {

	public static void main(String[] args) throws InterruptedException {
		// 创建BeanFactory容器
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		// 注册 Configuration Class（配置类）
		applicationContext.register(BeanInitializationDemo.class);
		// 启动 Spring 应用上下文
		applicationContext.refresh();
		// 关闭 Spring 应用上下文
		applicationContext.close();
		Thread.sleep(5000L);
		// 强制触发 GC
		System.gc();
		Thread.sleep(5000L);
	}

}
