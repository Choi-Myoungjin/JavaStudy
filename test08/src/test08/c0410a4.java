package test08;

public class c0410a4 {
	public static void main(String[] args) {
		// 영시점수평균
		// 88.5
		// 85
		// 77..65
		// 70
		// 90
		// 66
		// 90
		// 65
		int[] score2 = new int[] { 1, 2, 3, 4, 5, 6, 7, 8 };
		String[] score1 = new String[] { "강호동", "유재석", "신동엽", "김연아", "송강호", "전지현", "김하늘", "송윤아" };
		double[] score = new double[] { 88.5, 85, 77.65, 70, 90, 66, 90, 65 };
		System.out.println("번호 " + "  이름 " + "  점수 ");
		double sum = 0;
		for (int i = 0; i < score.length; i++) {
			sum = sum + score[i];
			System.out.println(" " + score2[i] + "     " + score1[i] + "  " + score[i]);
		}
		System.out.println(sum / score.length);

	}
}
