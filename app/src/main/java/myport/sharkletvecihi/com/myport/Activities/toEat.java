package myport.sharkletvecihi.com.myport.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import myport.sharkletvecihi.com.myport.Adapters.restadapter;
import myport.sharkletvecihi.com.myport.Fragments.addflight;
import myport.sharkletvecihi.com.myport.Models.rest;
import myport.sharkletvecihi.com.myport.R;

public class toEat extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<rest> rests = new ArrayList<>();
    private restadapter adapter = new restadapter(rests);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_eat);

        recyclerView = (RecyclerView)findViewById(R.id.dolist);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);


        JsonObjectRequest jsonRequest = new JsonObjectRequest
                (Request.Method.GET, "http://35.159.15.121:8080/foodAndBeverage/restaurantList?language=tr&location=ist", null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        // the response is already constructed as a JSONObject!
                        try {
                            for (int i = 0; i < response.getJSONArray("results").length(); i++) {
                                try {

                                    JSONObject obj = response.getJSONArray("results").getJSONObject(i);
                                    rest rest = new rest();
                                    rest.setRate(obj.getString("rate"));
                                    rest.setRestaurant(obj.getString("title"));
                                    rests.add(rest);
                                    adapter.notifyDataSetChanged();
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }

                            }
                            addflight.newInstance().adapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                    }
                });

        Volley.newRequestQueue(this).add(jsonRequest);
    }
}
