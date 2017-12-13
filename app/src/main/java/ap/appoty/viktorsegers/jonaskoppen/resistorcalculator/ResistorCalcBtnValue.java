package ap.appoty.viktorsegers.jonaskoppen.resistorcalculator;

/**
 * Created by jonas on 13/12/2017.
 */

public class ResistorCalcBtnValue {
    private int value;
    private int colorCode;
    private int id;

    public ResistorCalcBtnValue(int id, int value, int colorCode){
        this.id  = id;
        this.colorCode = colorCode;
        this.value = value;


    }

    public int getValue(){ return value;}

    public int getColorCode() {return colorCode;}

    public int getId(){return id;}
}
