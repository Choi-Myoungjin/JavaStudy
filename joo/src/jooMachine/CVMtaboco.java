package jooMachine;

import java.util.Scanner;

public class CVMtaboco implements IMenu {
	CStuff[] cstuff1 = new CStuff[] {};

	CVMtaboco(CStuff[] cstuff1) {
		this.cstuff1 = cstuff1;
	}

	@Override
	public void Menu() {
		System.out.println("!!!미성년자 절로가!!!");
		
		System.out.println("신분확인 나이를 입력하시오");
		
		Scanner scan = new Scanner(System.in);
		
		int age = scan.nextInt();
		scan.nextLine();
		
		if (age >= 20) {
			System.out.println("판매 메뉴 : 1.더원(4500원) / 2.말보로(1500원) / 3.디스(1200원)");
			
			int num1 = scan.nextInt();
			scan.nextLine();
			
			if (num1 == 1) {
				System.out.println("더원 ㄱ");
			} else if (num1 == 2) {
				System.out.println("말보로 ㄱ");
			} else if (num1 == 3) {
				System.out.println("디스 ㄱ");
			}
			
		} else if (age <= 19) {
			System.out.println("미성년자임");
		}
	}

}
