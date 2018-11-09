package Spaces;

import People.Person;
import People.RegularGoblin;
import People.StrongGoblin;
import People.WeakGoblin;

import java.util.Scanner;

public class Enemy extends Space{
    private int floor;
    private Person e;
    private boolean defeat = false;
    public Enemy(int x, int y, int floor){
        super(x,y);
        this.floor = floor;
        if(this.floor == 0) {
            occupant = "Weak Goblin";
            e = new WeakGoblin(10, 15, 15);
        }
        if(this.floor == 1 || this.floor == 2) {
            occupant = "Regular Goblin";
            e = new RegularGoblin(10, 30, 30);
        }
        if(this.floor == 3 || this.floor == 4) {
            occupant = "Strong Goblin";
            e = new StrongGoblin(10, 50, 50);
        }
    }
    public void enterSpace(Person p){
        if(!defeat) {
            boolean gShroom = false;
            boolean z = false;
            Scanner input = new Scanner(System.in);
            System.out.println("An enemy attacked!");
            System.out.println("You have " + p.getHP() + "/" + p.getMaxHP() + " HP. The enemy has " + e.getHP() + " HP.");
            while (!defeat) {
                System.out.println("What would you like to do? 'Attack', 'Defend', or 'Use Item'?");
                z = false;
                String act = input.nextLine();
                if (act.toLowerCase().equals("attack")) {
                    e.changeHP((int) (Math.random() * (p.getLevel()) * -5) - (5 * p.getLevel()));
                    e.Attack(p);
                    if (p.getHP() <= 0 && !gShroom) {
                        gameOver();
                    } else if (p.getHP() <= 0 && gShroom) {
                        revive(p);
                    } else if (e.getHP() <= 0) {
                        defeat = true;
                    } else {
                        System.out.println("You have " + p.getHP() + "/" + p.getMaxHP() + " HP. The enemy has " + e.getHP() + " HP.");
                    }

                } else if (act.toLowerCase().equals("defend")) {
                    e.Attack(p);
                    p.changeHP((int) (Math.random() * 4) + 1);
                    if(p.getHP() > p.getMaxHP()){
                        p.changeHP("max");
                    }
                    System.out.println("You have " + p.getHP() + "/" + p.getMaxHP() + " HP. The enemy has " + e.getHP() + " HP.");
                } else if (act.toLowerCase().equals("use item")) {
                    if(p.emptyInventory()){
                        z = true;
                        System.out.println("Your inventory is empty.");
                    }
                    while(!z) {
                        p.printInventory();
                        System.out.println("Which item would you like to use? Type 'cancel' to go back.");
                        act = input.nextLine();
                        if (act.toLowerCase().equals("green shroom") && p.hasItem("Green Shroom")) {
                            gShroom = true;
                            z = true;
                            e.Attack(p);
                        } else if (act.toLowerCase().equals("potion") && p.hasItem("Potion")) {
                            p.changeHP(25);
                            if(p.getHP() > p.getMaxHP()){
                                p.changeHP("max");
                            }
                            z = true;
                            e.Attack(p);
                        } else if (act.toLowerCase().equals("spell") && p.hasItem("Spell")) {
                            e.changeHP(-25);
                            z = true;
                            e.Attack(p);
                        } else if (act.toLowerCase().equals("cancel")) {
                            z = true;
                        } else {
                            System.out.println("Please choose an item you have.");
                        }
                    }
                    if (p.getHP() <= 0 && !gShroom) {
                        gameOver();
                    } else if (p.getHP() <= 0 && gShroom) {
                        revive(p);
                        gShroom = false;
                    } else if (e.getHP() <= 0) {
                        defeat = true;
                    } else {
                        gShroom = false;
                        System.out.println("You have " + p.getHP() + "/" + p.getMaxHP() + " HP. The enemy has " + e.getHP() + " HP.");
                    }
                } else {
                    System.out.println("Please choose a valid action!");
                }

            }
            p.changeMoney(e.getMoney());
            p.addSlain();
            occupant = "Player";
            p.setxLoc(this.xLoc);
            p.setyLoc(this.yLoc);
            System.out.println("You won the fight! You found " + e.getMoney() + " money.");
        } else {
            System.out.println("You entered an empty space.");
            occupant = "Player";
            p.setxLoc(this.xLoc);
            p.setyLoc(this.yLoc);
        }
    }
    public void gameOver(){
        System.out.println("Game Over! You died.");
        System.exit(0);
    }
    public void revive(Person p){
        p.changeHP("revive");
    }
}
