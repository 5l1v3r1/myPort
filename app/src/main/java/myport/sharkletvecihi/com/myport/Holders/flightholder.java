package myport.sharkletvecihi.com.myport.Holders;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import myport.sharkletvecihi.com.myport.Activities.MainActivity;
import myport.sharkletvecihi.com.myport.Activities.fragmentActivity;
import myport.sharkletvecihi.com.myport.R;

public class flightholder extends RecyclerView.ViewHolder {

    public TextView airlineName;
    public TextView flightNumber;
    public TextView stad;
    public TextView destinationEn;
    public TextView timetxt;
    public Button buttonSelectFly;

    public flightholder(final View itemView) {
        super(itemView);

        airlineName = (TextView)itemView.findViewById(R.id.airlinetxt);
        flightNumber = (TextView)itemView.findViewById(R.id.flightnumber);
        stad = (TextView)itemView.findViewById(R.id.timetxt);
        destinationEn = (TextView)itemView.findViewById(R.id.desttxt);
        timetxt = (TextView)itemView.findViewById(R.id.timetxt);

        buttonSelectFly = (Button) itemView.findViewById(R.id.btn_select_flying);
        buttonSelectFly.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                MainActivity.setFlyingTime(timetxt.getText().toString());
                Log.e("FLY SELECT", timetxt.getText().toString());
                if(fragmentActivity.activity != null)
                {
                    fragmentActivity.activity.finish();
                    fragmentActivity.activity = null;
                }
            }
        });
    }
}
