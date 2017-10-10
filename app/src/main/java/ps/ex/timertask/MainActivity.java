package ps.ex.timertask;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private Timer timer;
    private TimerTask timerTask;
    private Handler handler;
    private TextView tv_Thread;
    private int i =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_Thread = (TextView) findViewById(R.id.tv_Thread);
        timer = new Timer();
        handler = new Handler();
    }

    @Override
    protected void onResume() {
        super.onResume();
        startTimeTask();
    }

    private void startTimeTask(){
        stopTimeTask();

        timerTask = new TimerTask() {
            @Override
            public void run() {

                i = i+1;
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        tv_Thread.setText("MainActivity_Thread : "+i);
                        Log.e("MainActivity", "Thread");
                    }
                });
            }
        };

        timer.schedule(timerTask,0,1000*10);//TaskTime,waitStart,Countdown -- 1000 = 1 วินาที
    }

    private void stopTimeTask(){
        if (timerTask !=null){
            timerTask.cancel();
            timerTask = null;
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        stopTimeTask();
    }
}
