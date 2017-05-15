package jooMachine;

import java.util.Scanner;

import java.util.InputMismatchException;

public class Main {
	public static void main(String[] args) {
		CStuff[] drink = new CStuff[] { new CStuff("콜라", 1000), new CStuff("사이다", 1500), new CStuff("초코에몽", 1200),
				new CStuff("딸기에몽", 1200) };
		CStuff[] taboco = new CStuff[] { new CStuff("더원", 4500), new CStuff("말보로", 1500), new CStuff("디스", 1200) };

		IMenu drink1 = new CVMDrink(drink);
		IMenu tabaco1 = new CVMtaboco(taboco);

		while (true) {
			try {
				System.out.println("메뉴 : 1.음료수 2.담배 3.종료");
				Scanner scan = new Scanner(System.in);
				int numb = scan.nextInt();
				scan.nextLine();
				if (numb == 1) {
					drink1.Menu();
				} else if (numb == 2) {
					tabaco1.Menu();
				} else if (numb == 3) {
					System.out.println("종료");
					break;
				}
			} catch (InputMismatchException ie) {
				System.out.println("숫자를 입력해주세요");
			}
		}
	}

}
