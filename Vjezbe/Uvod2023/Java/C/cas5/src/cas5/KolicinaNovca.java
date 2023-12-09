package cas5;

public class KolicinaNovca {
	private int valuta_id;
	private double kolicina;
	private double kurs;
	
	public KolicinaNovca(int valuta_id, double kolicina, double kurs) {
		this.valuta_id = valuta_id;
		this.kolicina = kolicina;
		this.kurs = kurs;
	}

	public int getValuta_id() {
		return valuta_id;
	}

	public void setValuta_id(int valuta_id) {
		this.valuta_id = valuta_id;
	}

	public double getKolicina() {
		return kolicina;
	}

	public void setKolicina(double kolicina) {
		this.kolicina = kolicina;
	}

	public double getKurs() {
		return kurs;
	}

	public void setKurs(double kurs) {
		this.kolicina = this.kolicina * (this.kurs / kurs);
		this.kurs = kurs;
	}
	
	public KolicinaNovca add(KolicinaNovca x) {
		KolicinaNovca ret = new KolicinaNovca(x.valuta_id, x.kolicina, x.kurs);
				
		ret.setKurs(this.kurs);
		ret.valuta_id = this.valuta_id;
		
		ret.kolicina += this.kolicina;
		
		return ret;
	}
	
	public int compareTo(KolicinaNovca arg) {
		if(kolicina*kurs == arg.kolicina * arg.kurs)
			return 0;
		
		if(kolicina*kurs < arg.kolicina * arg.kurs)
			return -1;
		
		return 1;
	}
	
	public String toString() {
		return kolicina + " " + kolicina * kurs;
	}
	
}
