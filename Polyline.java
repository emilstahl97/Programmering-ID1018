package polyline;

public  class  Polyline
{
	private  Point[]     vertices;
	private  String      colour = "black";
	private  int          width = 1;
	
	
	//CONSTRUCTORS
	public  Polyline  ()
	{
		this.vertices = new  Point [0];
	}
	public  Polyline (Point []  vertices)
	{
		//creates a new array with copies of the passed array's elements
		this.vertices = new  Point[vertices.length];
		for (int i = 0; i < vertices.length; i++)
			this.vertices[i] = new  Point (vertices[i]);
	}
	//CONSTRUCTORS END

	//Example:
	//{[(A 1 2), (B 2 3), (C 3 4)], black, 1}
	public  String  toString() 
	{
		String result = "{[";

		//adds all the elements (in their toString() form with commas in between
		for (int i = 0; i < vertices.length; i++)
		{
			result += vertices[i].toString();
			//prevents adding a comma at the end
			if(i < vertices.length-1)
				result += ", ";
		}
		result += "], " + colour + ", " + width + "}";

		return result;
	}

	//GETTERS
	public  Point []  getVertices  ()
	{
		//creates a new array, loops through all the elements
		//in the old array and adds them to the new one which is then returned
		Point[] h = new Point[vertices.length];
		for (int i = 0; i < vertices.length; i++) {
			h[i] = vertices[i];
		}
		return h;
	}
	public  String  getColour  ()
	{
		return colour;
	}
	public  int  getWidth  () 
	{
		return width;
	}
	//END OF GETTERS

	//SETTERS
	public  void  setColour (String  colour)
	{
		this.colour = colour;
	}
	public  void  setWidth (int  width)
	{
		this.width = width;
	}
	//END OF SETTERS

	//returns the length of the entire Polyline (the added length between all the Points)
	public  double  length  ()
	{
		double length = 0;
		Point[] h = this.vertices;
		for (int i = 1; i < h.length; i++)
		{
			//length between the previous point and the current point
			length += h[i-1].distance(h[i]);
		}
		return length;
	}


	public  void  addLast (Point  vertex)
	{
		Point[]     h = new  Point[this.vertices.length + 1];
		int     i = 0;
		for (i = 0; i < this.vertices.length; i++)
			h[i] = this.vertices[i];
		h[i] = new  Point (vertex );
		this.vertices = h;
	}
	public  void  addBefore (Point  vertex , String  vertexName)
	{
		//creates a copy of the passed Point
		Point copy = new Point(vertex.getName(), vertex.getX(), vertex.getY());
		//creates a new array of Points with space for the new Point
		Point[]		h = new  Point[this.vertices.length + 1];

		boolean added = false;		
		//loops through the vertices array and places each Point one index higher
		for (int i = 0; i < h.length; i++)
		{
			if(!added)
			{
				if(this.vertices[i].getName().equals(vertexName))
				{
					added = true;
					h[i] = copy;
				}
				
				else
					h[i] = vertices[i];

				//when the copy is added, the next element in h should be
				//from the previous index in this.vertices[]
			}else
				h[i] = this.vertices[i-1];
		}//end of for
		this.vertices = h;
	}
	
	
	public  void  remove (String  vertexName)
	{
		Point[]		h = new	 Point[this.vertices.length - 1];
		boolean removed = false;
		for (int i = 0; i < h.length; i++)
		{
			//assigns the point from the next index to the current index
			//since one element has been removed
			if(removed){
				h[i] = vertices[i+1];
			}
			else{//before removed
				//Checks the point that is to be copied to the new array
				//to see if its name matches the name from the parameter
				if(this.vertices[i].getName().equals(vertexName))
				{
					removed = true;
					h[i] = vertices[i+1];
				}
				else
				{
					h[i] = vertices[i];

				}
			}//end of before removed
		}//end of for
		this.vertices = h;
	}

	//INNER CLASS POLYLINEITERATOR
	public  class  PolylineIterator
	{
		private  int     current =  -1;
		public  PolylineIterator  ()
		{
			if (Polyline.this.vertices.length  > 0)
				current = 0;
		}
		public  boolean  hasVertex  ()
		{
			return  current  !=  -1;
		}
		public  Point  vertex  ()
				throws  java.util.NoSuchElementException
		{
			if (!this.hasVertex  ())
				throw  new  java.util.NoSuchElementException (
						"end of  iteration");
			Point     vertex = Polyline.this.vertices[current ];
			return  vertex;
		}
		public  void  advance  ()
		{
			if (current  >= 0   &&
					current  < Polyline.this.vertices.length  - 1)
				current ++;
			else
				current =  -1;
		}
	}

}