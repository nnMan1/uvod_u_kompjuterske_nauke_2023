package cas2;

import java.util.Scanner;

public class Main {
	
	public static double povTrougla(double a, double b, double c) {
		double s = (a+b+c) / 2;
		double P = Math.sqrt(s*(s-a)*(s-b)*(s-c));
		
//		a--;
//		b--;
//		c--;
//		
//		System.out.println(a + " " + b + " " + c);
		
		return P;
	}
	
//	5.Napisati metodu koja probjerava da li je broj prost
//	metoda uzima jedan cio broj n, i vraca jednu boolean 
//	vrijednost true ili false
	
	public static boolean prost(int n) {
		for(int i=2;i<=Math.sqrt(n);i++)
			if(n % i == 0)
				return false;
		
		return true;
	}
	
//6.a Napisati metodu koja nalazi zbir djelilaca broja n.
	public static int zbir_djelilaca(int n) {
		int s = 1;
		int i = 2;
		
		for(i=2;i<Math.sqrt(n);i++)
			if(n % i == 0) {
				s += i;
				s += n / i;
			}
		
		if(i * i == n)
			s += i;
		
		return s;
	}
	
//	7. Napisati metodu koja stama sve proste brojeve izmedju a i b
	
	public static void stampajProste(int a, int b) {
		for(int i=a;i<=b;i++)
			if(prost(i))
				System.out.println(i);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner in = new Scanner(System.in);
		
		//1. Napisati program koji nalazi maksimum za n unijetih brojeva
		//u prvom redu se ucitava b roj n
		//u drugom redu n brojeva ciji se maksimum tazi
		
//		int n = in.nextInt();
//		int m = Integer.MIN_VALUE;
//		int x;
//		
//		for(int i=0;i<n;i++) {
//			x = in.nextInt();
//			if(m < x)
//				m = x;
//		}
//		
//		System.out.println(m);
		
		//2. Napisati program koji ucitava n trouglova i stampa trougao maksimalne povrsine
		//U prvom redu se ucitava pridona broj n
		//U narednih n redova se ucitavaju po tri broja koji predstavljaju duzine stranica trouglova
		//Stampati trougao makimalne povrsine
		
//		int n=in.nextInt();
//		double a, b, c;
//		double mA=0, mB=0, mC=0;
//		double mP=0;
//		
//		for(int i=0;i<n;i++) {
//			a = in.nextDouble();
//			b = in.nextDouble();
//			c = in.nextDouble();
//			
//			double s = (a+b+c) / 2;
//			double P = Math.sqrt(s*(s-a)*(s-b)*(s-c));
//			
//			if(P > mP) {
//				mP = P;
//				mA = a;
//				mB = b;
//				mC = c;
//			}
//		}
//		
//		System.out.println("a = " + mA + " b = " + mB + " c = " + mC + " P = " + mP);
		
		
		//3. Napisati program koji provjerava da li je unijeti broj stepan dvojke
		
//		int n = in.nextInt();
//		
//		while(n % 2 == 0)
//			n = n / 2;
//		
//		if(n == 1)
//			System.out.println("Broj je stepen dvojek");
//		else 
//			System.out.println("Broj nije stepen dvojke");
		
		
		//4. Naci povrsinu trougla 
		
//		double a, b, c;
//		a = in.nextInt();
//		b = in.nextInt();
//		c = in.nextInt();
//		
//		System.out.println("P(a, b, c) = " +  povTrougla(a, b, c));
//		System.out.println(a + " " + b + " " + c);
		
		//5.p Provjeriti da li je ucitani proj n prost;
//		int n = in.nextInt();
//		
//		if(prost(n))
//			System.out.println("Broj n je prost");
//		else 
//			System.out.println("Broj n nije prost");
		
//		6. Naci sve parove prijateljskih brojeva manjih od n.
//		 Za dva broja kazemo da su projateljski 
//		 ako je jedan broj jedan sumi djelilaca drugog broja.
//		 Primjer:
//			 220, 284
		
//		int n = in.nextInt();
//		
//		for(int i=1;i<=n;i++) {
//			int j = zbir_djelilaca(i);
//			if(i >= j && i == zbir_djelilaca(j))
//				System.out.println(i + " " + j);
//		}		
		
//		7.p Napisati program koji ucitava dva broja i stampa sve proste brojeve izmedju a i b
//		int a = in.nextInt();
//		int b = in.nextInt();
//		
//		stampajProste(a, b);
	
		/*8.
		 * n = 5
		 0* 1 3 5 7 9
		 1* 10 8 6 4 2
		 2* 11 13 15 17 19
		 3* 20 18 16 14 12
		 4* 21 23 25 27 29 
		 * */
		
//		int n = in.nextInt();
//		
//		for(int i=0;i<n;i++) {
//			if(i % 2 == 0) {
//				for(int j=i*n+1;j<(i+2)*n;j+=2)
//					System.out.print(j + " ");
//			} else {
//				for(int j=(i+1)*n; j>(i-1)*n+1;j-=2)
//					System.out.print(j + " ");
//			}
//			System.out.println();
		
		//9. Napisati program koji provjerava da li je unijeti niz brojeva testerast
		//Niz brojeva je testerast ako za svaki broj vazi da je 
		//	ili veci od oba svoja susjeda
		//  ili manji od oba svoja susjeda.
		//zadatak rijesiti bez upotrebe nizova
		// 10
		// 1 5 3 7 4 9 2 21 7 8
		
		int n = in.nextInt();
		int a;
		int b = in.nextInt();
		int c = in.nextInt();
		
		boolean p = true;
		
		for(int i=2;i<n;i++) {
			a = b;
			b = c;
			c = in.nextInt();
			
//			if(!(a < b && b > c || a > b && b < c)) 
//			if((a > b || b < c) && (a < b || b > c))
			if((a > b && b > c) || (a < b && b < c))
				p = false;
		}
	
		if(p)
			System.out.println("Niz je testerast");
		else 
			System.out.println("Niz nije testerast");
			
		
	}

}
