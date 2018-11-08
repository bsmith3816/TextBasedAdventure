package Floors;
import People.Person;
import Spaces.Space;
import Spaces.Shop;
import Spaces.Enemy;


public class Floor {
    private Space[][] floor;
    private int width, height, floorNum;

    public Floor(Space[][] x){
        floor = x;
    }

    public Floor(int w, int h, int f){
        floor = new Space[h][w];
        for(h = 0; h < floor.length; h++){
            for(w = 0; w < floor[h].length; w++){
                floor[h][w] = new Space(w, h);
            }
        }
        width = w;
        height = h;
        floorNum = f;
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
        floor[y][x] = new Shop(x, y);
    }

    public void generateEnemies(int a){
        for(int i = 0; i < a; i++){
            int x = (int)(Math.random()*width);
            int y = (int)(Math.random()*height);
            floor[y][x] = new Enemy(x, y, floorNum);
        }
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
