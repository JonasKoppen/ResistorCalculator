package ap.appoty.viktorsegers.jonaskoppen.resistorcalculator;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;

public class ResistorCalc extends Activity {

    TextView txtOut;
    ArrayList<ResistorCalcBtnValue> buttonValue;

    ListView listFirstNum;
    ListView listSecNum;
    ListView listFactor;
    ListView listTolerance;

    int firstNumId;
    int secNumId;
    int factorId;
    int tolaeranceId;

    ResistorCalcView resistorCalcView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resistor_calc2);
        createButtonValue();

        resistorCalcView = findViewById(R.id.resistorCalcView);

        firstNumId = 1;
        secNumId = 0;
        factorId = 0;
        tolaeranceId = 0;

        txtOut = (TextView) findViewById(R.id.resistorCalcValue);
        updateText();



        listFirstNum = findViewById(R.id.firstNum);
        listFirstNum.setAdapter(new ResistorCalcAdaptor(this, buttonValue));
        listFirstNum.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.i("First", String.valueOf(buttonValue.get(i).getValue()));
                firstNumId = buttonValue.get(i).getId();
                updateText();
            }
        });

        listSecNum = findViewById(R.id.secNum);
        listSecNum.setAdapter(new ResistorCalcAdaptor(this, buttonValue));
        listSecNum.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.i("Second", String.valueOf(buttonValue.get(i).getValue()));
                secNumId = buttonValue.get(i).getId();
                updateText();
            }
        });

        listFactor = findViewById(R.id.factor);
        listFactor.setAdapter(new ResistorCalcAdaptor(this, buttonValue));
        listFactor.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.i("Factor", String.valueOf(buttonValue.get(i).getValue()));
                factorId = buttonValue.get(i).getId();
                updateText();
            }
        });

        listTolerance = findViewById(R.id.tolerantie);
        listTolerance.setAdapter(new ResistorCalcAdaptor(this, buttonValue));
        listTolerance.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.i("Tolerantie", String.valueOf(buttonValue.get(i).getValue()));
                tolaeranceId = buttonValue.get(i).getId();
                updateText();
            }
        });
    }



    public void updateText(){
        double value = ((buttonValue.get(firstNumId).getValue() * 10) + buttonValue.get(secNumId).getValue() ) * (Math.pow(10, ((buttonValue.get(factorId).getValue()) % 3)));
        txtOut.setText(String.valueOf(value));
        resistorCalcView.setColors(
                ContextCompat.getColor(this, buttonValue.get(firstNumId).getColorCode()),
                ContextCompat.getColor(this,buttonValue.get(secNumId).getColorCode()),
                ContextCompat.getColor(this,buttonValue.get(factorId).getColorCode()),
                ContextCompat.getColor(this,buttonValue.get(tolaeranceId).getColorCode()));
    }


    protected void createButtonValue(){
        buttonValue = new ArrayList<>();
        buttonValue.add(new ResistorCalcBtnValue(0,0, R.color.Black));
        buttonValue.add(new ResistorCalcBtnValue(1,1, R.color.Brown));
        buttonValue.add(new ResistorCalcBtnValue(2,2, R.color.Red));
        buttonValue.add(new ResistorCalcBtnValue(3,3, R.color.Orange));
        buttonValue.add(new ResistorCalcBtnValue(4,4, R.color.Yellow));
        buttonValue.add(new ResistorCalcBtnValue(5,5, R.color.Green));
        buttonValue.add(new ResistorCalcBtnValue(6,6, R.color.Blue));
        buttonValue.add(new ResistorCalcBtnValue(7,7, R.color.Violet));
        buttonValue.add(new ResistorCalcBtnValue(8,8, R.color.Grey));
        buttonValue.add(new ResistorCalcBtnValue(9,9, R.color.White));
    }


}



