package Spaces;

import People.Person;
import People.WeakGoblin;

public class Space {
    String occupant;
    int xLoc,yLoc;

    public Space(int x, int y)
    {
        xLoc = x;
        yLoc = y;
        occupant = null;
    }

    public void enterSpace(Person x){
        int y = (int)(Math.random()*20);
        System.out.println("You entered an empty space. You found " + y + " money.");
        x.changeMoney(y);
        occupant = "Player";
        x.setxLoc(this.xLoc);
        x.setyLoc(this.yLoc);
    }

    public String toString() {
        if(occupant == null){
            return "[ ] ";
        } else if (occupant.equals("Player")){
            return "[P] ";
        }
        else {
            return "[!] ";
        }
    }

    public void leaveSpace()
    {
        occupant = null;
    }
}
