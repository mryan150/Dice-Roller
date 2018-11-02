package diceRoller;

import java.beans.XMLEncoder;
import java.beans.XMLDecoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class dice {
    private String name;
    private int sides;
    private String[] side;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSides() {
        return sides;
    }

    public void setSides(int sides) {
        this.sides = sides;
    }

    public String[] getSide() {
        return side;
    }

    public void setSide(String[] side) {
        this.side = side;
    }

    public void setSide(int i, String sideName)
    {
        side[i] = sideName;
    }

    public String rollDice()
    {
        String result;
        Random r = new Random();


        result = side[r.nextInt(sides)];

        return result;
    }

    public dice (String name){
    }

    public dice(String name, int sides, String[] side) {
        this.name = name;
        this.sides = sides;
        this.side = side;

        for(int i = 0; i < sides; i++)
        {
            side[i] =  String.valueOf(i + 1);
        }

    }

    public dice() {
    }


    public void xmlEncode() {
        try {
            FileOutputStream fos = new FileOutputStream(new File("./" + this.name + ".xml"));
            XMLEncoder encoder = new XMLEncoder(fos);
            encoder.writeObject(this);
            encoder.close();
            fos.close();
        } catch (IOException var3) {
            var3.printStackTrace();
        }



    }

    public String xmlDecode(String title){
        try{
            FileInputStream fis = new FileInputStream(new File("./" + title + ".xml"));
            XMLDecoder decoder = new XMLDecoder((fis));

            dice d4 = (dice)decoder.readObject();
            decoder.close();
            fis.close();

            String result = (d4.rollDice());
            System.out.println(result);
            return result;
        }

        catch(IOException ex) {
            ex.printStackTrace();
        }

    return "0";
    }


}