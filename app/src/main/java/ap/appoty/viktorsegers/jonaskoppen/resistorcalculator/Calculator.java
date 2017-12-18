package ap.appoty.viktorsegers.jonaskoppen.resistorcalculator;

/**
 * Created by Viktor on 13-12-2017.
 */

public class Calculator {
    private String name;
    private int image;
    private Class klasse; //added by jonas, remove comment when viewed

    //constructor
    public Calculator(String name, int image, Class klasse){
        this.name = name;
        this.image = image;
        this.klasse = klasse;
    }


    //properties
    public String getName(){return name;}
    public int getImage(){return image;}
    public Class getKlasse(){return  klasse;}
}
