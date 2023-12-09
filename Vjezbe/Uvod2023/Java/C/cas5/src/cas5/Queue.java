package cas5;

public class Queue {
	private KolicinaNovca[] data;
	private int kapacitet;
	private int end;
	
	public Queue(int kapacitet) {
		this.data = new KolicinaNovca[kapacitet];
		this.kapacitet = kapacitet;
		this.end = 0;
	}
	
	public void push(KolicinaNovca elem) {
		if(this.kapacitet == this.end) {
			System.out.println("Nije moguce dodati element u pun red");
			return;
		}
		
		this.data[this.end] = elem;
		this.end++;
	}
	
	public KolicinaNovca pop() {
		KolicinaNovca ret = this.data[0];
		
		for(int i=1;i<end;i++)
			data[i-1] = data[i];
		
		end--;
		
		return ret;
	}
	
	
	public Queue copyOf() {
		Queue q = new Queue(this.kapacitet);
		
		for(int i=0;i<end;i++)
			q.push(this.data[i]);
		
		q.end = end;
		
		return q;
	}
	
	public int count(KolicinaNovca arg) {
		int br = 0;
		
		for(int i=0;i<end;i++)
			if(arg.compareTo(data[i]) == 0)
				br ++;
		
		return br;
	}
	
}
