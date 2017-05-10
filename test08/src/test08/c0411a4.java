package test08;

public class c0411a4 {
	public static void main(String[] args) {
		String[] menu = new String[] { "Â¥Àå¸é", "Â«»Í", "ººÀ½¹ä", "ÅÁ¼öÀ°" };
		int[] pay = new int[] { 4000, 4000, 6000, 10000 };
		int a,b;
		a=pay[0];
		b=pay[0];
		for (int i = 0; i < menu.length; i++) {
			a=pay[i];
			for ( int j = 0 ; j <menu.length; j++){
				b=pay[j];
				if((a+b)<=15000)
				{
					System.out.println(menu[i]+"  "+menu[j]+"  "+(a+b)) ;	
				}
//				System.out.println(menu[i]+"  "+menu[j]+"  "+(a+b)) ;
			}
		}
	}
}
