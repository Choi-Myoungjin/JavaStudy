package test08;

public class c0411a1 {
	public static void main(String[] args) {
		// "�¾�","����","�ݼ�","����","ȭ��","��","�伺","õ�ռ�","�ؿռ�"
		String[] solar = new String[] { "�¾�", "����", "�ݼ�", "����", "ȭ��", "��", "�伺", "õ�ռ�", "�ؿռ�" };

		String temp;

		temp = solar[3];
		solar[3] = solar[6];
//		solar[6]=temp;

		for (int i = 0; i < solar.length; i++) {
		System.out.println(solar[i]);
		}
	}

}