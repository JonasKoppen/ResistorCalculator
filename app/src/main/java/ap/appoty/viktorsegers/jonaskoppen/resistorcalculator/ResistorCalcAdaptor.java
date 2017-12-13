package ap.appoty.viktorsegers.jonaskoppen.resistorcalculator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;

import java.util.ArrayList;

/**
 * Created by jonas on 13/12/2017.
 */

public class ResistorCalcAdaptor extends ArrayAdapter<ResistorCalcBtnValue> {
    public ResistorCalcAdaptor(Context context, ArrayList values){
        super(context, -1, values);
    }

    public View getView(int position,
                        View convertView,
                        ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.resistor_calc_list, null, false);
        Button b = (Button) itemView.findViewById(R.id.btn);
        b.setBackgroundColor(getItem(position).getColorCode());
        return  itemView;
    }
}
