package myport.sharkletvecihi.com.myport.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import myport.sharkletvecihi.com.myport.Models.flight;


import java.util.ArrayList;
import java.util.List;

import myport.sharkletvecihi.com.myport.R;
import myport.sharkletvecihi.com.myport.Holders.flightholder;
import myport.sharkletvecihi.com.myport.Adapters.flightadapter;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link addflight#newInstance} factory method to
 * create an instance of this fragment.
 */
public class addflight extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    private RecyclerView recyclerView;
    private List<flight> flights;
    private flightadapter adapter;
    private RequestQueue mRequestQueue;
    private StringRequest mStringRequest;


    public addflight() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static addflight newInstance() {
        addflight fragment = new addflight();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_addflight, container, false);
        RequestQueue queue = Volley.newRequestQueue(getActivity());

        String url = "http://35.159.15.121:8080/flightInformation/getList?code=IST&flightType=DOM&flightLeg=DEP&minStad=15%2F4%2F2018%2000%3A00&maxStad=16%2F4%2F2018%2000%3A00";

        flights = new ArrayList<>();
        adapter = new flightadapter(flights);


        recyclerView = (RecyclerView)view.findViewById(R.id.flightrecycler);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(), 1);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);


        mStringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Toast.makeText(view.getContext(),"Response :" + response.toString(), Toast.LENGTH_LONG).show();//display the response on screen

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Log.i("response","Error :" + error.toString());
            }
        });

        mRequestQueue.add(mStringRequest);

        /* Add your Requests to the RequestQueue to execute */


        return view;
    }

}
