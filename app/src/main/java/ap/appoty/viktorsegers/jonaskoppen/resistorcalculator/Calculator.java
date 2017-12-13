package ap.appoty.viktorsegers.jonaskoppen.resistorcalculator;

/**
 * Created by Viktor on 13-12-2017.
 */

public class Calculator {
    private String name;
    private int image;

    //constructor
    public Calculator(String name, int image){
        this.name = name;
        this.image = image;
    }


    //properties
    public String getName(){return name;}
    public int getImage(){return image;}
}
