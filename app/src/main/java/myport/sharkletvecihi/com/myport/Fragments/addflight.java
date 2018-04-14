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
import android.widget.TimePicker;
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
import myport.sharkletvecihi.com.myport.Activities.fragmentActivity;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link addflight#newInstance} factory method to
 * create an instance of this fragment.
 */
public class addflight extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    private RecyclerView recyclerView;
    public List<flight> flights;
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



        flights = new ArrayList<>();
        adapter = new flightadapter(flights);


        recyclerView = (RecyclerView)view.findViewById(R.id.flightrecycler);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(), 1);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);


            // Pass second argument as "null" for GET requests






        /* Add your Requests to the RequestQueue to execute */


        return view;
    }

}
