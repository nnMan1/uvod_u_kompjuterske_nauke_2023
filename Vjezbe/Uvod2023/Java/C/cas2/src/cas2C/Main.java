package cas2C;

import java.util.Scanner;

public class Main {
	
//	1. Napisati program koji ucitava n trouglova
//	trougao je zadat kao tri pozitivna broja
//	koji predstavljaju duzine stranica trougla.
//	Stampati trougao najvece povrsine.
	
	public static double povTrougla(double a, double b, double c) {
		double s = (a + b + c) / 2;
		double p = Math.sqrt(s*(s-a)*(s-b)*(s-c));
		return p;
	}
	
//	2. Napisati metodu koja provjerva da li je broj stepen dvojke
	public static boolean stepenDvojke(int n) {
		while(n % 2 == 0)
			n = n / 2;
		
		return n == 1;
	}
	
//	3. Proizvod u prodavnici kosta a eura i b cetni.
//	Koliko eura i koliko centi cemo platiti n komada proizvoda?
//	Npr: 10 15 2 -> 20 30
//	   : 2 50 4 -> 10 0
	
//	4. Napisati medodu prosta cifra koja provjerava 
//	da li broj sadrzi u svom zapisu prostu cifru
	
	public static boolean prosteCifre(int n) {
		while(n != 0) {
			if(n % 10 == 2 || n % 10 == 3 || n % 10 == 5 || n % 10 == 7)
				return true;
			
			n = n / 10;
		}
		
		return false;
	}	
	
//	5. Napisati metodu:
//		a) koja provjerava da li je broj prost
//		b) stampa sve proste brojeve izmedju a i b
	public static boolean prost(int n) {
		for(int i=2;i<=Math.sqrt(n);i++)
			if(n % i == 0)
				return false;
		
		return true;
	}
	
	public static void prostiIntervl(int a, int b) {
		for(int i=a;i<=b;i++)
			if(prost(i))
				System.out.println(i);
	}
	
	//6. Napisati program koji provjerava da li je unijeti niz testerast
//	Niz je testerast ako za svaki broj vazi da je 
//	ili manji od obas svoj susjeda
//	ili veci od oba svoja susjeda
	
//	4 5 3 9 7 8 2 5 4
//	4 5 3 9 7 6 2 5 4
	
//	7. Napisati metodu brojTrouglova(int o) koja za cjelobrojni argument o
//	nalazi koliko postoji trouglova sa cjelobrojnim uzinama stranica 
//	ciji je obim o.
	
	public static boolean postojiTrougao(double a, double b, double c) {
		return a + b > c && a + c > b && b + c > a;
	}
	
	public static int brojTrouglova(int o) {
		int br = 0;
		
		for(int a=o/3;a<o/2;a++) {
			for(int b=(o-a)/2;b<=a;b++) {
				if(b >= o - a - b && postojiTrougao(a, b, o - a - b)) {
					System.out.println(a + " " + b + " " + (o - a - b));
					br++;
				}
			}
		}
		
		return br;
	}
	
	public static boolean sjenka(double x, double y) {
		if(x*x + y*y > 9)
			return false;
		
		if(x > 0 && y < 0)
			return false;
		
		if(x > 0 && y > 0 && 2*x - 2*y - 3 < 0)
			return false;
		
		if(x < 0 && y < 0 && 2*x - 2*y - 3 < 0 && y*y - 2*x - 1 > 0)
			return false;
		
		if(x < 0 && y > 0 && y*y - 2*x - 1 < 0)
			return false;
		
		return true;
		
	}
	
//	napisati metod koji za preati argument n stampa piramidu kao sa slike
//	   n = 5
//	      	  1 1 
//	    	2 1 1 2
//	  	  3 2 1 1 2 3
//		4 3 2 1 1 2 3 4
//    5 4 3 2 1 1 2 3 4 5
	
	public static void piramida(int n) {
		for(int i=0;i<n;i++) {
			for(int j=0;j<n-i-1;j++)
				System.out.print("  ");
			
			for(int j=i+1;j>0;j--)
				System.out.print(j + " ");
			
			for(int j=1;j<=i+1;j++)
				System.out.print(j + " ");

			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		piramida(in.nextInt());
//----------------------------------------------------
//		int n = in.nextInt();
//		
//		int a = in.nextInt();
//		int b = in.nextInt();
//		
//		boolean testerast = true;
//		
//		for(int i=2;i<n;i++) {
//			int c = in.nextInt();
//			
//			if(!(a < b && b > c || a > b && b < c))
//				testerast = false;
//				
//			a = b;
//			b = c;
//		}
//		
//		if(testerast)
//			System.out.println("niz je testerast");
//		else 
//			System.out.println("niz nije testerast");
//		------------------------------------------------------
//		zad2
//		
//		int n = in.nextInt();
//		System.out.println(prosteCifre(n));
		
//		-------------------------------------------------------
//		zad1
//		int n = in.nextInt();
//		
//		double mp = 0;
//		double ma = 0, mb = 0, mc = 0;
//		
//		for(int i=0;i<n;i++) {
//			double a, b, c;
//			a = in.nextDouble();
//			b = in.nextDouble();
//			c = in.nextDouble();
//			
//			if(mp < povTrougla(a, b, c)) {
//				mp = povTrougla(a, b, c);
//				ma = a;
//				mb = b;
//				mc = c;
//			}
//		}
//		
//		System.out.println("Trougao maksimalne povrsine je " + ma + " " + mb + " " + mc);
		
		
		
	}

}
