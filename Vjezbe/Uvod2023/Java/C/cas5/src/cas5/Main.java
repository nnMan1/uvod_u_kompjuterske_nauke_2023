package cas5;

public class Main {
	public static void radiNestoSaNovcem(KolicinaNovca x) {
		x.setKolicina(20);
	}
	
	public static void main(String[] args) {
		KolicinaNovca x1 = new KolicinaNovca(0, 50, 0.1);
		KolicinaNovca x2 = new KolicinaNovca(1, 100, 0.045);
		
//		radiNestoSaNovcem(x1);
		System.out.println(x1);
		
		KolicinaNovca x3 = x1.add(x2);
		
		System.out.println(x1 + " + " + x2 + " = " + x3);
		System.out.println(x1.compareTo(x2));
		
		Queue q = new Queue(5);
		q.push(x1);
		q.push(x2);
		q.push(x3);
		
		for(int i=0;i<3;i++)
			System.out.println(q.pop());
	}

}
