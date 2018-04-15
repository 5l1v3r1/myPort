package myport.sharkletvecihi.com.myport.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import java.util.HashMap;

import myport.sharkletvecihi.com.myport.R;

public class StartedActivity extends AppCompatActivity
{

    private CheckBox checkBox1;
    private CheckBox checkBox2;
    private CheckBox checkBox3;
    private CheckBox checkBox4;
    private CheckBox checkBox5;
    private Button buttonStart;

    private static HashMap<String, String> selected = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_started);

        checkBox1 = (CheckBox) findViewById(R.id.chkbox_1);
        checkBox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if(isChecked)
                    selected.put("Music", "Music");
                else
                    selected.remove("Music");
            }
        });

        checkBox2 = (CheckBox) findViewById(R.id.chkbox_2);
        checkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if(isChecked)
                    selected.put("Food", "Food");
                else
                    selected.remove("Food");
            }
        });

        checkBox3 = (CheckBox) findViewById(R.id.chkbox_3);
        checkBox3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if(isChecked)
                    selected.put("Movie", "Movie");
                else
                    selected.remove("Movie");
            }
        });

        checkBox4 = (CheckBox) findViewById(R.id.chkbox_4);
        checkBox4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if(isChecked)
                    selected.put("Party", "Party");
                else
                    selected.remove("Party");
            }
        });

        checkBox5 = (CheckBox) findViewById(R.id.chkbox_5);
        checkBox5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if(isChecked)
                    selected.put("Shopping", "Shopping");
                else
                    selected.remove("Shopping");
            }
        });

        buttonStart = (Button) findViewById(R.id.btn_start);
        buttonStart.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(selected.size()<3)
                    Toast.makeText(getApplicationContext(), "Plase select 3 or more.", Toast.LENGTH_LONG).show();
                else
                {
                    Intent intent = new Intent(v.getContext(), MainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    public static HashMap<String, String> getSelected()
    {
        return selected;
    }
}
