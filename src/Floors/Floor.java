package Floors;
import People.Person;
import Spaces.Space;


public class Floor {
    private Space[][] floor;

    public Floor(Space[][] x){
        floor = x;
    }
    public Floor(int w, int h){
        floor = new Space[w][h];
        for(w = 0; w < floor.length; w++){
            for(h = 0; h < floor[w].length; h++){
                floor[w][h] = new Space(w, h);
            }
        }
    }
    public void enterSpace(Person a, int x, int y){
        floor[x][y].enterSpace(a);
    }

    // Prints Floor
    public String toString(){
        String output = "";
        for(int x = 0; x < floor.length; x++){
            for(int y = 0; y < floor[x].length; y++){
                output += floor[x][y].toString();
            }
            output += "\n";
        }
        return output;
    }
}
