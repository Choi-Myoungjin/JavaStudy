package test08;

public class c0411a3 {
	public static void main(String[] args) {
		// �ϳ��� 1000
		// ���� 900
		// �̴� 800
		// gs 1200
		// cu 1000

		String[] name = new String[] { "�ϳ���", "����", "�̴�", "GS", "CU" };
		int[] pay = new int[] { 1000, 900, 800, 1200, 1000 };
		
		int min = pay[0];
		int idx=0;
		for (int i = 0; i < pay.length; i++) {
			if (min > pay[i]) {
				min = pay[i];
				idx=i;
				System.out.println(min+"  "+i);
			}

		}
		System.out.println(min);
		System.out.println(name[idx]);

	}
}
