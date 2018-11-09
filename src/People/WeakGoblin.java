package People;

public class WeakGoblin extends Person{
    public WeakGoblin(int money, int maxHP, int HP){
        super(money, maxHP, HP);
    }
    public void Attack(Person x){
        int y = (int)(Math.random()*5) + 1;
        x.changeHP(-y);
    }
}
