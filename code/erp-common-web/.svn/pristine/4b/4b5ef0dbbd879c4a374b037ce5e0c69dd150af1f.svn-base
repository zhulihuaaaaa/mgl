package com.maigangle.erp.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 权限拦截
 * 
 * @author zhuh
 * @since 2017年8月10日 下午2:59:37
 * @version 1.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Privilege {
	public String key() default "";// 直接跳转
}
