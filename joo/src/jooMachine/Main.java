package jooMachine;

import java.util.Scanner;

import java.util.InputMismatchException;

public class Main {
	public static void main(String[] args) {
		CStuff[] drink = new CStuff[] { new CStuff("�ݶ�", 1000), new CStuff("���̴�", 1500), new CStuff("���ڿ���", 1200),
				new CStuff("���⿡��", 1200) };
		CStuff[] taboco = new CStuff[] { new CStuff("����", 4500), new CStuff("������", 1500), new CStuff("��", 1200) };

		IMenu drink1 = new CVMDrink(drink);
		IMenu tabaco1 = new CVMtaboco(taboco);

		while (true) {
			try {
				System.out.println("�޴� : 1.����� 2.��� 3.����");
				Scanner scan = new Scanner(System.in);
				int numb = scan.nextInt();
				scan.nextLine();
				if (numb == 1) {
					drink1.Menu();
				} else if (numb == 2) {
					tabaco1.Menu();
				} else if (numb == 3) {
					System.out.println("����");
					break;
				}
			} catch (InputMismatchException ie) {
				System.out.println("���ڸ� �Է����ּ���");
			}
		}
	}

}
