package test1;

public class Staff extends PersonInfo {
	private String depert, rank;

	Staff(String name, String address, String depert, String rank) {
		super(name, address);
		this.depert = depert;
		this.rank = rank;
	}

	public String getDepert() {
		return depert;
	}

	public String getRank() {
		return rank;
	}
	public  void StaffPrint(){
		System.out.println(getName()+"  /  "+getAddress()+"  /  "+depert+"  /  "+rank);
	}
	
}
