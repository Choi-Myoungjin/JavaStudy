package joo;

public class CBird implements IManageInfo {

	String Name, Type, MName, AI;
	int Mnumber;
	double age;

	@Override
	public String Name() {
		return Name;
	}

	@Override
	public String Type() {
		return Type;
	}

	@Override
	public String MName() {
		return MName;
	}

	@Override
	public double age() {
		return age;
	}

	@Override
	public String AI() {
		return AI;
	}

	@Override
	public int Mnumber() {
		return Mnumber;
	}

	CBird(String Name, String Type, String MName, double age, String AI, int Mnumber) {
		this.Name = Name;
		this.Type = Type;
		this.MName = MName;
		this.age = age;
		this.AI = AI;
		this.Mnumber = Mnumber;
	}
}
