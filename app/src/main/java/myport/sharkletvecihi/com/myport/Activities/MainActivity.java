package myport.sharkletvecihi.com.myport.Activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import myport.sharkletvecihi.com.myport.R;

public class MainActivity extends AppCompatActivity {

    private Button addbtn;
    private Button buttonProcess;
    private TextView textViewStatus2;
    private Handler handler = new Handler();
    private Runnable runnable;
    private ProgressBar progressBar;
    private TextView textViewStatus1;

    private static String flyingTime = null;
    private Button eatBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addbtn = (Button)findViewById(R.id.addbtn);
        eatBtn = (Button)findViewById(R.id.eatbtn);

        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(v.getContext(), fragmentActivity.class);
                startActivity(intent);

            }
        });

        eatBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), toEat.class);
                startActivity(intent);
            }
        });

        buttonProcess = (Button) findViewById(R.id.btn_process);
        buttonProcess.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(v.getContext(), AirPortOpProcess.class);
                startActivity(intent);
            }
        });

        textViewStatus2 = (TextView) findViewById(R.id.text_status_2);

        runnable = new Runnable()
        {
            @Override
            public void run()
            {
                if(flyingTime != null)
                {
                    DateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm");
                    try
                    {
                        Date dateFly = format.parse(flyingTime);
                        Date date = new Date();
                        String when = "Remaing: ";
                        format.format(date);

                        long ms = dateFly.getTime() - date.getTime();

                        long min = ms/ (1000*60) %60;
                        long h = ms / (1000*60*60) % 24;
                        long day = ms / (24*60*60*1000);

                        when += String.valueOf(day) + " day ";
                        when += String.valueOf(h) + " hour ";
                        when += String.valueOf(min) + " minute ";

                        textViewStatus2.setText(when);
                        Log.e("ONRESUME", dateFly.toString());
                        Log.e("ONRESUME", date.toString());
                        handler.postDelayed(this, 1000*60);

                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        };

        progressBar = (ProgressBar) findViewById(R.id.pb_status_1);
        textViewStatus1 = (TextView) findViewById(R.id.text_status_1);

    }

    @Override
    protected void onResume()
    {
        super.onResume();
        handler.postDelayed(runnable, 1000);

        SharedPreferences preferences = getSharedPreferences("ProccessSettings", Context.MODE_PRIVATE);
        int complete = preferences.getInt("count_step", 0);
        String next_operation = preferences.getString("next_step_name", "Travel to Airpott");

        progressBar.setProgress(complete);
        textViewStatus1.setText("Next Airport Operation: " + next_operation);
    }

    public static void setFlyingTime(String flyingTime)
    {
        MainActivity.flyingTime = flyingTime;
    }
}
