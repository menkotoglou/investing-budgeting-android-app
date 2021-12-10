package com.example.exercisemenelaoskotoglou;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class MyService extends Service {

    private Timer timer = new Timer();
    private static int count;
    InvestActivity ma = new InvestActivity();


    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public int onStartCommand(Intent in, int flag, int startId) {
        count = 0;
        Toast.makeText(getApplicationContext(), "Let's set up your investment plan", Toast.LENGTH_SHORT).show();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                count++;
                System.out.println("Call " + count);

                if (count == 8) {
                    ma.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(), "Are you thinking what to include in your portfolio?", Toast.LENGTH_LONG).show();
                        }
                    });
                }

                if (count == 15) {
                    System.out.println("Still there");
                    ma.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(), "Great work. You take your investments seriously", Toast.LENGTH_LONG).show();
                        }
                    });
                }
            }
        }, 0, 1000);
        return super.onStartCommand(in, flag, startId);
    }

    public void onDestroy() {
        if(timer != null) {
            timer.cancel();
            Toast.makeText(getApplicationContext(), "Great investment plan", Toast.LENGTH_LONG).show();
        }
        super.onDestroy();
    }
    public int getCounter() {
        return count;
    }
}