package myport.sharkletvecihi.com.myport.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import myport.sharkletvecihi.com.myport.R;

public class MainActivity extends AppCompatActivity {

    private Button addbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addbtn = (Button)findViewById(R.id.addbtn);

        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(v.getContext(), fragmentActivity.class);
                startActivity(intent);

            }
        });

    }
}
