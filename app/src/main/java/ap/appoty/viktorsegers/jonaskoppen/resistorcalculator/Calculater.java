package ap.appoty.viktorsegers.jonaskoppen.resistorcalculator;

/**
 * Created by Viktor on 13-12-2017.
 */

public class Calculater {
    private int name;
    private int image;

    //constructor
    public Calculater(int name, int image){
        this.name = name;
        this.image = image;
    }


    //properties
    public int getName(){return name};
    public int getImage(){return image};
}
