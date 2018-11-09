package Spaces;

import People.Person;

public class Win extends Space{
    public Win(int x, int y){
        super(x,y);
    }
    public void enterSpace(Person x){
        System.out.println("You made it to the end of the dungeon! You win!");
        System.exit(0);
    }
}
