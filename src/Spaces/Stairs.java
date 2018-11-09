package Spaces;
import Floors.Floor;
import People.Person;

import java.util.Scanner;

public class Stairs extends Space{
    public Stairs (int x, int y){
        super(x,y);
        occupant = "Stairs";
    }
    public void enterSpace(Person p){
        p.setxLoc(this.xLoc);
        p.setyLoc(this.yLoc);
        occupant = "Player";
        Scanner input = new Scanner(System.in);
        System.out.println("Would you like to go to the next level? Please choose 'yes' or 'no'.");
        boolean z = false;
        String act = input.nextLine();
        while(!z) {
            if (act.equals("yes")) {
                setFloor(p,p.getFloor()+1);
                if(p.getFloor() == 1) {
                    p.setyLoc(6);
                }
                if(p.getFloor() == 2) {
                    p.setyLoc(8);
                }
                if(p.getFloor() == 3) {
                    p.setyLoc(10);
                }
                if(p.getFloor() == 4) {
                    p.setyLoc(12);
                }
                if(p.getFloor() == 5) {
                    p.setyLoc(4);
                }
                z = true;
                occupant = "";
            } else if (act.equals("no")) {
                z = true;
            } else {
                System.out.println("Please choose 'yes' or 'no'");
                act = input.nextLine();
            }
        }
    }
    public void setFloor(Person p, int x){
        p.setFloor(x);
    }
    public void leaveSpace()
    {
        occupant = "Stairs";
    }
}
