package ap.appoty.viktorsegers.jonaskoppen.resistorcalculator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceView;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by jonas on 19/12/2017.
 */

public class ResistorCalcView extends View {
    private int height, width = 0;
    private int padding;
    private Paint paint;
    private boolean isInit;

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
    }
    @Override
    protected void onDraw(Canvas canvas) {
        //super.onDraw(canvas);
        if(!isInit){
            init();
        }
        canvas.drawColor(Color.WHITE);
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(10);
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
        canvas.drawCircle(0, 5, 2,paint);
        canvas.drawLine(0,0,width,height,paint);

        postInvalidateDelayed(500);
        invalidate();

        //Paint paint = new Paint();
        //canvas.drawCircle(10,10,5, paint);
    }



}

