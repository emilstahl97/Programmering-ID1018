package polyline;

public class Point {
	private String name = "";
	private int x, y;
	
	
	/** Constructor for creating a new point.
	 * 
	 * @param name : The name of the point, represented as a char.
	 * @param x : The horizontal coordinate.
	 * @param y : The vertical coordinate.
	 */
	public Point(String name, int x, int y)
	{
		this.name = name;
		this.x = x;
		this.y = y;
		
	}
	
	/** Constructor for copying a point.
	 * 
	 * @param point : creates a copy of the given point
	 */
	public Point(Point p)
	{
		this.name = p.getName();
		this.x = p.getX();
		this.y = p.getY();
	}
	
	public double distance(Point p2)
	{
		int x = p2.getX();
		int y = p2.getY();
            
                //(x2-x1)^2 + (y2-y1)^2
		return Math.sqrt(  Math.pow(this.x-x, 2) + Math.pow(this.y-y, 2)  );
	}
	public String toString()
	{
		return "(" + this.name + " " + this.x + " " + this.y + ")";
	}
	public boolean equals(Point p2)
	{
		if(this.x == p2.getX() && this.y == p2.getY() && this.name == p2.getName())
			return true;
		else return false;
	}
	
	
	//GETTERS
	public String getName()
	{
		return this.name;
	}
	public int getX()
	{
		return this.x;
	}
	public int getY()
	{
		return this.y;
	}
	//END OF GETTERS
	
	//SETTERS
	public void setX(int x)
	{
		this.x = x;
	}
	public void setY(int y)
	{
		this.y = y;
	}
	//END OF SETTERS
}