package com.hm.common.vo;

import java.io.Serializable;
import java.util.List;

/**
 * vo(value object):值对象(封装数据,数据传递) 在这里要借助PageObject对象封装分页查询信息
 * 例如从数据层获取的当前记录,总记录数,以及基于总记录数计算的总页数
 * 
 * @author tarena
 *
 * @param <T>
 */
public class PageObject<T> implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8117569751489687299L;
	/** 当前页的记录信息 */
	private List<T> records;
	/** 总记录数 */
	private int rowCount;
	/** 总页数 */
	private int pageCount;
	/** 页面大小 */
	private int pageSize = 3;
	/** 当前页的页码 */
	private int pageCurrent = 1;

	public List<T> getRecords() {
		return records;
	}

	public void setRecords(List<T> records) {
		this.records = records;
	}

	public int getRowCount() {
		return rowCount;
	}

	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageCurrent() {
		return pageCurrent;
	}

	public void setPageCurrent(int pageCurrent) {
		this.pageCurrent = pageCurrent;
	}

	@Override
	public String toString() {
		return "PageObject [records=" + records + ", rowCount=" + rowCount + ", pageCount=" + pageCount + ", pageSize="
				+ pageSize + ", pageCurrent=" + pageCurrent + "]";
	}
	

}
