package People;

public class RegularGoblin extends Person{
    public RegularGoblin(String name, int xLoc, int yLoc, int floor, int money, int maxHP, int HP, String[] inventory){
        super(name, xLoc, yLoc, floor, money, maxHP, HP, inventory);
    }
    public void Attack(Person x){
        int y = (int)(Math.random()*12);
        x.changeHP(-y);
    }
}
