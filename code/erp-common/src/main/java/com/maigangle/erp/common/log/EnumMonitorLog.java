package com.maigangle.erp.common.log;

/**
 * 日志相关enum
 * 
 * @author 朱晗
 * @since 2017年1月17日 下午6:29:15
 * @version 1.0
 *
 */
public enum EnumMonitorLog {
	/** 后台系统 */
	LOGSYSTEM_SETTLEMENT("SETTLEMENT", "后台系统"),LOGSYSTEM_GYL("SETTLEMENT", "供应链系统");
	private String key;
	private String info;

	private EnumMonitorLog(String key, String info) {
		this.key = key;
		this.info = info;
	}

	public static String getSexInfo(String key) {
		for (EnumMonitorLog sex : values()) {
			if (sex.getKey().equals(key)) {
				return sex.getInfo();
			}
		}
		return "";
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

}
