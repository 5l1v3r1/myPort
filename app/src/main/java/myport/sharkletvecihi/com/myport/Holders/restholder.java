package myport.sharkletvecihi.com.myport.Holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import myport.sharkletvecihi.com.myport.R;

public class restholder extends RecyclerView.ViewHolder {

    public TextView restname;
    public TextView rate;

    public restholder(View itemView) {
        super(itemView);

        restname = (TextView)itemView.findViewById(R.id.restname);
        rate = (TextView)itemView.findViewById(R.id.ratetxt);
    }
}
