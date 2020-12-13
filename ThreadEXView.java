package com.example.elevatorthread;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

public class ThreadEXView extends View {
    public int floor = 0;

    private Rect mRect;

    public ThreadEXView (Context context) {
        super(context);

        //엘리베이터 움직이는 스레드 생성 및 동작
        ElevatorMove mThread = new ElevatorMove(this);
        mThread.start();

        mRect = new Rect(60,10,180,50);
    }

    @Override
    protected void onDraw(Canvas canvas){
        canvas.drawBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.elevator_img),
                50, 500-(floor*80), null);

        Paint mRP = new Paint();
        mRP.setColor(Color.BLACK);
        canvas.drawRect(mRect, mRP);

        Paint mFloor = new Paint();
        mFloor.setTextSize(30);
        mFloor.setColor(Color.RED);
        canvas.drawText(String.valueOf(floor+1), 115, 40, mFloor);

    }

    /*@Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                break;
        }

        return true;
    }*/
}
