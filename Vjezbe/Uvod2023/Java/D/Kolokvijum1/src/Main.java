
public class Main {
	
	public static void stampajBbox(Bbox b) {
		System.out.println(b.getXmin() + " " + b.getYmin() + " " + b.getXmax() + " " + b.getYmax());
	
		//b.setXmax(b.getXmax() + 1); //izmijenice bbox u mainu
									//objekti klasa se predaju poreferenci
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bbox b1= new Bbox(5, 6, 10, 13);
//		b1.setXmin(5);
//		b1.setYmin(6);
//		b1.setXmax(10);
//		b1.setYmax(13);
		
		System.out.println(b1);
		stampajBbox(b1);
		
		System.out.println("Sirina pravougaonika b1 = " + b1.width() + 
							" visina praougaonika b1 = " + b1.height() +
							" povrsnina = " + b1.area());
		
		Bbox b2 = new Bbox(7, 4, 9, 12);
		stampajBbox(b2);
		
		Bbox b3 = b2.interesection(b1);
		
		stampajBbox(b3);
		
		System.out.println(b1.union(b3));
		System.out.println(b1.union(b2));
		System.out.println(b1.iou(b2));
		
		Bbox[] arr = {b1,  b2, b3};
		
		Image im1 = new Image(arr, 10, 1024, 1024);
		
		Bbox[] tmp = im1.getBboxes();
		
//		for(int i=0;i<im1.getNumBoxes();i++)
//			System.out.println(tmp[i]);
		
		im1.add(new Bbox(0, 0, 1, 1));
		im1.add(new Bbox(7, 4, 9, 12));
		im1.add(new Bbox(7, 6, 9, 12));
//		b1.setXmax(15); // izmijenice se objekat koji cuvamo u nizu bboxes slike
//		//da smo htjeli da se ne mijenja morali bi da koristimo new Bbox(...
//		
		tmp = im1.getBboxes();
		
		for(int i=0;i<im1.getNumBoxes();i++)
			System.out.println(tmp[i]);
		
//		System.out.println(im1.get(new Bbox(4, 6, 7, 9)));
		System.out.println("----------------------------");
		im1.clean();
		tmp = im1.getBboxes();
		
		for(int i=0;i<im1.getNumBoxes();i++)
			System.out.println(tmp[i]);
	}

}
