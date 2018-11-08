package Spaces;

import People.Person;
import People.WeakGoblin;

import java.util.Scanner;

public class Enemy extends Space{
    private int floor;
    private WeakGoblin e;
    private boolean defeat = false;
    public Enemy(int x, int y, int floor){
        super(x,y);
        this.floor = floor;
        String[] gInventory = new String[0];
        if(floor == 0) {
            occupant = "Weak Goblin";
            e = new WeakGoblin("Weak Goblin", x, y, floor, 10, 15, 15, gInventory);
        }
    }
    public void enterSpace(Person p){
        if(!defeat) {
            boolean gShroom = false;
            Scanner input = new Scanner(System.in);
            System.out.println("An enemy attacked!");
            System.out.println("You have " + p.getHP() + " HP. The enemy has " + e.getHP() + " HP.");
            while (!defeat) {
                System.out.println("What would you like to do? 'Attack', 'Defend', or 'Use Item'?");
                String act = input.nextLine();
                if (act.toLowerCase().equals("attack")) {
                    e.changeHP((int) (Math.random() * -10) - 5);
                    e.Attack(p);
                    if (p.getHP() <= 0 && gShroom == false) {
                        gameOver();
                    } else if (p.getHP() <= 0 && gShroom == true) {
                        revive(p);
                    } else if (e.getHP() <= 0) {
                        defeat = true;
                    } else {
                        System.out.println("You have " + p.getHP() + " HP. The enemy has " + e.getHP() + " HP.");
                    }

                } else if (act.toLowerCase().equals("defend")) {
                    e.Attack(p);
                    p.changeHP((int) (Math.random() * 5));
                } else if (act.toLowerCase().equals("use item")) {
                    System.out.println("Which item would you like to use?");
                    p.printInventory();
                    act = input.nextLine();
                    if (act.toLowerCase().equals("green shroom")) {
                        gShroom = true;
                    } else if (act.toLowerCase().equals("potion")) {
                        p.changeHP(25);
                    } else if (act.toLowerCase().equals("spell")) {
                        e.changeHP(-25);
                    } else {
                        System.out.println("No item was used.");
                    }
                    e.Attack(p);
                } else {
                    System.out.println("Please choose a valid action!");
                }

            }
            p.changeMoney(e.getMoney());
            occupant = "Player";
            p.setxLoc(this.xLoc);
            p.setyLoc(this.yLoc);
            System.out.println("You won the fight! You found " + e.getMoney() + " money.");
        }
    }
    public void gameOver(){
        System.out.println("Game Over! You died.");
        System.exit(0);
    }
    public void revive(Person p){
        p.changeHP(p.getMaxHP());
    }
}
