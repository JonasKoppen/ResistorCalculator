package ap.appoty.viktorsegers.jonaskoppen.resistorcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class resistor_parallel extends AppCompatActivity {

    TextView totalText;
    EditText R1Text;
    EditText R2Text;

    Spinner R1Spinner;
    Spinner R2Spinner;

    String prefix;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resistor_parallel);
        Button calc = (Button)findViewById(R.id.btnCalculate);
        totalText = (TextView)findViewById(R.id.textView);
        R1Text = (EditText)findViewById(R.id.editTextR1);
        R2Text = (EditText)findViewById(R.id.editTextR2);

        R1Spinner = (Spinner)findViewById(R.id.planets_spinnerR1);
        R2Spinner = (Spinner) findViewById(R.id.planets_spinnerR2);

        ArrayAdapter arrayAdapter = ArrayAdapter.createFromResource(this, R.array.prefixOhm, android.R.layout.simple_spinner_item);

        R1Spinner.setAdapter(arrayAdapter);
        R2Spinner.setAdapter(arrayAdapter);

    }
    public void bereken(View v){
        double R1multiplier = 1;
        switch (R1Spinner.getSelectedItemPosition()){
            case 0:
                R1multiplier = 1;
                break;
            case 1 :
                R1multiplier = Math.pow(10,3);
                break;
            case 2 :
                R1multiplier = Math.pow(10,6);
                break;
            case 3 :
                R1multiplier = Math.pow(10,9);
                break;
        }

        double R2multiplier = 1;
        switch (R2Spinner.getSelectedItemPosition()){
            case 0:
                R2multiplier = 1;
                break;
            case 1 :
                R2multiplier = Math.pow(10,3);
                break;
            case 2 :
                R2multiplier = Math.pow(10,6);
                break;
            case 3 :
                R2multiplier = Math.pow(10,9);
                break;
        }
        String R1string = R1Text.getText().toString();
        String R2string = R2Text.getText().toString();

        try{
            double R1 = Double.parseDouble(R1string) * R1multiplier;
            double R2 = Double.parseDouble(R2string) * R2multiplier;
            double Rtotal = prefixCalculator(((R1*R2)/(R1+R2)));
            String RtotalString = String.valueOf(Rtotal);
            totalText.setText(RtotalString + prefix);
        }
        catch (NumberFormatException e){
            Toast.makeText(this, "give a valid value", Toast.LENGTH_LONG).show();
        }

    }

    private Double prefixCalculator(Double getal){
        if(getal % Math.pow(10, 8) == 0){
            prefix = "GΩ";
            return (getal/Math.pow(10,9));
        }
        else if(getal % Math.pow(10, 5) == 0){
            prefix = "MΩ";
            return (getal/Math.pow(10,6));
        }
        else if(getal % Math.pow(10, 2) == 0){
            prefix = "KΩ";
            return (getal/Math.pow(10,3));
        }
        else if(getal % 1 == 0){
            prefix = "Ω";
            return getal;
        }
        else if(getal % Math.pow(10, -4) == 0){
            prefix = "mΩ";
            return (getal/Math.pow(10,-3));
        }
        else if(getal % Math.pow(10, -7) == 0){
            prefix = "µΩ";
            return (getal/Math.pow(10,-6));
        }
        else{
            prefix = "nΩ";
            return (getal/Math.pow(10,-9));
        }
    }
}
