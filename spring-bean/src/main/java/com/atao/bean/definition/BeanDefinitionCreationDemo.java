package com.atao.bean.definition;

import com.atao.ioc.domain.User;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.GenericBeanDefinition;

/**
 * {@link org.springframework.beans.factory.config.BeanDefinition} 构建示例
 *
 * @author by ztsong
 * @Date 2022/8/9
 */
public class BeanDefinitionCreationDemo {

	public static void main(String[] args) {
		// 1.通过BeanDefinitionBuilder构建
		BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
		// 通过属性设置
		beanDefinitionBuilder
				.addPropertyValue("id", 1)
				.addPropertyValue("name", "阿涛");
		// 获取 BeanDefinition 实例
		AbstractBeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();
		// BeanDefinition 并非 Bean 终态，可以自定义修改
		System.out.println(beanDefinition.toString());

		// 2.通过 AbstractBeanDefinition 以及派生类
		GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
		// 设置 Bean 类型
		genericBeanDefinition.setBeanClass(User.class);
		// 通过 MutablePropertyValues 批量操作属性
		MutablePropertyValues propertyValues = new MutablePropertyValues();
//        propertyValues.addPropertyValue("id", 1);
//        propertyValues.addPropertyValue("name", "阿涛");
		propertyValues
				.add("id", 1)
				.add("name", "阿涛");
		// 通过 set MutablePropertyValues 批量操作属性
		genericBeanDefinition.setPropertyValues(propertyValues);

		System.out.println(genericBeanDefinition);
	}

}
