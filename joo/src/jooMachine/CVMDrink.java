package jooMachine;

import java.util.Scanner;

public class CVMDrink implements IMenu {

	CStuff[] cstuff = new CStuff[] {};

	CVMDrink(CStuff[] cstuff) {
		this.cstuff = cstuff;
	}

	public CStuff[] getCstuff() {
		return cstuff;
	}

	public void setCstuff(CStuff[] cstuff) {
		this.cstuff = cstuff;
	}

	@Override
	public void Menu() {
		int num;
		System.out.println("�Ǹ� �޴� : 1.�ݶ�(1000��) / 2.���̴�(1500��) / 3.���ڿ���(1200��) / 4.���⿡��(1200��) /");
		Scanner scan = new Scanner(System.in);
		num = scan.nextInt();
		if (num == 1) {
			System.out.println("�ݶ���");
		} else if (num == 2) {
			System.out.println("���̴���");
		} else if (num == 3) {
			System.out.println("���ڿ�����");
		} else if (num == 4) {
			System.out.println("���⿡��");
		}
	}
}
