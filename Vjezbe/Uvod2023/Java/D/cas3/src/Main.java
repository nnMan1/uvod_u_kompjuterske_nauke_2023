import java.util.Scanner;

public class Main {
	static Scanner in = new Scanner(System.in);

	public static void ucitajNiz(int[] arr) {
		for(int i=0;i<arr.length;i++)
			arr[i] = in.nextInt();
	}
	
	public static void stampajNiz(int[] arr) {
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i] + " ");
	}
	
	public static void updateArray (int a, int [] b) {
		for(int i=0;i<b.length;i++)
			if(b[i] > 0)
				b[i] -= a;
			else
				b[i] += a;
	}
 
	public static int zeroElem(int [] b) {
		int br = 0;
		
		for(int i=0;i<b.length-1;i++)
			if(b[i] % 10 == 0 && b[i+1]%10==0)
				br++;
		
		return br;
	}
	
	public static int changeSign(int [] b) {
		int br = 0;
		
		for(int i=0;i<b.length-1;i++)
			if(b[i] * b[i+1] < 0)
				br++;
		
		return br;
	}
	
	public static int oddSegments(int [] b) {
		int mb = 0;
		int tb = 0;
		
//		optimalni rjesenje		
//		for(int i=0;i<b.length;i++) {
//			if(b[i] % 2 == 0)
//				tb = 0;
//			else 
//				tb ++;
//			
//			mb = Math.max(mb, tb);
//		}
		
//		neoptimalno rjesenje
		for(int i=0;i<b.length;i++) {
			tb = 0;
			
			for(int j=i;j<b.length;j++)
				if(b[j] % 2 == 0)
					break;
				else 
					tb++;
			
			mb = Math.max(mb, tb);
		}
		
		return mb;
	}
	
	public static void shiftLeft(int [] b) {
		int tmp = b[0];
		
		for(int i=0;i<b.length-1;i++)
			b[i] = b[i+1];
		
		b[b.length - 1] = tmp;
	}
	
	public static void main(String[] args) {
		
//		int n = in.nextInt();
//		int[] arr = new int[n];
//		ucitajNiz(arr);
//
//		shiftLeft(arr);
//		stampajNiz(arr);
		
		int a = in.nextInt();
		int b = in.nextInt();
		int k = in.nextInt();
		
		for(int i=0;i<k;i++) {
			int t = -2*b - a;
			a = b;
			b = t;
		}
		
		System.out.println(a);
	}

}
