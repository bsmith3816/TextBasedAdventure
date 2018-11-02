package Game;
import Floors.Floor;
import Spaces.Space;
import People.Person;

public class Runner {

    public static void main(String[] args) {

        //Floor 1
        Floor floor1 = new Floor(6,6);

        //Setup player 1 and the input scanner
        Person player1 = new Person("Bob", 0, 0,0);
        floor1.enterSpace(player1, 0, 0);



        System.out.println(floor1);

        /*
        for (int x = 0; x < floor1.length; x++) {
            for (int y = 0; y < floor1[x].length; y++) {
                floor1[x][y] = new Space(x, y);
            }
        }
        */

    }
}
