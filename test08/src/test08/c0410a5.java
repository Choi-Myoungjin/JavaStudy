package test08;

public class c0410a5 {
	public static void main(String[] args) {
		// "�¾�","����","�ݼ�","����","ȭ��","��","�伺","õ�ռ�","�ؿռ�"
		String[] name = new String[] { "�¾�", "����", "�ݼ�", "����", "ȭ��", "��", "�伺", "õ�ռ�", "�ؿռ�" };
		int aa, bb;
		aa=0;
		bb=0;
		
		String temp;

		
		for (int i = 0; i < name.length; i++) {
			// System.out.println(name[i]);

			if (name[i].equals("�伺")) {
				System.out.println(i);
				aa = i;
			} else if (name[i].equals("����")) {
				System.out.println(i);
				bb = i;
			}
		}
		for (int k = aa; k >= bb; k--) {
			

		}
	}
}
