package dto;

public class CommentDTO {
	private int num;
	private String id;
	private String pw;
	private String content;
	private String reg_date;
	private int link;
	
	
	public CommentDTO() {

	}
	
	public CommentDTO(int num, String id, String pw, String content, String reg_date, int link) {
		
		super();
		this.num = num;
		this.id = id;
		this.pw = pw;
		this.content = content;
		this.reg_date = reg_date;
		this.link = link;
	}

	public CommentDTO(String id, String pw, String content, int link) {
		
		super();
		this.id = id;
		this.pw = pw;
		this.content = content;
		this.link = link;
	}
	
	public CommentDTO(String id, String content, String reg_date) {
		
		super();
		this.id = id;
		this.content = content;
		this.reg_date = reg_date;
		
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getReg_date() {
		return reg_date;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	public int getLink() {
		return link;
	}
	public void setLink(int link) {
		this.link = link;
	}
}
