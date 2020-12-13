package com.example.elevatorthread;

public class ElevatorMove extends Thread {
    public ThreadEXView mView;

    private boolean running = true;

    public ElevatorMove(ThreadEXView view) {
        mView = view;
    }

    public void run() {

        while(true) {
            for (int i = 0; i<4;i++) {
                //올라가기
                mView.floor = i;
                mView.invalidate();//화면 갱신
                //0.5초 대기
                try{
                    Thread.sleep(500);
                }catch (InterruptedException e){
                }
            }

            for (int i = 4; i>0;i--) {
                //내려가기
                mView.floor = i;
                mView.invalidate();//화면 갱신
                //0.5초 대기
                try{
                    Thread.sleep(500);
                }catch (InterruptedException e){
                }
            }
        }

    }




    //실패
    /*@Override
    public boolean onTouchEvent(MotionEvent event) {
        //return super.onTouchEvent(event);

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if(running == true)
                    return running;
                else
                    running = false;

        }

        final Handler handler = new Handler();
        handler.post(new Runnable() {
            while(true)

            {
                if (running == true) {
                    for (int i = 0; i < 4; i++) {
                        //올라가기
                        mView.floor = i;
                        mView.invalidate();//화면 갱신
                        //0.5초 대기
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                        }
                    }

                    for (int i = 4; i > 0; i--) {
                        //내려가기
                        mView.floor = i;
                        mView.invalidate();//화면 갱신
                        //0.5초 대기
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                        }
                    }
                    if(running) {
                    run();
                }
                handler.postDelayed(this, 100);
                }
            }
        });

    }*/

    }
