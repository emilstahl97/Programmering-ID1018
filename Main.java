package min;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//16-element
		int[] elements = {5, 19, 7, -3, 20, 43, 17, -16, 10, -15, -32, 40, -7, -25, 37, -1};
		
		//19-element
		//int[] elements = {5, 19, 7, -3, 20, 43, 17, -16, 10, -15, -32, 40, -7, -25, 37, -1, -100, 50, 66};
		int x = Min.min(elements);
		int y = memoryEfficient.memMin(elements);
                
		System.out.println("Lowest value element is: " + x + " \nNumber of elements:  " + elements.length);
	
	}

}