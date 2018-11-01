package Game;
import Spaces.Space;

public class Runner {

    public static void main(String[] args) {

        Space[][] floor = new Space[6][6];

        for (int x = 0; x < floor.length; x++) {
            for (int y = 0; y < floor[x].length; y++) {
                floor[x][y] = new Space(x, y);
            }
        }


    }
}
