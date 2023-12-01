package cas4;

public class Complex {
	private double re, im;
	
	public Complex() {
		re = 0;
		im = 0;
	}
	
	public Complex(double re, double im) {
		this.re = re;
		this.im = im;
	}
	
	public double getRe() {
		return re;
	}
	
	public void setRe(double re) {
		this.re = re;
	}
	
	public double getIm() {
		return im;
	}
	
	public void setIm(double im) {
		this.im = im;
	}
	
	public String toString() {
		return "(" + re + "+" + im + "i)";
	}
	
	public Complex plus(double re) {
		return new Complex(this.re + re, this.im);
	}
	
	public Complex plus(Complex arg) {
		return new Complex(this.re + arg.re, this.im + arg.im);
	}
	
	public Complex puta(Complex arg) {
		double nre = this.re * arg.re - this.im * arg.im;
		double nim = this.re * arg.im + this.im * arg.re;
		return new Complex(nre, nim);
	}
	
	public Complex konjugovano() {
		return new Complex(re, -im);
	}
	
	public Complex podijeli(Complex arg) {
		if(arg.re == 0 && arg.im == 0) {
			System.out.println("Nije moguce podijeliti " + this + " i "+ arg);
			return null;
		}
		
		Complex tmp1 = this.puta(arg.konjugovano());
		Complex tmp2 = arg.puta(arg.konjugovano());
		
		tmp1.re /= tmp2.re;
		tmp1.im /= tmp2.re;
		
		return tmp1;
		
	}
	
	public boolean jednao(Complex c) {
		return re == c.re && im == c.im;
	}
	
	public double norma() {
		return Math.sqrt(re*re + im*im);
	}
	
}
