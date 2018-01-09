package ap.appoty.viktorsegers.jonaskoppen.resistorcalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Viktor on 20-12-2017.
 */

public class OhmLaw extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ohm_law);

        final RadioButton CurrentCalc = (RadioButton) findViewById(R.id.radioButtonI);
        final RadioButton VoltageCalc = (RadioButton) findViewById(R.id.radioButtonV);
        final RadioButton OhmCalc = (RadioButton) findViewById(R.id.radioButtonR);

        final Button StartCalculate = (Button) findViewById(R.id.btnCalculate);

        final TextView WaardeI = (TextView) findViewById(R.id.textViewWaardeI);
        final TextView WaardeV = (TextView) findViewById(R.id.textViewWaardeV);
        final TextView WaardeR = (TextView) findViewById(R.id.textViewWaardeR);


        final EditText Waarde1 = (EditText) findViewById(R.id.editTextWaarde1);
        final EditText Waarde2 = (EditText) findViewById(R.id.editTextWaarde2);






        final Spinner spinnerWaarde1 = (Spinner) findViewById(R.id.SpinnerWaarde1);
        final Spinner spinnerWaarde2 = (Spinner) findViewById(R.id.SpinnerWaarde2);

        final ArrayAdapter arrayAdapterOhm = ArrayAdapter.createFromResource(this, R.array.prefixOhm, android.R.layout.simple_spinner_item);
        final ArrayAdapter arrayAdapterCurrent = ArrayAdapter.createFromResource(this, R.array.prefixCurrent, android.R.layout.simple_spinner_item);
        final ArrayAdapter arrayAdapterVoltage = ArrayAdapter.createFromResource(this, R.array.prefixVoltage, android.R.layout.simple_spinner_item);

        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radiogroup);
        radioGroup.clearCheck();


        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, final int checkedId) {


                if (checkedId == R.id.radioButtonI) {
                    spinnerWaarde1.setAdapter(arrayAdapterOhm);
                    spinnerWaarde2.setAdapter(arrayAdapterVoltage);
                    spinnerWaarde2.setSelection(3);

                } else if (checkedId == R.id.radioButtonV) {
                    spinnerWaarde1.setAdapter(arrayAdapterOhm);
                    spinnerWaarde2.setAdapter(arrayAdapterCurrent);
                    spinnerWaarde2.setSelection(3);


                } else {
                    spinnerWaarde1.setAdapter(arrayAdapterCurrent);
                    spinnerWaarde2.setAdapter(arrayAdapterVoltage);
                    spinnerWaarde1.setSelection(3);
                    spinnerWaarde2.setSelection(3);

                }
            }
        });

        StartCalculate.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                String stringX = Waarde1.getText().toString();
                String stringY = Waarde2.getText().toString();
                double WaardeX = Double.parseDouble(stringX);
                double WaardeY = Double.parseDouble(stringY);

                PrefixCalculator calculator = new PrefixCalculator();
                String prefix;
                double Rtotal;
                double result = 0;

                    //weerstand
                    if (spinnerWaarde1.getAdapter() == arrayAdapterCurrent && spinnerWaarde2.getAdapter() == arrayAdapterVoltage) {
                        result = (WaardeY * SpinnerWaarde(spinnerWaarde2)) / (WaardeX * SpinnerWaarde(spinnerWaarde1));
                        Rtotal = Math.round((result) * 1000d) / 1000d;
                        prefix = calculator.getPrefix(((SpinnerWaarde(spinnerWaarde1) * SpinnerWaarde(spinnerWaarde2)) / (SpinnerWaarde(spinnerWaarde1) + SpinnerWaarde(spinnerWaarde2)))*100);

                        WaardeI.setText(stringX + calculator.getPrefix(SpinnerWaarde(spinnerWaarde1)) + "A");
                        WaardeR.setText(Double.toString(Rtotal) + prefix + "Ω");
                        WaardeV.setText(stringY + calculator.getPrefix(SpinnerWaarde(spinnerWaarde2)) + "V");

                    }

                    //Voltage
                    else if (spinnerWaarde1.getAdapter() == arrayAdapterOhm && spinnerWaarde2.getAdapter() == arrayAdapterCurrent) {
                        result = (WaardeY * SpinnerWaarde(spinnerWaarde2)) * (WaardeX * SpinnerWaardeOhm(spinnerWaarde1));
                        Rtotal = Math.round((result) * 1000d) / 1000d;
                        prefix = calculator.getPrefix(((SpinnerWaardeOhm(spinnerWaarde1) * SpinnerWaarde(spinnerWaarde2)) / (SpinnerWaardeOhm(spinnerWaarde1) + SpinnerWaarde(spinnerWaarde2)))*100);

                        WaardeI.setText(stringY + calculator.getPrefix(SpinnerWaarde(spinnerWaarde2)) + "A");
                        WaardeV.setText(Double.toString(Rtotal) + prefix + "V");
                        WaardeR.setText(stringX + calculator.getPrefix(SpinnerWaardeOhm(spinnerWaarde1)) + "Ω");


                    }
                    //Current
                    else {
                        result = (WaardeY * SpinnerWaarde(spinnerWaarde2)) / (WaardeX * SpinnerWaardeOhm(spinnerWaarde1));
                        Rtotal = Math.round((result) * 1000d) / 1000d;
                        prefix = calculator.getPrefix(((SpinnerWaardeOhm(spinnerWaarde1) * SpinnerWaarde(spinnerWaarde2)) / (SpinnerWaardeOhm(spinnerWaarde1) + SpinnerWaarde(spinnerWaarde2)))*100);


                        WaardeI.setText(Double.toString(Rtotal) + prefix + "A");
                        WaardeR.setText(stringX + calculator.getPrefix(SpinnerWaardeOhm(spinnerWaarde1)) + "Ω");
                        WaardeV.setText(stringY + calculator.getPrefix(SpinnerWaarde(spinnerWaarde2)) + "V");

                    }
                    Log.e("test", Double.toString(SpinnerWaardeOhm((spinnerWaarde1))));

                    Log.e("test", Double.toString(WaardeY));
                }
                 catch (NumberFormatException e){
                        Toast.makeText((getApplicationContext()), "give a valid value", Toast.LENGTH_LONG).show();
                    }

                }
        });


    }

    double SpinnerWaardeOhm(Spinner SpinnerWaarde) {
        Spinner spinner = SpinnerWaarde;
        double multiplier = 1;

        switch (spinner.getSelectedItemPosition()) {
            case 0:
                multiplier = 1;
                break;
            case 1:
                multiplier = Math.pow(10, 3);
                break;
            case 2:
                multiplier = Math.pow(10, 6);
                break;
            case 3:
                multiplier = Math.pow(10, 9);
                break;
        }

        return multiplier;
    }

    double SpinnerWaarde(Spinner SpinnerWaarde) {
        Spinner spinner = SpinnerWaarde;
        double multiplier = 3;

        switch (spinner.getSelectedItemPosition())
        {
            case 0:
                multiplier = Math.pow(10,-9);
                break;

            case 1:
                multiplier = Math.pow(10,-6);
                break;

            case 2:
                multiplier = Math.pow(10,-3);
                break;

            case 3:
                multiplier = 1;
                break;

            case 4:
                multiplier = Math.pow(10,3);
                break;

            case 5:
                multiplier = Math.pow(10,6);
                break;

            case 6:
                multiplier = Math.pow(10,9);
                break;
        }


        return multiplier;
    }
}


