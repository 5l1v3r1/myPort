package myport.sharkletvecihi.com.myport.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.w3c.dom.ls.LSInput;

import myport.sharkletvecihi.com.myport.Holders.flightholder;
import myport.sharkletvecihi.com.myport.Models.rest;


import java.util.List;

import myport.sharkletvecihi.com.myport.Holders.restholder;
import myport.sharkletvecihi.com.myport.R;

public class restadapter extends RecyclerView.Adapter<restholder> {

    private Context context;
    private List<rest> rests;

    public restadapter(List<rest> rests)
    {
        this.rests = rests;
    }

    @Override
    public restholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.drawrow, parent, false);
        restholder fvh =  new restholder(itemView);
        return fvh;
    }

    @Override
    public void onBindViewHolder(restholder holder, int position) {

        rest rest = rests.get(position);
        holder.restname.setText(rest.getRestaurant());
        holder.rate.setText(rest.getRate());

    }

    @Override
    public int getItemCount() {
        return rests.size();
    }
}
