package cas4;

public class Main {
	/*
	 * Implementirati klasu Complex koja modeluje kompleksan broj
	 * Kombpleksan broj treba da ima realan dio i imaginarni dio.
	 * Implementirati konstruktor sa 2 argumenta +
	 * Implementirati konstruktor bez argumenata, koji postavlja vrijednost na 0+0i +
	 * Implementirati getere i setere +
	 * Implementirati metodu plus koja sabira dva kompleksna broja +
	 * Implementirati metodu puta koja mnozi dva kompleksna broja +
	 * Implementirati metodu podijeljeno koja dijeli dva kompleksna broja +
	 * Implementirati metou norma
	 * Implementirati metodu toString koja vraca string +
	 * reprezentaciju kompleksong broja+
	 * 
	 * 
	 * 2. Napisati klasu Skup kompleksnih brojeva. 
	 * Napisati konstruktor koji uzima jedan argiment koji predstavlja kapacitet niza
	 * Napisati konstruktor bez argumenata koji alocira memoriju za niz duzine 10
	 * Omoguciti dodavanje elementa u skup -
	 * Omoguciti uzimanje elementa skupa sa najvecom normom +
	 * Implementirati metodu presjek +
	 * unija +
	 * razlika
	 * simetricnaRazlika
	 * ukloni duplikate +
	 * getElemAt(int i) //uzima element sa pozicije i 
	 * */

	public static void main(String[] args) {
		
		Complex c1 = new Complex();
		Complex c2 = new Complex();

		if(c1 == c2)
			System.out.println("Kompleksni brojevi " + c1 + " i " + c2 + " su jednaki");
		else
			System.out.println("Kompleksni brojevi " + c1 + " i " + c2 + " nisu jednaki");
		
		Complex a0 = new Complex();
		Complex a = new Complex(0, 1);
		
		System.out.println(a.getRe() + "+" + a.getIm() + "i");
		System.out.println("a = " + a);
		
		a.setRe(2);
		a.setIm(3);
		System.out.println("a = "+ a);
		
		Complex b = a.plus(a0);
		
		Complex d = new Complex(5, 7);
		Complex c = a.puta(d);
		System.out.println(a + "*" + d + "=" + c);
		
		Complex f = c.podijeli(a);
		System.out.println(c + "/" + a + " = " + f);
		
		System.out.println("----------------------------------------");
		
		Skup s1 = new Skup();
		Skup s2 = new Skup(20);
		
		s2.dodaj(new Complex(5, 7));
		s2.dodaj(new Complex(4, 9));
		s2.dodaj(new Complex(-11, 29));
		
		s1.dodaj(f);
		s1.dodaj(c);
		s1.dodaj(a);
		
		for(int i=0;i<s1.size();i++) {
			System.out.println(s1.getElemAt(i));
		}
		
		System.out.println("-------------------------------");
		Skup s3 = s1.presjek(s2);
		for(int i=0;i<s3.size();i++) {
			System.out.println(s3.getElemAt(i));
		}
		
		System.out.println("-------------------------------");
		Skup s4= s1.unija(s2);
		for(int i=0;i<s4.size();i++) {
			System.out.println(s4.getElemAt(i));
		}
		
		System.out.println("-------------------------------");
		s1.dodaj(new Complex(5, 7));
		for(int i=0;i<s1.size();i++) {
			System.out.println(s1.getElemAt(i));
		}
		
		System.out.println("-------------------------------");
		s1.ukloniDuplikate();
		for(int i=0;i<s1.size();i++) {
			System.out.println(s1.getElemAt(i));
		}
		
		
		
		
		
	}

}
