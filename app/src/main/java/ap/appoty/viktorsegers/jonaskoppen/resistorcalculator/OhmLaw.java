package ap.appoty.viktorsegers.jonaskoppen.resistorcalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * Created by Viktor on 20-12-2017.
 */

public class OhmLaw extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ohm_law);

        RadioButton CurrentCalc = (RadioButton)findViewById(R.id.radioButtonI);
        RadioButton VoltageCalc = (RadioButton)findViewById(R.id.radioButtonV);
        RadioButton OhmCalc = (RadioButton)findViewById(R.id.radioButtonR);

        TextView WaardeI = (TextView)findViewById(R.id.textViewWaardeI);
        TextView WaardeV = (TextView)findViewById(R.id.textViewWaardeV);
        TextView WaardeR = (TextView)findViewById(R.id.textViewWaardeR);


        EditText Waarde1 = (EditText)findViewById(R.id.editTextWaarde1) ;
        EditText Waarde2 = (EditText)findViewById(R.id.editTextWaarde2) ;

        Spinner spinnerWaarde1 = (Spinner)findViewById(R.id.SpinnerWaarde1);
        Spinner spinnerWaarde2 = (Spinner)findViewById(R.id.SpinnerWaarde2);


        if (CurrentCalc.isChecked()){




        }


        else if (VoltageCalc.isChecked()){

        }


        else if (OhmCalc.isChecked()){

        }




    }
}
