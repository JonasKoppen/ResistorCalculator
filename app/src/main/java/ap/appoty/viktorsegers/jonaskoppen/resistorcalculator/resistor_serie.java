package ap.appoty.viktorsegers.jonaskoppen.resistorcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class resistor_serie extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resistor_serie);
        Button calc = (Button)findViewById(R.id.btnCalculate);
        final TextView totalText = (TextView)findViewById(R.id.textView);
        final EditText R1Text = (EditText)findViewById(R.id.editTextR1);
        final EditText R2Text = (EditText)findViewById(R.id.editTextR2);

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
    }
}
