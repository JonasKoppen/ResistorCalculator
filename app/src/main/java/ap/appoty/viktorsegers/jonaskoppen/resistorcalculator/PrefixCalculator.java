package ap.appoty.viktorsegers.jonaskoppen.resistorcalculator;

/**
 * Created by Joren on 20/12/2017.
 */

public class PrefixCalculator{

    public Double getWaarde (Double getal){
        if(getal < Math.pow(10,-6)){
            return (getal/Math.pow(10,-9));
        }
           else if(getal < Math.pow(10,-3)){
            return (getal/Math.pow(10,-6));
        }
        else if(getal < Math.pow(10,0)){
            return (getal/Math.pow(10,-3));
        }
        else if(getal < Math.pow(10,3)){
            return (getal/Math.pow(10,0));
        }
        else if(getal < Math.pow(10,6)){
            return (getal/Math.pow(10,3));
        }
        else if(getal < Math.pow(10,9)){
            return (getal/Math.pow(10,6));
        }
        else{
            return (getal/Math.pow(10,9));
        }
    }

    public String getPrefix (Double getal){
        if(getal < Math.pow(10,-6)){
            return  "n";
        }
        else if(getal < Math.pow(10,-3)){
            return  "µ";
        }
        else if(getal < Math.pow(10,0)){
            return  "m";
        }
        else if(getal < Math.pow(10,3)){
            return  "";
        }
        else if(getal < Math.pow(10,6)){
            return  "K";
        }
        else if(getal < Math.pow(10,9)){
            return  "M";
        }
        else{
            return  "G";
        }
    }
}
