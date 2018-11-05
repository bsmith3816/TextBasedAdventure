package Floors;
import People.Person;
import Spaces.Space;
import Spaces.Shop;


public class Floor {
    private Space[][] floor;
    private int width, height;

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
        width = w;
        height = h;
    }

    public void enterSpace(Person a, int y, int x){
        floor[y][x].enterSpace(a);
    }
    public void leaveSpace(int y, int x){
        floor[y][x].leaveSpace();
    }

    public void generateShop(){
        int x = (int)(Math.random()*width);
        int y = (int)(Math.random()*height);
        floor[x][y] = new Shop(x, y);
    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
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
