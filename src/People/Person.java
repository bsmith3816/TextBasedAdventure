package People;

/**
 * People represents the player as they move through the game.
 */
public class Person {
	String name;
	int xLoc, yLoc, floor, money, maxHP, HP, level, slain;
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

	public boolean emptyInventory(){
		if(inventory.length == 0){
			return true;
		} return false;
	}

	public void changeMoney(int x){
		money += x;
	}

	public int getMoney(){
		return money;
	}

	public boolean hasItem(String str){
		for(int i = 0; i < inventory.length; i++){
			if(inventory[i].equals(str)){
				return true;
			}
		}
		return false;
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

	public void addSlain(){
		slain++;
		if(slain == 3){
			level++;
			maxHP += 5;
			System.out.println("You reached level 2!");
		}
		if(slain == 7){
			level++;
			maxHP += 5;
			System.out.println("You reached level 3!");
		}
		if(slain == 11){
			level++;
			maxHP += 5;
			System.out.println("You reached level 4!");
		}
		if(slain == 15){
			level++;
			maxHP += 5;
			System.out.println("You reached level 5!");
		}
		if(slain == 19){
			level++;
			maxHP += 5;
			System.out.println("You reached level 6!");
		}
		if(slain == 23){
			level++;
			maxHP += 5;
			System.out.println("You reached level 7!");
		}
		if(slain == 27){
			level++;
			maxHP += 5;
			System.out.println("You reached level 8!");
		}
		if(slain == 31){
			level++;
			maxHP += 5;
			System.out.println("You reached level 9!");
		}
		if(slain == 35){
			level++;
			maxHP += 5;
			System.out.println("You reached level 10!");
		}
	}

	public int getLevel(){
		return level;
	}

	public void Attack(Person x){
		int y = (int)(Math.random()*5);
		x.changeHP(-y);
	}

	public Person(String name, int yLoc, int xLoc, int floor, int money, int maxHP, int HP, int level, int slain, String[] inventory)
	{
		this.name = name;
		this.xLoc = xLoc;
		this.yLoc = yLoc;
		this.floor = floor;
		this.money = money;
		this.maxHP = maxHP;
		this.HP = HP;
		this.level = level;
		this.slain = slain;
		this.inventory = inventory;
	}
	public Person(int money, int maxHP, int HP){
		this.money = money;
		this.maxHP = maxHP;
		this.HP = HP;
	}



}
