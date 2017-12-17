package ap.appoty.viktorsegers.jonaskoppen.resistorcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class resistor_parallel extends AppCompatActivity {

    TextView totalText;
    EditText R1Text;
    EditText R2Text;
    String prefix;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resistor_parallel);
        Button calc = (Button)findViewById(R.id.btnCalculate);
        totalText = (TextView)findViewById(R.id.textView);
        R1Text = (EditText)findViewById(R.id.editTextR1);
        R2Text = (EditText)findViewById(R.id.editTextR2);

    }
    public void bereken(View v){
        String R1string = R1Text.getText().toString();
        String R2string = R2Text.getText().toString();
        double R1 = Double.parseDouble(R1string);
        double R2 = Double.parseDouble(R2string);
        double Rtotal = prefixCalculator((R1*R2)/(R1+R2));
        String RtotalString = String.valueOf(Rtotal);
        totalText.setText(RtotalString + "\tΩ");
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
