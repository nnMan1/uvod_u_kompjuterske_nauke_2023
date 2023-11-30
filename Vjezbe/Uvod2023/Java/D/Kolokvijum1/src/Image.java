
public class Image {
	private Bbox[] boxes;	//niz boxova na slici
	private int numBboxes; 
	private int capacity;
	private int height;	//duzina slike
	private int width; //sirina slike
	
	public int getNumBoxes() {
		return numBboxes;
	}
	
	public Image(int capacity, int width, int height) {
		this.capacity = capacity;
		this.width = width;
		this.height = height;
		
		this.numBboxes = 0;
		
		this.boxes = new Bbox[this.capacity]; //alociramo memoriju za niz boxes 
	}
	
	public Image(Bbox[] boxes, int capacity, int width,int height) {
		this.boxes = new Bbox[capacity];
		
		for(int i=0;i<boxes.length;i++)
			this.boxes[i] = boxes[i];
		
		this.width = width;
		this.height = height;
		this.capacity = capacity;
		this.numBboxes = boxes.length;
	}
	
	void add(Bbox b) {
		if(numBboxes < capacity) {
			boxes[numBboxes] = b;
			numBboxes ++;
		} else {
			System.out.println("Kapacitet niza boxes je vec pun");
		}
	}
	
	Bbox[] getBboxes() {
		return boxes;
	}
	
	public Bbox get(Bbox b) {
		Bbox best = null;
		
		for(int i=0;i<numBboxes;i++) {
			if(best == null || b.iou(best) < b.iou(boxes[i]))
				best = boxes[i];
		}
		
		return best;
	}
	
	public void clean() {
		for(int i=0;i<numBboxes;i++) {
			for(int j=i+1;j<numBboxes;j++) {
				if(boxes[i].equals(boxes[j])) {
					for(int k=j+1;k<numBboxes;k++)
						boxes[k-1] = boxes[k];
					
					numBboxes--;
				}
			}
		}
	}
	
}
