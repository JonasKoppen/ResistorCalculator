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
    ArrayList<ResistorCalcBtnValue> colorsList;

    ListView listFirstNum;
    ListView listSecNum;
    ListView listFactor;
    ListView listTolerance;

    ResistorCalcBtnValue firstNumId;
    ResistorCalcBtnValue secNumId;
    ResistorCalcBtnValue thirdNumId;
    ResistorCalcBtnValue factorId;
    ResistorCalcBtnValue tolaeranceId;

    ResistorCalcView resistorCalcView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resistor_calc2);
        colorsList = ColorList();

        resistorCalcView = findViewById(R.id.resistorCalcView);


        txtOut = (TextView) findViewById(R.id.resistorCalcValue);
        updateText();



        listFirstNum = findViewById(R.id.firstNum);
        listFirstNum.setAdapter(new ResistorCalcAdaptor(this, CreateButtonValue()));
        listFirstNum.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                firstNumId = CreateButtonValue().get(i);
                updateText();
            }
        });

        listSecNum = findViewById(R.id.secNum);
        listSecNum.setAdapter(new ResistorCalcAdaptor(this, CreateButtonValue()));
        listSecNum.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                secNumId = CreateButtonValue().get(i);
                updateText();
            }
        });

        listFactor = findViewById(R.id.factor);
        listFactor.setAdapter(new ResistorCalcAdaptor(this, MultiplierList()));
        listFactor.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                factorId = MultiplierList().get(i);
                updateText();
            }
        });

        listTolerance = findViewById(R.id.tolerantie);
        listTolerance.setAdapter(new ResistorCalcAdaptor(this, ToleranceList()));
        listTolerance.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                tolaeranceId = ToleranceList().get(i);
                updateText();
            }
        });
    }



    public void updateText(){
        double value;
        if((factorId.getValue()) >= 0)
        {
            value = ((firstNumId.getValue() * 10) + (secNumId).getValue() ) * (Math.pow(10, (((factorId).getValue()) % 3)));
        }
        else {
            value = (((firstNumId).getValue() * 10) + (secNumId).getValue() ) * (Math.pow(10, (((factorId).getValue()))));
        }

        txtOut.setText(String.valueOf(value));
        resistorCalcView.setColors(
                ContextCompat.getColor(this,(firstNumId).getColorCode()),
                ContextCompat.getColor(this,(secNumId).getColorCode()),
                ContextCompat.getColor(this,(factorId).getColorCode()),
                ContextCompat.getColor(this,(tolaeranceId).getColorCode()));
    }


    protected ArrayList<ResistorCalcBtnValue> CreateButtonValue(){
        ArrayList<ResistorCalcBtnValue> buttonValue = new ArrayList<>();
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
        return  buttonValue;
    }

    protected ArrayList<ResistorCalcBtnValue> ColorList(){
        ArrayList<ResistorCalcBtnValue> colorList = new ArrayList<>();
        colorList.add(new ResistorCalcBtnValue(0,0, R.color.Black));
        colorList.add(new ResistorCalcBtnValue(1,1, R.color.Brown));
        colorList.add(new ResistorCalcBtnValue(2,2, R.color.Red));
        colorList.add(new ResistorCalcBtnValue(3,3, R.color.Orange));
        colorList.add(new ResistorCalcBtnValue(4,4, R.color.Yellow));
        colorList.add(new ResistorCalcBtnValue(5,5, R.color.Green));
        colorList.add(new ResistorCalcBtnValue(6,6, R.color.Blue));
        colorList.add(new ResistorCalcBtnValue(7,7, R.color.Violet));
        colorList.add(new ResistorCalcBtnValue(8,8, R.color.Grey));
        colorList.add(new ResistorCalcBtnValue(9,9, R.color.White));
        colorList.add(new ResistorCalcBtnValue(10, -1, R.color.Gold));
        colorList.add(new ResistorCalcBtnValue(11, -2, R.color.Silver));
        return  colorList;
    }

    protected ArrayList<ResistorCalcBtnValue> MultiplierList(){
        ArrayList multiplierList = new ArrayList<>();
        multiplierList.add(new ResistorCalcBtnValue(0,0, R.color.Black));
        multiplierList.add(new ResistorCalcBtnValue(1,1, R.color.Brown));
        multiplierList.add(new ResistorCalcBtnValue(2,2, R.color.Red));
        multiplierList.add(new ResistorCalcBtnValue(3,3, R.color.Orange));
        multiplierList.add(new ResistorCalcBtnValue(4,4, R.color.Yellow));
        multiplierList.add(new ResistorCalcBtnValue(5,5, R.color.Green));
        multiplierList.add(new ResistorCalcBtnValue(6,6, R.color.Blue));
        multiplierList.add(new ResistorCalcBtnValue(7,7, R.color.Violet));
        multiplierList.add(new ResistorCalcBtnValue(10, -1, R.color.Gold));
        multiplierList.add(new ResistorCalcBtnValue(11, -2, R.color.Silver));
        return multiplierList;
    }

    protected ArrayList<ResistorCalcBtnValue> ToleranceList(){
        ArrayList toleranceList = new ArrayList<>();
        toleranceList.add(new ResistorCalcBtnValue(1,1, R.color.Brown));
        toleranceList.add(new ResistorCalcBtnValue(2,2, R.color.Red));
        toleranceList.add(new ResistorCalcBtnValue(5,5, R.color.Green));
        toleranceList.add(new ResistorCalcBtnValue(6,6, R.color.Blue));
        toleranceList.add(new ResistorCalcBtnValue(7,7, R.color.Violet));
        toleranceList.add(new ResistorCalcBtnValue(8,8, R.color.Grey));
        toleranceList.add(new ResistorCalcBtnValue(10, -1, R.color.Gold));
        toleranceList.add(new ResistorCalcBtnValue(11, -2, R.color.Silver));
        return toleranceList;
    }


}



