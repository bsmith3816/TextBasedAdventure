package Game;
import Floors.Floor;
import Spaces.Space;
import People.Person;

import java.util.Scanner;

public class Runner {

    private static boolean gameOn = true;

    public static void main(String[] args) {


        //Floor 0
        Floor floor0 = new Floor(5, 5, 0);
        Floor floor1 = new Floor(7, 7, 1);
        Floor floor2 = new Floor(9, 9, 2);
        Floor floor3 = new Floor(11, 11, 3);
        Floor floor4 = new Floor(13, 13, 4);
        Floor floor5 = new Floor(1, 2, 5);

        //Floor 0
        floor0.generateShop();
        floor0.generateEnemies(3);


        //Setup player 1 and the input scanner
        String[] inventory = new String[0];
        Person player1 = new Person("Bob", 4, 2, 0, 50, 50, 50, inventory);
        floor0.enterSpace(player1, 4, 2);


        System.out.println(floor0);

        Scanner input = new Scanner(System.in);
        Floor currentFloor = floor0;

        //Turn
        while (gameOn) {
            System.out.println("What would you like to do? Type 'move' or 'help'.");
            String action = input.nextLine();
            //Move
            if (action.equals("move")){
                System.out.println("Where would you like to move? (Choose N, S, E, W)");
                String move = input.nextLine();

                if (validMove(move, player1, currentFloor)) {
                    System.out.println("Your coordinates: row = " + player1.getyLoc() + " col = " + player1.getxLoc());
                    System.out.println(currentFloor);

                } else {
                    System.out.println("Please choose a valid move.");
                }
            }
            // Help
            else if (action.equals("help")){
                System.out.println("[P] stands for the space you are currently in." +
                        "[S] stands for a store space, where you can purchase items" +
                        "[^] stands for a staircase, where you can progress to the next floor." +
                        "[ ] may be an empty space, or there may be an enemy, in which you would need to fight.");
            }

            else {
                System.out.println("Please choose a valid action.");
            }

        }
        input.close();
    }

    //Checks if input is valid move and if so, makes the move
    public static boolean validMove(String move, Person p, Floor map)
    {
        move = move.toLowerCase().trim();
        switch (move) {
            case "n":
                if (p.getyLoc() > 0)
                {
                    map.leaveSpace(p.getyLoc(), p.getxLoc());
                    map.enterSpace(p,p.getyLoc()-1,p.getxLoc());
                    return true;
                }
                else
                {
                    return false;
                }
            case "e":
                if (p.getxLoc() < map.getWidth() -1)
                {
                    map.leaveSpace(p.getyLoc(), p.getxLoc());
                    map.enterSpace(p,p.getyLoc(),p.getxLoc()+1);
                    return true;
                }
                else
                {
                    return false;
                }

            case "s":
                if (p.getyLoc() < map.getHeight() - 1)
                {
                    map.leaveSpace(p.getyLoc(), p.getxLoc());
                    map.enterSpace(p,p.getyLoc()+1,p.getxLoc());
                    return true;
                }
                else
                {
                    return false;
                }

            case "w":
                if (p.getxLoc() > 0)
                {
                    map.leaveSpace(p.getyLoc(), p.getxLoc());
                    map.enterSpace(p,p.getyLoc(),p.getxLoc()-1);
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

    //Shuts the game off
    public static void gameOff()
    {
        gameOn = false;
    }

}
