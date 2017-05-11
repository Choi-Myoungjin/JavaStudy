package joo;

public class CMammal implements IManageInfo {
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
		String str = "Àû¿ë¾ÈµÊ";
		return str;
	}

	@Override
	public int Mnumber() {
		return Mnumber;
	}

	CMammal(String Name, String Type, String MName, double age, int Mnumber) {
		this.Name = Name;
		this.Type = Type;
		this.MName = MName;
		this.age = age;
		this.Mnumber = Mnumber;
	}

}
