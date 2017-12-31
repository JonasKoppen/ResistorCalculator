package ap.appoty.viktorsegers.jonaskoppen.resistorcalculator;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.SurfaceView;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by jonas on 19/12/2017.
 */

public class ResistorCalcView extends View {
    private int height, width = 0;
    private int padding;
    private Paint paint;
    private boolean isInit;

    private ArrayList<Integer> kleuren;

    public ResistorCalcView(Context context) {
        super(context);
    }

    public ResistorCalcView(Context context, AttributeSet attrs){
        super(context, attrs);
    }

    public ResistorCalcView(Context context, AttributeSet attributeSet, int defStyle){
        super(context, attributeSet, defStyle);
    }


    private void init(){
        height = getHeight();
        width = getWidth();
        padding = getPaddingStart();
        paint = new Paint();
        isInit = true;
        if(kleuren == null) {
            kleuren = new ArrayList<>();
            kleuren.add(Color.RED);
            kleuren.add(Color.BLUE);
            kleuren.add(Color.GRAY);
            kleuren.add(Color.GREEN);
            kleuren.add(Color.GRAY);
        }
    }
    @Override
    protected void onDraw(Canvas canvas) {
        //super.onDraw(canvas);
        if(!isInit){
            init();
        }

        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(10);
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);

        Bitmap picture = BitmapFactory.decodeResource(getResources(), R.drawable.resistorcalc);
        canvas.drawBitmap(picture,new Rect(0,0,picture.getWidth(), picture.getHeight()), new Rect(0,0,width,height), paint);

        Rect first = new Rect((int)((float)width*0.215),(int)((float)height*0.31),(int)((float)width*0.28),(int)((float)height*0.82));
        Rect sec = new Rect((int)((float)width*0.30),(int)((float)height*0.31),(int)((float)width*0.38),(int)((float)height*0.82));
        Rect third = new Rect((int)((float)width*0.43),(int)((float)height*0.31),(int)((float)width*0.5),(int)((float)height*0.75));
        Rect factor = new Rect((int)((float)width*0.53),(int)((float)height*0.31),(int)((float)width*0.6),(int)((float)height*0.75));
        Rect tolerance = new Rect((int)((float)width*0.73),(int)((float)height*0.31),(int)((float)width*0.8),(int)((float)height*0.75));

        ArrayList<Rect> rectList = new ArrayList<>();
        rectList.add(first);
        rectList.add(sec);
        rectList.add(third);
        rectList.add(factor);
        rectList.add(tolerance);

        for(int i = 0; i < kleuren.size(); i++){
            if(kleuren.get(i) != ContextCompat.getColor(getContext(),R.color.Empty)) {
                paint.setColor(kleuren.get(i));
                paint.setAlpha(110);
                paint.setStyle(Paint.Style.FILL);
                canvas.drawRect(rectList.get(i), paint);
            }
        }

        postInvalidateDelayed(500);
        invalidate();

    }

    public void setColors(int first, int second, int third, int factor, int tolerance){
        kleuren = new ArrayList<>();
        kleuren.add(first);
        kleuren.add(second);
        kleuren.add(third);
        kleuren.add(factor);
        kleuren.add(tolerance);
    }



}

