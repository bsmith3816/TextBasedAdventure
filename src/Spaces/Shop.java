package Spaces;

import People.Person;

import java.util.Scanner;

public class Shop extends Space{

    public Shop(int x, int y){
        super(x, y);
        occupant = "Shop";
    }

    @Override
    public void enterSpace(Person x){
        x.setxLoc(this.xLoc);
        x.setyLoc(this.yLoc);
        occupant = "Player";

        boolean leave = false;
        Scanner input = new Scanner(System.in);
        System.out.println("You entered the store.");

        while(!leave){
            System.out.println("What would you like to buy? You have " + x.getMoney() + " money.");
            System.out.println("Potion - 50G; heals for 25 HP");
            System.out.println("Green Shroom - 100G; if you reach 0 HP on the same turn you use it, you will be revived with 50% max HP");
            System.out.println("Spell - 80G; deal 25 dmg to the enemy");
            System.out.println("Exit.");
            String act = input.nextLine();
            if(act.toLowerCase().equals("exit")){
                leave = true;
            }
            if(act.toLowerCase().equals("potion")){
                if(x.getMoney() >= 50){
                    x.addInventory("Potion");
                    x.changeMoney(-50);
                    System.out.println("You purchased a potion.");
                }
                else {
                    System.out.println("You don't have enough money for that!");
                }
            }
            if(act.toLowerCase().equals("green shroom")){
                if(x.getMoney() >= 100){
                    x.addInventory("Green Shroom");
                    x.changeMoney(-100);
                    System.out.println("You purchased a Green Shroom.");
                }
                else {
                    System.out.println("You don't have enough money for that!");
                }
            }
            if(act.toLowerCase().equals("spell")){
                if(x.getMoney() >= 80){
                    x.addInventory("Spell");
                    x.changeMoney(-80);
                    System.out.println("You purchased a Spell.");
                }
                else {
                    System.out.println("You don't have enough money for that!");
                }
            }
        }
    }
    @Override
    public void leaveSpace(){
        occupant = "Shop";

    }
}
