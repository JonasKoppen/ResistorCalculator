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

    int firstNum;
    int secNum;
    int factor;
    int tolaerance;

    private Bitmap bitmap;
    private float x;
    private float y;

    ResistorCalcView resistorCalcView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resistor_calc);
        createButtonValue();

        resistorCalcView = findViewById(R.id.resistorCalcView);

        firstNum = 1;
        secNum = 0;
        factor = 0;
        tolaerance = 0;

        txtOut = (TextView) findViewById(R.id.resistorCalcValue);
        updateText();



        listFirstNum = findViewById(R.id.firstNum);
        listFirstNum.setAdapter(new ResistorCalcAdaptor(this, buttonValue));
        listFirstNum.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.i("First", String.valueOf(buttonValue.get(i).getValue()));
                firstNum = buttonValue.get(i).getValue();
                updateText();
            }
        });

        listSecNum = findViewById(R.id.secNum);
        listSecNum.setAdapter(new ResistorCalcAdaptor(this, buttonValue));
        listSecNum.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.i("Second", String.valueOf(buttonValue.get(i).getValue()));
                secNum = buttonValue.get(i).getValue();
                updateText();
            }
        });

        listFactor = findViewById(R.id.factor);
        listFactor.setAdapter(new ResistorCalcAdaptor(this, buttonValue));
        listFactor.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.i("Factor", String.valueOf(buttonValue.get(i).getValue()));
                factor = buttonValue.get(i).getValue();
                updateText();
            }
        });

        listTolerance = findViewById(R.id.tolerantie);
        listTolerance.setAdapter(new ResistorCalcAdaptor(this, buttonValue));
        listTolerance.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.i("Tolerantie", String.valueOf(buttonValue.get(i).getValue()));
                tolaerance = buttonValue.get(i).getValue();
                updateText();
            }
        });
    }



    public void updateText(){
        double value = ((firstNum * 10) + secNum ) * (Math.pow(10, ((factor) % 3)));
        txtOut.setText(String.valueOf(value));
        resistorCalcView.setColors(
                ContextCompat.getColor(this, buttonValue.get(firstNum).getColorCode()),
                ContextCompat.getColor(this,buttonValue.get(secNum).getColorCode()),
                ContextCompat.getColor(this,buttonValue.get(factor).getColorCode()),
                ContextCompat.getColor(this,buttonValue.get(0).getColorCode()));
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



