package ap.appoty.viktorsegers.jonaskoppen.resistorcalculator;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.lang.reflect.Array;
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resistor_calc);
        createButtonValue();
        firstNum = 1;
        secNum = 0;
        factor = 0;
        tolaerance = 0;

        txtOut = (TextView) findViewById(R.id.resistorCalcValue);
        updateText();
        draw();

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

    public void draw(){
        Resources res = getResources();
        ResistorCalcView view = (ResistorCalcView) this.findViewById(R.id.resistorCalcView);

    }

    public void updateText(){
        double value = ((firstNum * 10) + secNum ) * (Math.pow(10, ((factor) % 3)));
        txtOut.setText(String.valueOf(value));
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



