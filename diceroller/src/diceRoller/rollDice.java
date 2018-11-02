package diceRoller;

import java.util.Scanner;

public class rollDice {
    public static void main(String[] args) {
        boolean done = false;
        while( done == false) {
            System.out.println("What dice would you like to roll?");
            Scanner sc = new Scanner(System.in);

            String name = sc.next();

            dice roll = new dice(name);
            roll.xmlDecode(name);
        }
    }
}
