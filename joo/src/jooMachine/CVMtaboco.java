package jooMachine;

import java.util.Scanner;

public class CVMtaboco implements IMenu {
	CStuff[] cstuff1 = new CStuff[] {};

	CVMtaboco(CStuff[] cstuff1) {
		this.cstuff1 = cstuff1;
	}

	@Override
	public void Menu() {
		System.out.println("!!!�̼����� ���ΰ�!!!");
		
		System.out.println("�ź�Ȯ�� ���̸� �Է��Ͻÿ�");
		
		Scanner scan = new Scanner(System.in);
		
		int age = scan.nextInt();
		scan.nextLine();
		
		if (age >= 20) {
			System.out.println("�Ǹ� �޴� : 1.����(4500��) / 2.������(1500��) / 3.��(1200��)");
			
			int num1 = scan.nextInt();
			scan.nextLine();
			
			if (num1 == 1) {
				System.out.println("���� ��");
			} else if (num1 == 2) {
				System.out.println("������ ��");
			} else if (num1 == 3) {
				System.out.println("�� ��");
			}
			
		} else if (age <= 19) {
			System.out.println("�̼�������");
		}
	}

}
