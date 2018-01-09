package ap.appoty.viktorsegers.jonaskoppen.resistorcalculator;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import java.util.ArrayList;

public class ResistorCalc extends Activity {

    TextView txtOut;
    ArrayList<ResistorCalcBtnValue> colorsList;

    ListView listFirstNum;
    ListView listSecNum;
    ListView listFactor;
    ListView listTolerance;

    ResistorCalcBtnValue firstNum;
    ResistorCalcBtnValue secNum;
    ResistorCalcBtnValue thirdNum;
    ResistorCalcBtnValue factor;
    ResistorCalcBtnValue tolerance;

    ResistorCalcView resistorCalcView;

    Spinner selBands;

    int selectedView;
    int activeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resistor_calc);
        firstNum = ColorList().get(12);
        secNum = ColorList().get(12);
        thirdNum = ColorList().get(12);
        factor = ColorList().get(12);
        tolerance = ColorList().get(13);

        selectedView = 0;
        setupFourStripe();
        updateText();
    }

    public void updateText(){
        double value;
        String text;

        if(activeView == 5){
            if((factor.getValue()) >= 0) //Dit is om het getal dat we tonen binnen de 4 cijfers te houden
            {
                value = ((firstNum.getValue() * 100) + (secNum).getValue() *10 + (thirdNum).getValue())  * (Math.pow(10, factor.getValue()));
            }
            else {
                value = (((firstNum).getValue() * 100) + (secNum).getValue()*10 + (thirdNum).getValue()) * (Math.pow(10, (factor).getValue()));
            }
        }
        else {
            if((factor.getValue()) >= 0) //Dit is om het getal dat we tonen binnen de 4 cijfers te houden
            {
                value = ((firstNum.getValue() * 10) + (secNum).getValue() ) * (Math.pow(10, factor.getValue()));
            }
            else {
                value = (((firstNum).getValue() * 10) + (secNum).getValue() ) * (Math.pow(10, (factor).getValue()));
            }
        }

        text= PrefixCalculator.getPrefix(value);
        value = PrefixCalculator.getWaarde(value);

        if((value%1)  != 0){ //Deze if laat enkel een komma getal tonen als er een is
            text = String.format("%.2f",value) + text;
        }
        else {
            text = String.format("%.0f",value) + text;
        }

        text += "Ω";

        txtOut.setText( text + " ±" + String.valueOf(tolerance.getValue()) + "%");

        resistorCalcView.setColors(
                ContextCompat.getColor(this,(firstNum).getColorCode()),
                ContextCompat.getColor(this,(secNum).getColorCode()),
                ContextCompat.getColor(this,(thirdNum).getColorCode()),
                ContextCompat.getColor(this,(factor).getColorCode()),
                ContextCompat.getColor(this,(tolerance).getColorCode()));
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
        colorList.add(new ResistorCalcBtnValue(12, 0, R.color.Empty));
        colorList.add(new ResistorCalcBtnValue(13, 20, R.color.Empty));
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
        toleranceList.add(new ResistorCalcBtnValue(5,0.5f, R.color.Green));
        toleranceList.add(new ResistorCalcBtnValue(6,0.25f, R.color.Blue));
        toleranceList.add(new ResistorCalcBtnValue(7,0.10f, R.color.Violet));
        toleranceList.add(new ResistorCalcBtnValue(8,0.5f, R.color.Grey));
        toleranceList.add(new ResistorCalcBtnValue(10, 5, R.color.Gold));
        toleranceList.add(new ResistorCalcBtnValue(11, 10, R.color.Silver));
        return toleranceList;
    }

    public void setupGeneral(){ //setup of things that can be done by 1 function instead of being double code in separate functions
        txtOut = findViewById(R.id.resistorCalcValue);

        colorsList = ColorList();
        resistorCalcView = findViewById(R.id.resistorCalcView);
        firstNum = colorsList.get(12);
        secNum = colorsList.get(12);
        thirdNum = colorsList.get(12);
        factor = colorsList.get(12);
        tolerance = colorsList.get(13);

        resistorCalcView.resetColors();

        selBands = (Spinner)findViewById(R.id.selBands);
        ArrayAdapter arrayAdapter = ArrayAdapter.createFromResource(this, R.array.resistBands, android.R.layout.simple_dropdown_item_1line);
        selBands.setAdapter(arrayAdapter);
        selBands.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Log.i("hi", i + "ji");
                if(i != selectedView){
                    selectedView = i;
                    switch (i){
                        case (1):
                        {
                            setupThreeStripe();
                            break;
                        }
                        case (2):
                        {
                            setupFourStripe();
                            break;
                        }
                        case (3):
                        {
                            setupFiveStripe();
                            break;
                        }
                    }
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {} //Do nothing
        });
    }

    public void setupThreeStripe() {
        setContentView(R.layout.activity_resistor_calc);

        setupGeneral();
        activeView = 3;

        listFirstNum = findViewById(R.id.firstNum);
        listFirstNum.setAdapter(new ResistorCalcAdaptor(this, CreateButtonValue()));
        listFirstNum.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                firstNum = CreateButtonValue().get(i);
                updateText();
            }
        });

        listSecNum = findViewById(R.id.secNum);
        listSecNum.setAdapter(new ResistorCalcAdaptor(this, CreateButtonValue()));
        listSecNum.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                secNum = CreateButtonValue().get(i);
                updateText();
            }
        });

        listFactor = findViewById(R.id.factor);
        listFactor.setAdapter(new ResistorCalcAdaptor(this, MultiplierList()));
        listFactor.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                factor = MultiplierList().get(i);
                updateText();
            }
        });
    }

    public void setupFourStripe() {
        setContentView(R.layout.activity_resistor_calc2);

        setupGeneral();
        activeView = 4;

        listFirstNum = findViewById(R.id.firstNum);
        listFirstNum.setAdapter(new ResistorCalcAdaptor(this, CreateButtonValue()));
        listFirstNum.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                firstNum = CreateButtonValue().get(i);
                updateText();
            }
        });

        listSecNum = findViewById(R.id.secNum);
        listSecNum.setAdapter(new ResistorCalcAdaptor(this, CreateButtonValue()));
        listSecNum.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                secNum = CreateButtonValue().get(i);
                updateText();
            }
        });

        listFactor = findViewById(R.id.factor);
        listFactor.setAdapter(new ResistorCalcAdaptor(this, MultiplierList()));
        listFactor.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                factor = MultiplierList().get(i);
                updateText();
            }
        });

        listTolerance = findViewById(R.id.tolerantie);
        listTolerance.setAdapter(new ResistorCalcAdaptor(this, ToleranceList()));
        listTolerance.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                tolerance = ToleranceList().get(i);
                updateText();
            }
        });
    }
    public void setupFiveStripe() {
        setContentView(R.layout.activity_resistor_calc3);

        setupGeneral();
        activeView = 5;

        listFirstNum = findViewById(R.id.firstNum);
        listFirstNum.setAdapter(new ResistorCalcAdaptor(this, CreateButtonValue()));
        listFirstNum.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                firstNum = CreateButtonValue().get(i);
                updateText();
            }
        });

        listSecNum = findViewById(R.id.secNum);
        listSecNum.setAdapter(new ResistorCalcAdaptor(this, CreateButtonValue()));
        listSecNum.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                secNum = CreateButtonValue().get(i);
                updateText();
            }
        });

        listSecNum = findViewById(R.id.thirdNum);
        listSecNum.setAdapter(new ResistorCalcAdaptor(this, CreateButtonValue()));
        listSecNum.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                thirdNum = CreateButtonValue().get(i);
                updateText();
            }
        });

        listFactor = findViewById(R.id.factor);
        listFactor.setAdapter(new ResistorCalcAdaptor(this, MultiplierList()));
        listFactor.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                factor = MultiplierList().get(i);
                updateText();
            }
        });

        listTolerance = findViewById(R.id.tolerantie);
        listTolerance.setAdapter(new ResistorCalcAdaptor(this, ToleranceList()));
        listTolerance.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                tolerance = ToleranceList().get(i);
                updateText();
            }
        });
    }
}



