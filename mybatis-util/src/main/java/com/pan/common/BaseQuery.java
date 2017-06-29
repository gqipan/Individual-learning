package com.pan.common;

/**
 * query基类
 * 
 * */
public class BaseQuery {

	/** 缺省页大小 */
	public static final int DEFAULT_PAGE_SIZE = 20;

	/** 最大页大小 **/
	public static final int MAX_PAGE_SIZE = 1000;

	/**
	 * 页大小
	 */
	protected int pageSize;
	/**
	 * 总数
	 */
	private int totalRecord;
	/**
	 * 当前页
	 */
	private int pageIndex;

	/**
	 * 总页数
	 */
	private int totalPage;

	public int getPageSize() {
		if (pageSize < 1) {
			pageSize = DEFAULT_PAGE_SIZE;
		}
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	/**
	 * 总条目数
	 * 
	 * @param totalRecord
	 */
	public void setTotalRecord(int totalRecord) {
		this.totalPage = (totalRecord + getPageSize() - 1) / getPageSize();
		this.totalRecord = totalRecord;
	}

	/**
	 * 当前页
	 * 
	 * @return
	 */
	public int getPageIndex() {
		if (pageIndex < 1) {
			pageIndex = 1;
		} else if (pageIndex > getTotalPage()) {
			pageIndex = getTotalPage();
		}

		return pageIndex;
	}

	/**
	 * 获取传进来的原始的pageIndex
	 * 
	 * @param
	 * @return int
	 * @throws
	 */
	public int getOriginalPageIndex() {
		return pageIndex;
	}

	public boolean hasNextPage() {
		if (pageIndex <= getTotalPage()) {
			return true;
		} else {
			return false;
		}
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	/**
	 * oracleDB开始位置
	 * 
	 * @return
	 */
	public int getStartPos() {
		int cPage = getPageIndex();

		if (cPage <= 1) {
			return 1;
		}

		cPage--;

		int pgSize = getPageSize();

		return (pgSize * cPage) + 1;
	}

	/**
	 * mysqlDB开始位置
	 * 
	 * @return
	 */
	public int getStartPosForMysql() {
		int cPage = getPageIndex();

		if (cPage <= 1) {
			return 0;
		}

		cPage--;

		int pgSize = getPageSize();

		return (pgSize * cPage);
	}

	/**
	 * 结束位置
	 * 
	 * @return
	 */
	public int getEndPos() {
		if (getPageIndex() * getPageSize() < getTotalRecord()) {
			return getPageIndex() * getPageSize();
		} else {
			return getTotalRecord();
		}
	}

	/**
	 * 总页数
	 * 
	 * @return
	 */
	public int getTotalPage() {
		return totalPage;
	}

}
