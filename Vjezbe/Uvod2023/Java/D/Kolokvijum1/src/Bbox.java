import java.util.Objects;

public class Bbox {
	
	private int xmin, ymin, xmax, ymax;
	
	public Bbox() {
		this.xmin = 0;
		this.xmax = 0;
		this.ymin = 0;
		this.ymax = 0;
	}
	
	public Bbox(int xmin, int ymin, int xmax, int ymax) {
		this.xmin = xmin;
		this.xmax = xmax;
		this.ymin = ymin;
		this.ymax = ymax;
	}
	
	public int getXmin() {
		return xmin;
	}
	
	public void setXmin(int xmin) {
		this.xmin = xmin;
	}
	
	public int getYmin() {
		return ymin;
	}
	
	public void setYmin(int val) {
		ymin = val;
	}
	
	public int getXmax() {
		return xmax;
	}
	
	public void setXmax(int val) {
		xmax = val;
	}
	
	public int getYmax() {
		return ymax;
	}
	
	public void setYmax(int ymax) {
		if(this.ymin <= ymax)
			this.ymax = ymax;
		else 
			System.out.println("Nije moguce postaviti vrijednost za ymin");		
	}

	public int width() {
		return xmax - xmin;
	}
	
	public int height() {
		return ymax - ymin;
	}
	
	public int area() {
		return this.width() * height();
	}
	
	public Bbox interesection(Bbox b) {
		if(xmin > b.xmax ||b.xmin > xmax || ymin > b.ymax || b.ymin > ymax) {
			return new Bbox(0, 0, 0, 0);
		}
		
		Bbox ret = new Bbox();
		ret.setXmax(Math.min(xmax, b.xmax));
		ret.setYmax(Math.min(ymax, b.ymax));
		ret.setXmin(Math.max(xmin, b.xmin));
		ret.setYmin(Math.max(ymin, b.ymin));
		
		return ret;
	}
	
	public int union(Bbox b) {
		return this.area() + b.area() - this.interesection(b).area();
	}
	
	public double iou(Bbox b) {
		return (double)this.interesection(b).area() / this.union(b);
	}

	@Override
	public String toString() {
		return "[(" + xmin + ", "+ ymin + "), (" + xmax + ", " + ymax + ")]";
	}

	public boolean equals(Bbox obj) {
		return xmax == obj.xmax && xmin == obj.xmin && ymax == obj.ymax && ymin == obj.ymin;
	}
	
	
}
