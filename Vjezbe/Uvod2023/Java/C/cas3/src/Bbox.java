
public class Bbox {
	private int xmin, ymin, xmax, ymax;
	
	public Bbox() {
		xmin = 0; 
		ymin = 0;
		xmax = 0;
		ymax = 0;
	}
	
	public Bbox(int xmin, int ymin, int xmax, int ymax) {
		this.xmin = xmin;
		this.ymin = ymin;
		this.xmax = xmax;
		this.ymax = ymax;
	}

	public int getXmin() {
		return xmin;
	}

	public void setXmin(int xmin) {
		if(xmin > this.xmax) {
			System.out.println("Nije moguce postaviti trazenu vrijednost za xmin");
			return;
		}
		
		this.xmin = xmin;
		
	}

	public int getYmin() {
		return ymin;
	}

	public void setYmin(int ymin) {
		this.ymin = ymin;
	}

	public int getXmax() {
		return xmax;
	}

	public void setXmax(int xmax) {
		this.xmax = xmax;
	}

	public int getYmax() {
		return ymax;
	}

	public void setYmax(int ymax) {
		this.ymax = ymax;
	}
	
	public int width() {
		return xmax - xmin;
	}
	
	public int height() {
		return ymax - ymin;
	}
	
	public Bbox presjek(Bbox b) {
		if(		this.xmin > b.xmax || 
				this.xmax < b.xmin || 
				this.ymin > b.ymax || 
				this.ymax < b.ymin)
				return new Bbox();
		
		Bbox ret = new Bbox();
		ret.xmin = Math.max(this.xmin, b.xmin);
		ret.ymin = Math.max(this.ymin, b.ymin);
		ret.xmax = Math.min(this.xmax, b.xmax);
		ret.ymax = Math.min(this.ymax, b.ymax);
		
		return ret;
	}

	public int area() {
		return width() * height();
	}
	
	public int area(Bbox b) {
		return this.presjek(b).area();
	}
	
	public int union(Bbox b) {
		return this.area() + b.area() - this.area(b);
	}
	
	public double iou(Bbox b) {
		return (double)this.union(b) / this.area(b);
	}
	
	public String toString() {
		return "[(" + xmin + ", " + ymin + "), (" + xmax + ", " + ymax + ")]";
	}
}
