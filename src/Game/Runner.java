package Game;
import Floors.Floor;
import Spaces.Space;
import People.Person;

import java.util.Scanner;

public class Runner {

    private static boolean gameOn = true;

    public static void main(String[] args) {


        //Floor 0
        Floor floor0 = new Floor(5, 5);
        Floor floor1 = new Floor(7, 7);
        Floor floor2 = new Floor(9, 9);
        Floor floor3 = new Floor(11, 11);
        Floor floor4 = new Floor(13, 13);
        Floor floor5 = new Floor(1, 2);

        //Floor 0
        floor0.generateShop();


        //Setup player 1 and the input scanner
        Person player1 = new Person("Bob", 4, 2, 0);
        floor0.enterSpace(player1, 4, 2);


        System.out.println(floor0);

        Scanner input = new Scanner(System.in);
        Floor currentFloor = floor0;

        while (gameOn) {
            System.out.println("Where would you like to move? (Choose N, S, E, W)");
            String move = input.nextLine();
            if (validMove(move, player1, currentFloor)) {
                System.out.println("Your coordinates: row = " + player1.getxLoc() + " col = " + player1.getyLoc());
                System.out.println(currentFloor);

            } else {
                System.out.println("Please choose a valid move.");
            }


        }
        input.close();
    }

    public static boolean validMove(String move, Person p, Floor map)
    {
        move = move.toLowerCase().trim();
        switch (move) {
            case "n":
                if (p.getxLoc() > 0)
                {
                    map.leaveSpace(p, p.getyLoc(), p.getxLoc());
                    map[p.getxLoc()-1][p.getyLoc()].enterSpace(p);
                    return true;
                }
                else
                {
                    return false;
                }
            case "e":
                if (p.getyLoc()< map[p.getyLoc()].length -1)
                {
                    map[p.getxLoc()][p.getyLoc()].leaveSpace(p);
                    map[p.getxLoc()][p.getyLoc() + 1].enterSpace(p);
                    return true;
                }
                else
                {
                    return false;
                }

            case "s":
                if (p.getxLoc() < map.length - 1)
                {
                    map[p.getxLoc()][p.getyLoc()].leaveSpace(p);
                    map[p.getxLoc()+1][p.getyLoc()].enterSpace(p);
                    return true;
                }
                else
                {
                    return false;
                }

            case "w":
                if (p.getyLoc() > 0)
                {
                    map[p.getxLoc()][p.getyLoc()].leaveSpace(p);
                    map[p.getxLoc()][p.getyLoc()-1].enterSpace(p);
                    return true;
                }
                else
                {
                    return false;
                }
            default:
                break;

        }
        return true;
    }

    public static void gameOff()
    {
        gameOn = false;
    }

}
