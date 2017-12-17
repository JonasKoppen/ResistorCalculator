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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resistor_parallel);
        Button calc = (Button)findViewById(R.id.btnCalculate);
        totalText = (TextView)findViewById(R.id.textView);
        R1Text = (EditText)findViewById(R.id.editTextR1);
        R2Text = (EditText)findViewById(R.id.editTextR2);



        /*
        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String R1string = R1Text.getText().toString();
                String R2string = R2Text.getText().toString();
                int R1 = Integer.parseInt(R1string);
                int R2 = Integer.parseInt(R2string);
                int Rtotal = R1 + R2;
                totalText.setText(Rtotal);
            }
        });
        */
    }
    public void bereken(View v){
        String R1string = R1Text.getText().toString();
        String R2string = R2Text.getText().toString();
        int R1 = Integer.parseInt(R1string);
        int R2 = Integer.parseInt(R2string);
        int Rtotal = R1 + R2;
        String RtotalString = String.valueOf(Rtotal);
        totalText.setText(RtotalString + "\tΩ");
    }
}
