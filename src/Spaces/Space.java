package Spaces;

import People.Person;

public class Space {
    Person occupant;
    int xLoc,yLoc;

    public Space(int x, int y)
    {
        xLoc = x;
        yLoc = y;
    }

    public void enterSpace(Person x){
        System.out.println("You entered an empty space.");
        occupant = x;
        x.setxLoc(this.xLoc);
        x.setyLoc(this.yLoc);
    }

    public void leaveSpace()
    {
        occupant = null;
    }
}
