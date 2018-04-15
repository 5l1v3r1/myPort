package myport.sharkletvecihi.com.myport.Activities;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import myport.sharkletvecihi.com.myport.Fragments.quest2;
import myport.sharkletvecihi.com.myport.R;
import myport.sharkletvecihi.com.myport.Fragments.quest1;

public class IntroActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        final quest2 newfrag = new quest2();

        final FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

        fragmentTransaction.replace(R.id.rect1, quest1.newInstance()).commit();

    }
}
