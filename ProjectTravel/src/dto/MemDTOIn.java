package dto;

public class MemDTOIn {

	private String id;
	private String pw;
	private String phone;
	private String reg_date;
	private int lv;
	private String name;
	private String info;
	private String photo;

	public MemDTOIn() {

	}

	public MemDTOIn(String id, String pw, String phone) {

		super();

		this.id = id;
		this.pw = pw;
		this.phone = phone;

	}

	public MemDTOIn(String id, String pw, String phone, String reg_date) {

		super();

		this.id = id;
		this.pw = pw;
		this.phone = phone;
		this.reg_date = reg_date;

	}

	public MemDTOIn(String id, String name, String info, String photo, String phone) {

		super();

		this.id = id;
		this.name = name;
		this.info = info;
		this.photo = photo;
		this.phone = phone;
	}

	public MemDTOIn(String id, String pw, String phone, String reg_date, int lv) {

		super();

		this.id = id;
		this.pw = pw;
		this.phone = phone;
		this.reg_date = reg_date;
		this.lv = lv;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getReg_date() {
		return reg_date;
	}

	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}

	public int getLv() {
		return lv;
	}

	public void setLv(int lv) {
		this.lv = lv;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

}
