package com.maigangle.erp.common.page;

import java.io.Serializable;
import java.util.List;

/**
 * 分页返回结果
 * 
 * @author 朱晗
 * @since 2016年12月2日 下午4:49:29
 * @version 1.0
 *
 */
public class BaseResultDto<T> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4289698045550970704L;
	private int currentPageNo;
	private int pageSize;
	private long totalRecords;

	private List<T> results;

	public BaseResultDto() {}

	public BaseResultDto(int currentPageNo, int pageSize, long totalRecords, List<T> results) {
		super();
		this.currentPageNo = currentPageNo;
		this.pageSize = pageSize;
		this.totalRecords = totalRecords;
		this.results = results;
	}

	public int getCurrentPageNo() {
		return currentPageNo;
	}

	public void setCurrentPageNo(int currentPageNo) {
		this.currentPageNo = currentPageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public long getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(long totalRecords) {
		this.totalRecords = totalRecords;
	}

	public List<T> getResults() {
		return results;
	}

	public void setResults(List<T> results) {
		this.results = results;
	}

}
