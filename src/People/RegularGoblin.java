package People;

public class RegularGoblin extends Person{
    public RegularGoblin(int money, int maxHP, int HP){
        super(money, maxHP, HP);
    }
    public void Attack(Person x){
        int y = (int)(Math.random()*12) + 1;
        x.changeHP(-y);
    }
}
