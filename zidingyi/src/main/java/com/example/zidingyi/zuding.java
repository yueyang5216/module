package com.example.zidingyi;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;

public class zuding extends LinearLayout{

    private int mA;
    private int mB;
    private int mA1;
    private int mB1;
    private Paint mPaint;

    public zuding(Context context) {
        super(context);
    }

    public zuding(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        mA = 5;
        mB = 5;
        mA1 = 200;
        mB1 = 200;

        mPaint = new Paint();

    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);

        //canvas.drawLine(mA,mB,mA1,mB1,mPaint);
        canvas.drawCircle(mA,mA1,mB,mPaint);
    }
}
