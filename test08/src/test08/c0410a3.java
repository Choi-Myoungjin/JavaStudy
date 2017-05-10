package test08;

public class c0410a3 {
	public static void main(String[] args) {
		double[] score = new double[] { 35, 40, 55, -20, -30, 78, 200, 98 };
		System.out.println(score.length);

		for (int i = 0; i < score.length; i++) {
			double j = score[i];
			if (j < 0) {
				System.out.print("  " + -j);
			} else {
				System.out.print("  " + j);
			}
		}
		double sum = 0;
		for (int k = 0; k < score.length; k++) {
			sum = sum + score[k];
		}System.out.println(sum);

	}
}
