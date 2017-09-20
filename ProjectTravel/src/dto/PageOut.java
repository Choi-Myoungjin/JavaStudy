package dto;

public class PageOut 
{
	private int pageNo;     
	private int pageSize;   
	private int total;      
	private int pageNum;    
	private int prevPage;   
	private int nextPage;   
	
	public PageOut(int pageNo, int pageSize, int total, int pageNum, int prevPage, int nextPage) 
	{
		super(); 
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		this.total = total;
		this.pageNum = pageNum;
		this.prevPage = prevPage;
		this.nextPage = nextPage;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}


	public int getPageNum() {
		return pageNum;
	}


	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}


	public int getPrevPage() {
		return prevPage;
	}


	public void setPrevPage(int prevPage) {
		this.prevPage = prevPage;
	}


	public int getNextPage() {
		return nextPage;
	}


	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}
	
}
