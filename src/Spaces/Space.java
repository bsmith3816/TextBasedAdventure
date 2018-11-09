package Spaces;

import People.Person;
import People.WeakGoblin;

public class Space {
    String occupant;
    int xLoc,yLoc;
    boolean clear = false;

    public Space(int x, int y)
    {
        xLoc = x;
        yLoc = y;
        occupant = null;
    }

    public boolean hasOccupant(){
        if(occupant == null){
            return false;
        }
        return true;
    }

    public void enterSpace(Person x){
        if(!clear) {
            int y = (int) (Math.random() * 20);
            System.out.println("You entered an empty space. You found " + y + " money.");
            x.changeMoney(y);
            occupant = "Player";
            x.setxLoc(this.xLoc);
            x.setyLoc(this.yLoc);
            clear = true;
        } else {
            System.out.println("You entered an empty space.");
            occupant = "Player";
            x.setxLoc(this.xLoc);
            x.setyLoc(this.yLoc);
        }
    }

    public String toString() {
        if(occupant == null){
            return "[ ] ";
        } else if (occupant.equals("Player")) {
            return "[P] ";
        } else if (occupant.equals("Shop")){
            return "[S] ";
        } else if (occupant.equals("Stairs")){
            return "[^] ";
        } else if (occupant.equals("Empty")){
            return "[x] ";
        }
        else {
            return "[!] ";
        }
    }

    public void leaveSpace()
    {
        occupant = "Empty";
    }
}
