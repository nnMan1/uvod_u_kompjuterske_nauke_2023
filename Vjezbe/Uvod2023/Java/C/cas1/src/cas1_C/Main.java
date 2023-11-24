package cas1_C;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		/*
		 * byte - 8bit cio broj 2PC
		 * short - 16bit cio broj 2PC
		 * int - 32bit cio broj 2PC
		 * long - 64bit cio broj u 2PC
		 * float - 32bit realan broj floating point
		 * double - 64bit realan broj floating point
		 * */
		
		Scanner in = new Scanner(System.in);
		
//		long x;
//		x = in.nextInt();
//		
//		int y = in.nextInt();
//		
//		System.out.println("Ovo je prvi program u Javi.");
//		System.out.println("Ovo je druga linija " + "prvog programa u Javi.");
//		
//		System.out.println(x + y + " = x + y = " + (x + y));
		
//		System.out.println("byte - [" + Byte.MIN_VALUE + ", " + Byte.MAX_VALUE + "]");
//		System.out.println("short - [" + Short.MIN_VALUE + ", " + Short.MAX_VALUE + "]");
//		System.out.println("int - [" + Integer.MIN_VALUE + ", " + Integer.MAX_VALUE + "]");
//		System.out.println("long - [" + Long.MIN_VALUE + ", " + Long.MAX_VALUE + "]");
//		System.out.println("float - [" + Float.MIN_VALUE + ", " + Float.MAX_VALUE + "]");
//		System.out.println("double - [" + Double.MIN_VALUE + ", " + Double.MAX_VALUE + "]");
//				
//		System.out.println("7 + 5 = " + (7 + 5));
//		System.out.println("7 - 5 = " + (7 - 5));
//		System.out.println("7 * 5 = " + (7 * 5));
//		System.out.println("7 / 5 = " + (7 / 5));
//		System.out.println("7 % 5 = " + (7 % 5));
//		
//		System.out.println("7.0 / 5 = " + (7.0 / 5));
//		
//		int z = 6;
//		int x = 7;
//		int y = 5;
//		System.out.println("6 + 7 / 5 = " + (z + (double)x / y));
//		
//		double r = x / y;
//		System.out.println("x / y = " + r);

		
//		int x = in.nextInt();
//		int y = in.nextInt();
//		
//		//&& - AND
//		//|| - OR
//		//== - poredjenje po jednakosti
//		//!= - poredjenje po nejednakosti
//		
//		if(x < y)
//			System.out.println("Broj " + x + " je manji od broja " + y);
//		else
//			System.out.println("Broj" + x + " je veci ili jednak od broja " + y);

//		int n = in.nextInt();
//		int i = 1;
//		while (i <= n) {
//			System.out.print(i++ + " ");
//		}
		
//		int n = in.nextInt();
//		
//		for(int i=1;i<=n;i++)
//			System.out.print(i + " ");
//		
//		int n = in.nextInt();
//		
//		for(int i=0;i<n;i++) {
//			for(int j=0;j<=i;j++)
//				System.out.print(j+1 + " ");
//			System.out.println();
//		}
//		
//		for(int i=0;i<n-1;i++) {
//			for(int j=0;j<n-i-1;j++)
//				System.out.print(j+1+" ");
//			System.out.println();
//		}
		
		int n = in.nextInt();
		
		for(int i=0;i<n;i++) {
			System.out.print(i + " ");
			for(int j=0;j<n-i;j++) 
				System.out.print("*");
			
			for(int j=0;j<2*i;j++) 
				System.out.print(" ");
			
			for(int j=0;j<n-i;j++) 
				System.out.print("*");
			
			System.out.println();
		}
		

		for(int i=1;i<n;i++) {
			System.out.print(i + " ");

			for(int j=0;j<i+1;j++) 
				System.out.print("*");
			
			for(int j=0;j<2*(n-1-i);j++) 
				System.out.print(" ");
			
			for(int j=0;j<i+1;j++) 
				System.out.print("*");
			
			System.out.println();
		}
		
		
		
	}

}
