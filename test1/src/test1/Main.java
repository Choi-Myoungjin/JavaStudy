package test1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str, str1, str2, str3;

		Student[] student = new Student[] { new Student("ȫ�浿", "����������", "1234 - 567890", 2, "����"),
				new Student("���缮", "������", "1234 - 123456", 1, "��ǻ��") };

		Staff[] staff = new Staff[] { new Staff("����", "����", "������", "�븮"), new Staff("�ڸ���", "��õ", "����", "����") };

		/////// ��ü�л����////
		System.out.println("	�л����");
		for (int i = 0; i < student.length; i++) {
			student[i].StudentPrint();
		}
		System.out.println();
		//// ��ü ������ ���///
		System.out.println(" 	���������");
		for (int i = 0; i < staff.length; i++) {
			staff[i].StaffPrint();
		}
		System.out.println();

		//// �ݺ��κ�///
		while (true) {
			System.out.println("1.�л�    /  2.������    /   3.����");
			str = scan.nextLine();

			if (str.equals("1") || str.equals("�л�")) {
				System.out.print("�й�  : ");
				str1 = scan.nextLine();
			} else if (str.equals("2") || str.equals("������")) {
				System.out.println("ppppppp");
				str2 = scan.nextLine();
			} else if (str.equals("3") || str.equals("����")) {
				System.out.println("ppppppp");
				break;
			} else {
				System.out.println("�߸��Է���");
			}
		}

	}

}