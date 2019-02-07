package polyline;

public class PolylineTest {

	public static void main(String[] args) {
		Polyline polyline = new Polyline();
		Point p1 = new Point("sadf", 1, 8);
		Point p2 = new Point("remove", 3, 5);
		Point p3 = new Point("popo", 5, 1);
		Point p4 = new Point("asdf", 4, 6);
		Point p5 = new Point("pqwer", 5, 3);
		
		polyline.addLast(p1);
		polyline.addLast(p3);
		polyline.addLast(p4);
		System.out.println("Length with p1, p3 and p4: " + polyline.length());
		polyline.addLast(p5);
		polyline.addBefore(p2, "popo");
		System.out.println(polyline.toString());
		System.out.println("\nLength before removal: " + polyline.length());
		
		polyline.setWidth(4);
		polyline.setColour("white");
		polyline.remove("remove");
		System.out.println(polyline.toString());
		System.out.println("\nLength: " + polyline.length());
		System.out.println("Colour: " + polyline.getColour());
		System.out.println("Width: " + polyline.getWidth());
		
		
		//ITERATOR TEST
		System.out.println("Iterator test:");
		Polyline.PolylineIterator iterator = polyline.new PolylineIterator();
		while(iterator.hasVertex())
		{
			System.out.println( iterator.vertex().toString() );
			iterator.advance();
		}
		
		
		
	}

}