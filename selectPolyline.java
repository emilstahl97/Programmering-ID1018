package polyline;

import java.util.Random;

class  SelectPolyline
{
	public  static  final  Random     rand = new  Random  ();
	public  static  final  int         NOF_POLYLINES = 10;

	public  static  void  main (String [] args)
	{
		//  Create a random  number  of  polylines
		Polyline []     polylines = new  Polyline[NOF_POLYLINES ];
		
		//used to determine the shortest of the yellow polylines
		Polyline shortestYellow = null;
		Polyline [] yellows = new Polyline[NOF_POLYLINES];

		int j = 0;
		for (int i = 0; i < NOF_POLYLINES; i++)
		{
			polylines[i] = randomPolyline  ();
			// Show  the  polylines
			System.out.println("Polyline " + (i+1) + ":");
			System.out.println( polylines[i].toString() );
			
			//  Determine  the  shortest  yellow  polyline
			
			//adds the polyline to the array of yellow polylines
			//if its colour is yellow
			if( polylines[i].getColour().equals("yellow") )
				yellows[j++] = polylines[i];
		}
		//sets initial value for comparison
		shortestYellow = yellows[0];
		for (int i = 1; i < yellows.length; i++) {
			//the shortest of two yellows - first condition prevents
			//the length method from being invoked on a null element
			if( yellows[i]!=null && yellows[i].length() < shortestYellow.length() )
				shortestYellow = yellows[i];
		}
		
		// Show  the  selected  polyline
		
		//prints out the shortest yellow polyline, if there were any at all
		//if there were none, the program writes that out instead
		if(shortestYellow != null)
			System.out.println("The shortest yellow polyline is: " + shortestYellow.toString());
		else
			System.out.println("There was no yellow polyline at all.");
	}
	// The  randomPoint  method  returns a new  Point  with a name
	//  randomly  chosen  from  the  single  letters A--Z. Coordinates
	// are  random.
	public  static  Point  randomPoint  ()
	{
		String     n = "" + (char) (65 + rand.nextInt  (26));
		int     x = rand.nextInt  (11);
		int     y = rand.nextInt  (11);
		return  new  Point (n, x, y);
	}
	// The  method  randomPolyline  returns a random  polyline ,
	// with a colour  either  blue , red , or  yellow. The  names
	// of the  vertices  are  single  letters  from  the  set A--Z.
	// Two  vertices  can  not  have  the  same  name.
	public  static  Polyline  randomPolyline  ()
	{
		//  Create  an empty  polyline  and  add  vertices
		Polyline     polyline = new  Polyline  ();
		int     nofVertices = 2 + rand.nextInt  (7);
		int     nofSelectedVertices = 0;

		//each element is initialized to the standard value of false
		boolean []     selectedNames = new  boolean [26];
		// Two  vertices  can  not  have  the  same  name
		Point     chosenPoint = null;
		while (nofSelectedVertices  < nofVertices)
		{
			//generates a point with name as a random capital letter
			//as well as random x- and y-coordinates
			chosenPoint = randomPoint();
			//gets the letter representing the vertex/point and
			//converts it to an index 0-26 for selectedNames[]
			int i = (char)(chosenPoint.getName().charAt(0) - 65);

			//if the letter has already been used,
			//begin a new iteration of the while-loop
			if(selectedNames[i])
			{
				continue;
			}else
			{
				//adds the vertex/point to the polyline array/vector
				polyline.addLast(chosenPoint);
				//makes sure the name will not be used again
				selectedNames[i] = true;
				//one more vertex has been added/selected
				nofSelectedVertices++;
			}
		}
		//  Assign a colour
		int colorNum = rand.nextInt(3);				  //0 - 3 (exclusive)
		//switch on colorNum which is a random int from 0 - 2 (inclusive)
		switch(colorNum)
		{
		case 0:
			polyline.setColour("blue");
			break;
		case 1:
			polyline.setColour("red");
			break;
		case 2:
			polyline.setColour("yellow");
			break;
		}
		return polyline;
	}
}