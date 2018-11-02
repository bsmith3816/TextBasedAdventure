package People;

/**
 * People represents the player as they move through the game.
 */
public class Person {
	String name;
	int xLoc, yLoc, floor;
	String[] inventory;

	public int getFloor() {
		return floor;
	}

	public void setFloor() {
		this.floor = floor;
	}

	public int getxLoc() {
		return xLoc;
	}

	public void setxLoc(int xLoc) {
		this.xLoc = xLoc;
	}

	public int getyLoc() {
		return yLoc;
	}

	public void setyLoc(int yLoc) {
		this.yLoc = yLoc;
	}

	public Person(String name, int xLoc, int yLoc, int floor)
	{
		this.name = name;
		this.xLoc = xLoc;
		this.yLoc = yLoc;
		this.floor = floor;
		//this.inventory = inventory;
	}

}
