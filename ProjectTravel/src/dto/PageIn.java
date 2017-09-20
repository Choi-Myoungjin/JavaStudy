package dto;

public class PageIn {

	private int pageNo;
	private int pageSize;
	private int mode;
	private String word;
	private String type;
	
	
	public PageIn(int pageNo, int pageSize, int mode, String word) {
		super();
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		this.mode = mode;
		this.word = word;
	}
	
	public PageIn(int pageNo, int pageSize, int mode, String word, String type) {
		super();
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		this.mode = mode;
		this.word = word;
		this.type = type;
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

	public int getMode() {
		return mode;
	}

	public void setMode(int mode) {
		this.mode = mode;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
}
