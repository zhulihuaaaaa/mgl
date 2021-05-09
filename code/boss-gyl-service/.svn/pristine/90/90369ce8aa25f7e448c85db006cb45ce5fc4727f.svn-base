package com.maigangle.gyl.service.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * ApplicationContext工具类
 * @author 张渊
 * @since 2018年1月5日 下午1:39:23
 * @version 1.0
 */
@Component
public class ApplicationContextUtils implements ApplicationContextAware {
	private static ApplicationContext applicationContext = null;
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		if (ApplicationContextUtils.applicationContext == null)
			ApplicationContextUtils.applicationContext = applicationContext;
	}
	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}
	public static Object getBean(String name) {
		if (getApplicationContext() != null) {
			try {
				return getApplicationContext().getBean(name);
			} catch (NoSuchBeanDefinitionException e) {
				return null;
			}
		}
		return null;
	}
	public static <T> T getBean(Class<T> beanClass) {
		if (getApplicationContext() != null) {
			return getApplicationContext().getBean(beanClass);
		}
		return null;
	}
}
