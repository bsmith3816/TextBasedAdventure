package People;

/**
 * People represents the player as they move through the game.
 */
public class Person {
	String name;
	int xLoc, yLoc, floor, money, maxHP, HP;
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

	public void addInventory(String x){
		String[] a = new String[inventory.length + 1];
		for(int i = 0; i < inventory.length;i++){
			a[i] = inventory[i];
		}
		a[inventory.length] = x;
	}

	public void changeMoney(int x){
		money += x;
	}

	public int getMoney(){
		return money;
	}

	public String printInventory(){
		String result = "";
		if(inventory.length == 0){
			return "You have no items.";
		} else {
			for(int i = 0; i < inventory.length; i++){
				result += inventory[i] + " ";
			}
			return result;
		}

	}

	public void changeHP(int x){
		HP += x;
	}

	public int getHP(){
		return HP;
	}

	public int getMaxHP(){
		return maxHP;
	}

	public Person(String name, int yLoc, int xLoc, int floor, int money, int maxHP, int HP, String[] inventory)
	{
		this.name = name;
		this.xLoc = xLoc;
		this.yLoc = yLoc;
		this.floor = floor;
		this.money = money;
		this.maxHP = maxHP;
		this.HP = HP;
		this.inventory = inventory;
	}



}
