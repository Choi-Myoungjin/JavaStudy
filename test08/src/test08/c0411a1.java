package test08;

public class c0411a1 {
	public static void main(String[] args) {
		// "태양","수성","금성","지구","화성","목성","토성","천왕성","해왕성"
		String[] solar = new String[] { "태양", "수성", "금성", "지구", "화성", "목성", "토성", "천왕성", "해왕성" };

		String temp;

		temp = solar[3];
		solar[3] = solar[6];
//		solar[6]=temp;

		for (int i = 0; i < solar.length; i++) {
		System.out.println(solar[i]);
		}
	}

}