package myport.sharkletvecihi.com.myport.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.HashMap;

import myport.sharkletvecihi.com.myport.R;
import myport.sharkletvecihi.com.myport.View.CardViewProcess;

public class AirPortOpProcess extends AppCompatActivity
{

    private ArrayList<CardViewProcess> listProcessView;
    private LinearLayout linearLayoutListProcess;
    private HashMap<Integer, String> listProcess;
    private HashMap<Integer, Class> listProcessActivity;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_air_port_op_process);

        linearLayoutListProcess = (LinearLayout) findViewById(R.id.linlayout_list_process);
        listProcessView = new ArrayList<>();
        listProcess = new HashMap<>();
        listProcessActivity = new HashMap<>();

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
        }

        for(int i=0; i<listProcess.size(); i++)
        {
            if(i != listProcess.size()-1)
                listProcessView.get(0).setNextView(listProcessView.get(i+1));
        }
    }
}
