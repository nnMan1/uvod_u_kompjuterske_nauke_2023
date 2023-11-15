package cas1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		//int - 32binti cio broj (drugi komplement)
		//double - 64bitini ralan froj (floating point)
		/*
		 * float - 32bitni realan broj (floating point)
		 * long - 64bitni cio broj
		 */
		
		/*
		double x, y;
		
		System.out.print("Unesite x: ");
		x = in.nextDouble();
		
		System.out.print("Unesite y: ");
		y = in.nextDouble();
		
		System.out.println("Ovo je prvi java projekat " + "ucimo osnovne stvari");
		System.out.print("Zbr brojeva x i y je " + (x + y) + " = ");
		System.out.println(x + y);
		*/
		
		/*
		System.out.println("Byte.MIN_VALUE = " + Byte.MIN_VALUE);
		System.out.println("Byte.MAX_VALUE = " + Byte.MAX_VALUE);
		
		System.out.println("Short.MIN_VALUE = " + Short.MIN_VALUE);
		System.out.println("Short.MAX_VALUE = " + Short.MAX_VALUE);
		
		System.out.println("Integer.MIN_VALUE = " + Integer.MIN_VALUE);
		System.out.println("Integer.MAX_VALUE = " + Integer.MAX_VALUE);
		
		System.out.println("Long.MIN_VALUE = " + Long.MIN_VALUE);
		System.out.println("Long.MAX_VALUE = " + Long.MAX_VALUE);
		
		System.out.println("Double.MIN_VALUE = " + Double.MIN_VALUE);
		System.out.println("Double.MAX_VALUE = " + Double.MAX_VALUE);
		*/
		
		/*
		int x, y;
		
		System.out.print("Unesite x: ");
		x = in.nextInt();
		
		System.out.print("Unesite y: ");
		y = in.nextInt();
		
		System.out.println("x + y = " + (x + y));
		System.out.println("x - y = " + (x - y));
		System.out.println("x / y = " + (x / y));
		System.out.println("x * y = " + (x * y));
		System.out.println("x % y = " + (x % y));
		
		//System.out.println("x / y = " + 7.0 / 5);
		double rez = (double)x / y;
		System.out.println("x / y = " + rez);
		*/
		
		/*
		//napisati program koji poredi 2 boja
		int a, b;
		a = in.nextInt();
		b = in.nextInt();
		
		if(a < b) {
			System.out.println("broj "+ a + " je manji od broja " + b);
		}
		else
			System.out.println("broj "+ a + " je veci ili jednak od broja " + b);
		*/
		
		//napisati program koji stampa prvih n prirodnih bojeva
		
//		int n = in.nextInt();
//		int i = 1;
		
//		while(i <= n) {
//			System.out.println(i);
//			i++;
//		}
		
		/*
		for(int i=1;i<=n;i++)
			System.out.print(i + " ");
		*/
		
//		do {
//			System.out.print(i + " ");
//			i = i + 1;
//		}while(i <=n);
		
//		Stampati priamidu kao sa slike 
//		1
//		12
//		123
//		1234
//		12345
//		1234
//		123
//		12
//		1
		
//		int n = in.nextInt();
//		
//		for(int i=0;i<n;i++) {
//			for(int j=0;j<=i;j++)
//				System.out.print(j + 1 + " ");
//			
//			System.out.println();
//		}
//		
//		for(int i=0;i<n;i++) {
//			for(int j=0;j<n-i-1;j++)
//				System.out.print(j + 1 + " ");
//			
//			System.out.println();
//		}
		
//		Za elemente niza x0, x1, x2,..,xn važi: x0=a, x1=b ..., xn+2+2xn+1+xn=0, 0n. Napisati program koji učitava prirodne brojeve a, b i k i štampa xk. 
		
		int a, b, k;
		a = in.nextInt();
		b = in.nextInt();
		k = in.nextInt();
		
		if(k == 0) {
			System.out.println(a);
			return;
		}
			
		if(k == 1) {
			System.out.println(b);
			return;
		}
		
		int x_n1 = b; 
		int x_n2 = a;
		
//		System.out.println("x0 = " + a);
//		System.out.println("x1 = " + b);
		
		int xn = 0;
		
		for(int i=2;i<=k;i++) {
			xn = -2*x_n1 - x_n2;
			//System.out.println("x"+ i + " = " + xn);
			x_n2 = x_n1;
			x_n1 = xn;
		}
		
		System.out.println(xn);
		
	} 

}
