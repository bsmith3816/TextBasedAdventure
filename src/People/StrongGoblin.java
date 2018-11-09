package People;

public class StrongGoblin extends Person{
    public StrongGoblin(int money, int maxHP, int HP){
        super(money, maxHP, HP);
    }
    public void Attack(Person x){
        int y = (int)(Math.random()*20) + 1;
        x.changeHP(-y);
    }
}

