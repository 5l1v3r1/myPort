package myport.sharkletvecihi.com.myport.Holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import myport.sharkletvecihi.com.myport.R;

import org.w3c.dom.Text;

public class flightholder extends RecyclerView.ViewHolder {

    public TextView airlineName;
    public TextView flightNumber;
    public TextView stad;
    public TextView destinationEn;

    public flightholder(View itemView) {
        super(itemView);

        airlineName = (TextView)itemView.findViewById(R.id.airlinetxt);
        flightNumber = (TextView)itemView.findViewById(R.id.flightnumber);
        stad = (TextView)itemView.findViewById(R.id.timetxt);
        destinationEn = (TextView)itemView.findViewById(R.id.desttxt);
    }
}
