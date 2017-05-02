package test1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str, str1, str2, str3;

		Student[] student = new Student[] { new Student("홍길동", "대전광역시", "1234 - 567890", 2, "경제"),
				new Student("유재석", "세종시", "1234 - 123456", 1, "컴퓨터") };

		Staff[] staff = new Staff[] { new Staff("하하", "서울", "교무부", "대리"), new Staff("박명수", "인천", "행정", "과장") };

		/////// 전체학생출력////
		System.out.println("	학생목록");
		for (int i = 0; i < student.length; i++) {
			student[i].StudentPrint();
		}
		System.out.println();
		//// 전체 교직원 목록///
		System.out.println(" 	교직원목록");
		for (int i = 0; i < staff.length; i++) {
			staff[i].StaffPrint();
		}
		System.out.println();

		//// 반복부분///
		while (true) {
			System.out.println("1.학생    /  2.교직원    /   3.종료");
			str = scan.nextLine();

			if (str.equals("1") || str.equals("학생")) {
				System.out.print("학번  : ");
				str1 = scan.nextLine();
			} else if (str.equals("2") || str.equals("교직원")) {
				System.out.println("ppppppp");
				str2 = scan.nextLine();
			} else if (str.equals("3") || str.equals("종료")) {
				System.out.println("ppppppp");
				break;
			} else {
				System.out.println("잘못입력함");
			}
		}

	}

}
