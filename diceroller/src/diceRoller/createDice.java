package diceRoller;
import javafx.geometry.Side;

import java.beans.XMLEncoder;
import java.beans.XMLDecoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class createDice {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the dice name");
        String name = sc.next();
        System.out.println("Enter the number of sides the dice has");
        int sides = sc.nextInt();


        dice customDice = new dice(name, sides, new String[sides]);

        for(int i = 0; i < customDice.getSides(); i++)
        {
            System.out.println("What would you like side " + (i + 1) + " to be?");
            String sideName = sc.next();
            customDice.setSide(i, sideName);
        }

        customDice.xmlEncode();


    }


}
