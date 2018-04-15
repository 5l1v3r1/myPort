package myport.sharkletvecihi.com.myport.Activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.util.Log;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import myport.sharkletvecihi.com.myport.Adapters.flightadapter;
import myport.sharkletvecihi.com.myport.Models.flight;
import myport.sharkletvecihi.com.myport.Fragments.addflight;

import org.json.JSONException;
import org.json.JSONObject;


import java.util.ArrayList;
import java.util.List;

import myport.sharkletvecihi.com.myport.R;

public class fragmentActivity extends AppCompatActivity {

    addflight aflight = new addflight();
    private RecyclerView recyclerView;
    public List<flight> flights = new ArrayList<>();
    public flightadapter adapter;
    public static fragmentActivity activity = null;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        String url = "http://35.159.15.121:8080/flightInformation/getList?code=IST&flightType=DOM&flightLeg=DEP&minStad=15%2F4%2F2018%2000%3A00&maxStad=16%2F4%2F2018%2000%3A00";

        activity = this;

        recyclerView = (RecyclerView)findViewById(R.id.flightrecycler);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 1);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        JsonObjectRequest jsonRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        // the response is already constructed as a JSONObject!
                        try {
                            Log.v("response", response.getString("flights"));
                            for (int i = 0; i < response.getJSONArray("flights").length(); i++) {
                                try {

                                    JSONObject obj = response.getJSONArray("flights").getJSONObject(i);
                                    flight flight1 = new flight();
                                    flight1.setAirlineIata(obj.getString("airlineIata"));
                                    flight1.setAirlineName(obj.getString("airlineName"));
                                    flight1.setDestinationEn(obj.getJSONObject("path").getJSONObject("destination").getString("destinationEn"));
                                    flight1.setFlightNumber(obj.getString("flightNumber"));
                                    flight1.setStad(obj.getString("stad"));
<<<<<<< HEAD
                                    addflight.newInstance().flights.add(flight1);
=======
                                    flights.add(flight1);
>>>>>>> f9c03e61ebb2fff0f0e3d20f4f190e4462de235c

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                            adapter = new flightadapter(flights);
                            recyclerView.setAdapter(adapter);
                            adapter.notifyDataSetChanged();
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

    public static void finishActicity()
    {

    }
}
