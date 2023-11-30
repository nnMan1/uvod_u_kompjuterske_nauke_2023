import java.util.Scanner;

public class Main {
	
	static Scanner in = new Scanner(System.in);
	
	public static void uvecaj(int x) {
		x++; //nece da izmijeni promjenljivu u mainu
	}
	
	public static void uvecaj(int[] arr) {
		arr[0]++;
	}
	
	public static void ucitajNiz(int[] arr) {
		for(int i=0;i<arr.length;i++)
			arr[i] = in.nextInt();
	}
	
	public static void pisiNiz(int[] arr) {
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i] + " ");
		
		System.out.println();
	}
	
	public static int zeroElem(int[] b) {
		int br = 0;
		
		for(int i=0;i<b.length - 1;i++)
			if(b[i] % 10 == 0 && b[i+1] % 10 == 0)
				br ++;
		
		return br;
	}
	
	public static int changeSign(int[] b) {
		int br = 0;
		
		for(int i=0;i<b.length - 1;i++)
			if(b[i] * b[i+1] < 0)
				br ++;
		
		return br;
	}
	
	public static int oddSegments(int[] arr) {
		int max_odd = 0; //maksimalna duzina segmenta neparnih brojeva
		int curr_odd = 0; //trenutna duzina segmenta neparnih brojeva
		
		for(int i=0;i<arr.length;i++) {
			if(arr[i] % 2 == 0)
				curr_odd = 0;
			else
				curr_odd ++;
			
			max_odd = Math.max(max_odd, curr_odd);
		}
		
		return max_odd;
	}
	
	public static int[] next_binom(int[] arr) {
		int[] brr = new int[arr.length + 1];
		
		brr[0] = 1;
		
		for(int i=0;i<arr.length-1;i++)
			brr[i+1] = arr[i]+arr[i+1];
		
		brr[brr.length-1] = 1;
		
		return brr;
	}
	
	public static void main(String[] args) {
		
		Bbox x1 = new Bbox(5, 4, 9, 7);
		Bbox x2 = new Bbox(3, 5, 10, 6);
		
		Bbox x3 = x1.presjek(x2);
		System.out.println("x3.presjek(x2) = " + x3);
//		x.setXmax(5);
//		x.setXmin(4);
//		x.setYmax(9);
//		x.setYmin(3);
		
//		System.out.println("x = " + x + " wx = " + x.width() + " hx = " + x.height());
		
		Bbox y = new Bbox();
		System.out.println("y = " + y);
	

		
//		int n = in.nextInt();
//		System.out.println(1);
//		
//		int[] arr = {1, 1};
//		pisiNiz(arr);
//	
//		for(int i=2;i<n;i++) {
//			arr = next_binom(arr);
//			pisiNiz(arr);
//		}
		
//		int n = in.nextInt();		
//		
//		int[] arr = new int[n];
//		ucitajNiz(arr);
//		System.out.println(oddSegments(arr));
		
//		pisiNiz(arr);
//					
//		System.out.println("uvecaj(arr[0])");
//		uvecaj(arr[0]);
//		pisiNiz(arr);
//		
//		System.out.println("uvecaj(arr)");
//		uvecaj(arr);
//		pisiNiz(arr);
	}
	
}
