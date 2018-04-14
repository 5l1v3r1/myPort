package myport.sharkletvecihi.com.myport;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //aksldajksdlkajsdlakjdklajd

        Intent intent = new Intent(this, MainBottomActivity.class);
        startActivity(intent);
    }
}
