package ap.appoty.viktorsegers.jonaskoppen.resistorcalculator;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by jonas on 16/12/2017.
 */

public class ResistorCalcAdaptor extends ArrayAdapter<ResistorCalcBtnValue> {
    public ResistorCalcAdaptor(Context context, ArrayList values) {
        super(context,-1, values);
    }

    public View getView(int position,
                        View convertView,
                        ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.resistor_calc_list, null, false);
        ((TextView)itemView.findViewById(R.id.btnCalcItem)).setBackgroundColor(ContextCompat.getColor(getContext(), getItem(position).getColorCode()));
        ((TextView)itemView.findViewById(R.id.btnCalcItem)).setText( String.valueOf(getItem(position).getValue()));
        return itemView;
    }
}
