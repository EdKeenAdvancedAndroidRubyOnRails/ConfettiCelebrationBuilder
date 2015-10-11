package com.keened.confetticelebrationbuilder;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Toast;

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
            canvas.drawText("Tap to add a dot", 420, 90, textPaint);

            Paint paint = new Paint();


            for (Confetti confetti : mConfettiList) {
                canvas.drawCircle(confetti.getmPointX(), confetti.getmPointY(), 10, paint);
                paint.setColor(confetti.getmColor()); // color for the circle
            }

        }

        //@Override
        public boolean onTouch(View view, MotionEvent event) {
            // Every touch generates DOWN ... zero or more MOVEs ... UP.
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                pt.x = (int) event.getX();
                pt.y = (int) event.getY();

                // touch inside the Clear button
                if (pt.x > 29 && pt.x < 201 && pt.y > 50 && pt.y < 101) {
                    recreate();
                }

                mConfetti = new Confetti(pt.x, pt.y);
                mConfetti.setColor();
                mConfettiList.add(mConfetti);

                invalidate();
            }
            return true;
        }
    } // class DrawView
}
