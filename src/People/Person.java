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

	public void setFloor(int x) {
		floor = x;
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
		inventory = a;
	}

	public void changeMoney(int x){
		money += x;
	}

	public int getMoney(){
		return money;
	}

	public void printInventory(){
		String result = "";
		if(inventory.length == 0){
			System.out.println("You have no items.");
		} else {
			for(int i = 0; i < inventory.length; i++){
				result += inventory[i] + " ";
			}
			System.out.println(result);
		}

	}

	public void changeHP(int x){
		HP += x;
	}
	public void changeHP(String a){
		if(a.equals("max")){
			HP = maxHP;
		}
		if(a.equals("revive")){
			HP = 25;
		}
	}

	public int getHP(){
		return HP;
	}

	public int getMaxHP(){
		return maxHP;
	}

	public void Attack(Person x){
		int y = (int)(Math.random()*5);
		x.changeHP(-y);
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
