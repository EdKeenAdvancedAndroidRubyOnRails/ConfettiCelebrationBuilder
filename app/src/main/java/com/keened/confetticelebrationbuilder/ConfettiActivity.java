package com.keened.confetticelebrationbuilder;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

import java.util.ArrayList;
import java.util.List;

public class ConfettiActivity extends Activity {
    Point pt = new Point();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new DrawView(this));
    }

    // Inner class to handle drawing to screen.
    class DrawView extends View implements View.OnTouchListener {

        List<Confetti> mConfettiList = new ArrayList<>();
        Confetti mConfetti;

        public DrawView(Context context) {
            super(context);
            this.setOnTouchListener(this);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            //set rectangle attributes
            Paint rectPaint = new Paint();
            rectPaint.setColor(Color.BLUE);
            rectPaint.setStyle(Paint.Style.FILL);
            
            //set text attributes
            Paint textPaint = new Paint();
            textPaint.setTextAlign(Paint.Align.CENTER);
            textPaint.setTextSize(40);
            textPaint.setColor(Color.BLACK);

            canvas.drawColor(Color.DKGRAY); // background color
            canvas.drawRect(30, 50, 200, 100, rectPaint);
            canvas.drawText("Clear", 115, 90, textPaint);
            canvas.drawText("Tap to add a dot",420, 90, textPaint);

            for (Confetti confetti : mConfettiList) {
                Paint paint = new Paint();
                paint.setColor(Color.WHITE); // color for the circle
                canvas.drawCircle(confetti.getmPointX(), confetti.getmPointY(), 10, paint);
            }

        }

        //@Override
        public boolean onTouch(View view, MotionEvent event) {
            // Every touch generates DOWN ... zero or more MOVEs ... UP.
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                pt.x = (int) event.getX();
                pt.y = (int) event.getY();
                mConfetti = new Confetti(pt.x, pt.y);
                mConfettiList.add(mConfetti);

                invalidate();
            }
            return true;
        }
    } // class DrawView
}
