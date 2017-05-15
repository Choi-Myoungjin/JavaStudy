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
		System.out.println("판매 메뉴 : 1.콜라(1000원) / 2.사이다(1500원) / 3.초코에몽(1200원) / 4.딸기에몽(1200원) /");
		Scanner scan = new Scanner(System.in);
		num = scan.nextInt();
		if (num == 1) {
			System.out.println("콜라임");
		} else if (num == 2) {
			System.out.println("사이다임");
		} else if (num == 3) {
			System.out.println("초코에몽임");
		} else if (num == 4) {
			System.out.println("딸기에몽");
		}
	}
}
