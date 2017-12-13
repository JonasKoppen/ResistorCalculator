package ap.appoty.viktorsegers.jonaskoppen.resistorcalculator;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ResistorCalc extends AppCompatActivity {

    TextView txtOut;
    ArrayList<ResistorCalcBtnValue> buttonValue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resistor_calc);
    }




    protected void createButtonValue(){
        buttonValue = new ArrayList<>();
        buttonValue.add(new ResistorCalcBtnValue(0,1, R.color.Black));
        buttonValue.add(new ResistorCalcBtnValue(1,2, R.color.Brown));
        buttonValue.add(new ResistorCalcBtnValue(2,3, Color.BLACK));
        buttonValue.add(new ResistorCalcBtnValue(3,4, Color.BLACK));
        buttonValue.add(new ResistorCalcBtnValue(4,5, Color.BLACK));
        buttonValue.add(new ResistorCalcBtnValue(5,6, Color.BLACK));
        buttonValue.add(new ResistorCalcBtnValue(6,7, Color.BLACK));
        buttonValue.add(new ResistorCalcBtnValue(7,8, Color.BLACK));
        buttonValue.add(new ResistorCalcBtnValue(8,9, Color.BLACK));
    }
}



