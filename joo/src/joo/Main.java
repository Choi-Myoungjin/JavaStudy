package joo;

public class Main {
	public static void main(String[] args) {
		IManageInfo[] info1 = new CMammal[] { new CMammal("����", "����", "���缮", 2, 123456),
				new CMammal("ȣ����", "ȣ����", "��ȣ��", 1, 123455) };
		IManageInfo[] info2 = new CBird[] { new CBird("��ũ", "ȫ��", "�迬��", 3, "2016.12.26", 223457),
				new CBird("�����", "�޹���", "���ϴ�", 0.5, "2016.12.27", 223458) };

		for (int i = 0; i < info1.length; i++) {
			System.out.println(info1[i].Name() + "/" + info1[i].Type() + "/" + info1[i].MName() + "/" + info1[i].age()
					+ "/" + info1[i].Mnumber());
		}
		for (int i = 0; i < info2.length; i++) {
			System.out.println(info2[i].Name() + "/" + info2[i].Type() + "/" + info2[i].MName() + "/" + info2[i].age()
					+ "/" + info2[i].AI() + "/" + info2[i].Mnumber());
		}

	}
}
