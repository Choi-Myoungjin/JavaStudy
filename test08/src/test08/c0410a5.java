package test08;

public class c0410a5 {
	public static void main(String[] args) {
		// "태양","수성","금성","지구","화성","목성","토성","천왕성","해왕성"
		String[] name = new String[] { "태양", "수성", "금성", "지구", "화성", "목성", "토성", "천왕성", "해왕성" };
		int aa, bb;
		aa=0;
		bb=0;
		
		String temp;

		
		for (int i = 0; i < name.length; i++) {
			// System.out.println(name[i]);

			if (name[i].equals("토성")) {
				System.out.println(i);
				aa = i;
			} else if (name[i].equals("지구")) {
				System.out.println(i);
				bb = i;
			}
		}
		for (int k = aa; k >= bb; k--) {
			

		}
	}
}
