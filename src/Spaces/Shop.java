package Spaces;

import People.Person;

import java.util.Scanner;

public class Shop extends Space{

    public Shop(int x, int y){
        super(x, y);
    }

    @Override
    public void enterSpace(Person x){
        occupant = x;
        x.setxLoc(this.xLoc);
        x.setyLoc(this.yLoc);

        boolean leave = false;
        Scanner input = new Scanner(System.in);
        System.out.println("You entered the store.");

        while(leave == false){
            System.out.println("What would you like to buy? You have " + x.getMoney() + " money.");
            System.out.println("Potion - 50G");
            System.out.println("Green Shroom - 100G");
            System.out.println("Spell - 100G");
            System.out.println("Exit.");
            String act = input.nextLine();
            if(act.toLowerCase().equals("exit")){
                leave = true;
            }
            if(act.toLowerCase().equals("potion")){
                if(x.getMoney() >= 50){
                    x.addInventory("Potion");
                    x.changeMoney(-50);
                    System.out.println("You purchased a potion. You now have " + x.getMoney() + " money.");
                }
                else {
                    System.out.println("You don't have enough money for that!");
                }
            }
            if(act.toLowerCase().equals("green shroom")){
                if(x.getMoney() >= 100){
                    x.addInventory("Green Shroom");
                    x.changeMoney(-100);
                    System.out.println("You purchased a potion. You now have " + x.getMoney() + " money.");
                }
                else {
                    System.out.println("You don't have enough money for that!");
                }
            }
            if(act.toLowerCase().equals("spell")){
                if(x.getMoney() >= 100){
                    x.addInventory("Spell");
                    x.changeMoney(-100);
                    System.out.println("You purchased a potion. You now have " + x.getMoney() + " money.");
                }
                else {
                    System.out.println("You don't have enough money for that!");
                }
            }
        }
    }

    @Override
    public String toString(){
        return "[S] ";
    }
}
