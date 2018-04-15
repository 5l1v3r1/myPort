package myport.sharkletvecihi.com.myport.Activities;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import myport.sharkletvecihi.com.myport.R;
import myport.sharkletvecihi.com.myport.View.CardViewProcess;

public class AirPortOpProcess extends AppCompatActivity
{

    private ArrayList<CardViewProcess> listProcessView;
    private LinearLayout linearLayoutListProcess;
    private HashMap<Integer, String> listProcess;
    private HashMap<Integer, Class> listProcessActivity;

    private static final String[] REQUIRED_PERMISSION_LIST = new String[]{
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.ACCESS_FINE_LOCATION
    };
    private List<String> missingPermission = new ArrayList<>();
    private static final int REQUEST_PERMISSION_CODE = 12345;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_air_port_op_process);

        linearLayoutListProcess = (LinearLayout) findViewById(R.id.linlayout_list_process);
        listProcessView = new ArrayList<>();
        listProcess = new HashMap<>();
        listProcessActivity = new HashMap<>();
        createProcess();

    }

    private void createProcess()
    {
        listProcess.put(0, "Travel to Airport");
        listProcessActivity.put(0, null);

        listProcess.put(1, "Check in");
        listProcessActivity.put(1, null);

        listProcess.put(2, "Boarding P. Validation");
        listProcessActivity.put(2, null);

        listProcess.put(3, "Security");
        listProcessActivity.put(3, null);

        listProcess.put(4, "Duty Free");
        listProcessActivity.put(4, null);

        listProcess.put(5, "Lounge");
        listProcessActivity.put(5, null);

        listProcess.put(6, "Boarding");
        listProcessActivity.put(6, null);

        listProcess.put(7, "Gate Closed");
        listProcessActivity.put(7, null);

        listProcess.put(8, "Park Off");
        listProcessActivity.put(8, null);

        listProcess.put(9, "Taxi");
        listProcessActivity.put(9, null);

        listProcess.put(10, "Take Off");
        listProcessActivity.put(10, null);

        for(int i=0; i<listProcess.size(); i++)
        {
            CardViewProcess process = new CardViewProcess(getApplicationContext());
            process.setText(listProcess.get(i));
            listProcessView.add(process);
            linearLayoutListProcess.addView(listProcessView.get(i));
        }


        for(int i=0; i<linearLayoutListProcess.getChildCount(); i++)
        {
            if(i==0)
            {
                ((CardViewProcess) linearLayoutListProcess.getChildAt(i)).getCheckBoxProcess().setEnabled(true);
                ((CardViewProcess) linearLayoutListProcess.getChildAt(i)).getButtonExpand().setEnabled(true);
            }

            if(i != linearLayoutListProcess.getChildCount()-1)
                ((CardViewProcess) linearLayoutListProcess.getChildAt(i)).setNextView( ((CardViewProcess)linearLayoutListProcess.getChildAt(i+1) ) );
        }


        for(int i=0; i<MainActivity.count_step; i++)
        {
            if(((CardViewProcess) linearLayoutListProcess.getChildAt(i)) != null)
            {
                CardViewProcess.out = true;
                ((CardViewProcess) linearLayoutListProcess.getChildAt(i)).setChecked(true);
            }
        }
    }
}
