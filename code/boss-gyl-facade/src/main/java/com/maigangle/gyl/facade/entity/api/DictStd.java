package com.maigangle.gyl.facade.entity.api;

import java.io.Serializable;
/**
 * 执行标准
 * @author 张渊
 * @since 2018年2月2日 上午8:47:05
 * @version 1.0
 */
public class DictStd implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3065176916742106842L;
	
	private String stdName;

	public String getStdName() {
		return stdName;
	}

	public void setStdName(String stdName) {
		this.stdName = stdName;
	}
}
