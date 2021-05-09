package com.maigangle.erp.common.tag;

import javax.servlet.jsp.JspException;

import org.springframework.web.servlet.tags.RequestContextAwareTag;

/**
 * 权限验证标签
 * 
 * @author 朱晗
 * @since 2016年12月5日 上午8:35:15
 * @version 1.0
 *
 */
public class PrivilegeTag extends RequestContextAwareTag {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4096860558125467873L;

	private String key;

	

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	@Override
	public int doEndTag() throws JspException {
		return super.doEndTag();
	}

	@Override
	public int doStartTagInternal() {
		return EVAL_BODY_INCLUDE;
	}

}
