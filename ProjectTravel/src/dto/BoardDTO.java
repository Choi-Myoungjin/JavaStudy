package dto;

public class BoardDTO {
	
	private int num;
	private String name;
	private String content;
	private String reg_date;
	private String photo;
	private String map;
	
	public BoardDTO(){
		
	}
	
	public BoardDTO(String name, String photo) {
		super();
		
		this.name = name;
		this.photo = photo;
	}
	
	public BoardDTO(int num, String name, String content, String reg_date, String photo, String map) {
		super();
		this.num = num;
		this.name = name;
		this.content = content;
		this.reg_date = reg_date;
		this.photo = photo;
		this.map = map;
	}
	
	public BoardDTO(String name, String content, String photo, String map) {
		super();
		
		this.name = name;
		this.content = content;
		this.photo = photo;
		this.map = map;

	}
	
	public BoardDTO(String name, String content, String map, String photo, int num) {
		super();
		
		this.name = name;
		this.content = content;
		this.map = map;
		this.photo = photo;
		this.num = num;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getMap() {
		return map;
	}

	public void setMap(String map) {
		this.map = map;
	}
	
	
}
