package com.cskaoyan.erp.utils;



/**
 *  分页实体 
 */
public class PageModel {
	/** 分页总数据条数  */
	private int recordCount;
	/** 当前页面 */
	private int page ;
	/** 每页分多少条数据   */
	private int rows;
	
	/** 总页数  */
	private int totalSize;

	public int getRecordCount() {
		this.recordCount = this.recordCount <= 0 ? 0:this.recordCount;
		return recordCount;
	}
	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}
	public int getPage() {
		this.page = this.page <= 0?1:this.page;
		/** 判断当前页面是否超过了总页数:如果超过了默认给最后一页作为当前页  */
		this.page = this.page>=this.getTotalSize()?this.getTotalSize():this.page;
		
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	
	public int getTotalSize() {
		if(this.getRecordCount() <=0){
			totalSize = 0 ;
		}else{
			totalSize = (this.getRecordCount() -1)/this.getRows() + 1;
		}
		return totalSize;
	}
	
	
	public int getFirstLimitParam(){
		return (this.getPage()-1)*this.getRows() ;
	}

	
}
