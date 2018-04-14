package myport.sharkletvecihi.com.myport.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import myport.sharkletvecihi.com.myport.Holders.flightholder;
import myport.sharkletvecihi.com.myport.Models.flight;
import myport.sharkletvecihi.com.myport.R;

public class flightadapter extends RecyclerView.Adapter<flightholder> {


    private Context context;
    private List<flight> flights;

    public flightadapter(List<flight> flights){
        this.flights = flights;
    }

    @Override
    public flightholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.flightrow, parent, false);
        flightholder fvh =  new flightholder(itemView);
        return fvh;
    }

    @Override
    public void onBindViewHolder(flightholder holder, int position) {
        flight flight = flights.get(position);
        holder.airlineName.setText(flight.getAirlineName());
        holder.destinationEn.setText(flight.getDestinationEn());
        holder.stad.setText(flight.getStad());
        holder.flightNumber.setText(flight.getFlightNumber());
    }

    @Override
    public int getItemCount() {
        return flights.size();
    }
}
