package cas4;

public class Skup {
	private Complex[] data;
	private int pop;
	
	public Skup() {
		this.data = new Complex[10];
		this.pop = 0;
	}
	
	public Skup(int cap) {
		this.data = new Complex[cap];
		this.pop = 0;
	}
	
	public void dodaj(Complex arg) {
		this.data[this.pop] = arg;
		this.pop = this.pop + 1;
	}
	
	public Complex getElemAt(int idx) {
		if(idx >= 0 && idx < pop)
			return data[idx];
		
		return null;
	}
	
	public int size() {
		return pop;
	}
	
	public Complex maxNorm() {
		if(pop == 0)
			return null;
		
		Complex ret = data[0];
		
		for(int i=0;i<pop;i++)
			if(ret.norma() < data[i].norma())
				ret = data[i];
		
		return ret;
	}
	
	public boolean sadrzi(Complex c) {
		for(int i=0;i<pop;i++)
			if(data[i].jednao(c))
					return true;
		
		return false;
	}
	
	public Skup presjek(Skup s) {
		Skup ret = new Skup(this.pop);
		
		for(int i=0;i<pop;i++)
			if(s.sadrzi(data[i]))
				ret.dodaj(data[i]);
		
		return ret;
	}
	
	public Skup unija(Skup s) {
		Skup ret = new Skup(this.pop + s.pop);
		
		for(int i=0;i<this.pop;i++)
			ret.dodaj(data[i]);
		
		for(int i=0;i<s.pop;i++)
			if(!ret.sadrzi(s.data[i]))
				ret.dodaj(s.data[i]);
		
		return ret;
	}
	
	public void ukloniDuplikate() {
		Skup tmp = new Skup(pop);
		
		for(int i=0;i<pop;i++)
			if(!tmp.sadrzi(data[i])) {
				tmp.dodaj(data[i]);
			}
		
		this.data = tmp.data;
		this.pop = tmp.pop;
	}
}
