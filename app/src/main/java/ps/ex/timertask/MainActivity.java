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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_Thread = (TextView) findViewById(R.id.tv_Thread);
        timer = new Timer();
        handler = new Handler();

        testTimeTask();
        timer.schedule(timerTask,0,10000);//1000 = 1 วิ
    }
    private void testTimeTask(){

        timerTask = new TimerTask() {
            @Override
            public void run() {

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        Log.e("MainActivity", "Thread");
                    }
                });
            }
        };
    }
}
