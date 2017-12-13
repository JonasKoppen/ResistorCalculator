package ap.appoty.viktorsegers.jonaskoppen.resistorcalculator;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

/**
 * Created by jonas on 13/12/2017.
 */

public class ResistorCalcAdaptor extends ArrayAdapter<ResistorCalcBtnValue> {
    public ResistorCalcAdaptor(Context context, ArrayList values){
        super(context, -1, values);
    }

}
