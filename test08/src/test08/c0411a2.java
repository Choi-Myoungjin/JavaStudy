package test08;

public class c0411a2 {
	public static void main(String[] args) {
	
		int[] data = new int[] { 70, 85, 60, 90, 95, 75 };
		int max= data[0];
		int index=0;
		for(int i=1; i<data.length; i++)
		{
			if(max < data[i])
			{
				max = data[i];
				System.out.println(max+" "+i);
				index = i;
			}
		}System.out.println(max);
		System.out.println(index);
	}
}
