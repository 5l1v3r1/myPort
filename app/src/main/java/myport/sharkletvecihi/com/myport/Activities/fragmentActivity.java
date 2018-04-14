package myport.sharkletvecihi.com.myport.Activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.util.Log;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import myport.sharkletvecihi.com.myport.Models.flight;
import myport.sharkletvecihi.com.myport.Fragments.addflight;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;

import myport.sharkletvecihi.com.myport.R;

public class fragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        String url = "http://35.159.15.121:8080/flightInformation/getList?code=IST&flightType=DOM&flightLeg=DEP&minStad=15%2F4%2F2018%2000%3A00&maxStad=16%2F4%2F2018%2000%3A00";


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
                                    addflight.newInstance().flights.add(flight1);

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
