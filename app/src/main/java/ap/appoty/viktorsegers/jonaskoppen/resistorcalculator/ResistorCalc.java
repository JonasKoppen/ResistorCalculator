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
        createButtonValue();
    }




    protected void createButtonValue(){
        buttonValue = new ArrayList<>();
        buttonValue.add(new ResistorCalcBtnValue(0,1, R.color.Black));
        buttonValue.add(new ResistorCalcBtnValue(1,2, R.color.Brown));
        buttonValue.add(new ResistorCalcBtnValue(2,3, R.color.Red));
        buttonValue.add(new ResistorCalcBtnValue(3,4, R.color.Orange));
        buttonValue.add(new ResistorCalcBtnValue(4,5, R.color.Yellow));
        buttonValue.add(new ResistorCalcBtnValue(5,6, R.color.Green));
        buttonValue.add(new ResistorCalcBtnValue(6,7, R.color.Blue));
        buttonValue.add(new ResistorCalcBtnValue(7,8, R.color.Violet));
        buttonValue.add(new ResistorCalcBtnValue(8,9, R.color.Grey));
    }
}



