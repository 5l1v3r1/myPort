package myport.sharkletvecihi.com.myport.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import myport.sharkletvecihi.com.myport.Models.rest;
import myport.sharkletvecihi.com.myport.Fragments.addflight;
import myport.sharkletvecihi.com.myport.Models.flight;
import myport.sharkletvecihi.com.myport.R;
import myport.sharkletvecihi.com.myport.Adapters.restadapter;

public class toDo extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do);


    }
}
