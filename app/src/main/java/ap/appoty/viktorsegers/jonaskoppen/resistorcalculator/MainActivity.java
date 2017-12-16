package ap.appoty.viktorsegers.jonaskoppen.resistorcalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CalculatorDummyRepository calculatorDummyRepository = new CalculatorDummyRepository();
        final List<Calculator> calculatorList = calculatorDummyRepository.getCalculator();


        ListView listView = (ListView)findViewById(R.id.listView);

        listView.setAdapter(new CalculatorAdapter (this,calculatorList));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startNewClass(position);
            }
        });



    }

    public void startNewClass(int position){
        List<Calculator> tmp = CalculatorDummyRepository.getInstance().getCalculator();
        Intent detail = new Intent(MainActivity.this, tmp.get(position).getKlasse());
        startActivity(detail);
    }
}
