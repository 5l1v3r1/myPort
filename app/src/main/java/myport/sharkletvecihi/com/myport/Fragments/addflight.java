package myport.sharkletvecihi.com.myport.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import myport.sharkletvecihi.com.myport.R;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link addflight#newInstance} factory method to
 * create an instance of this fragment.
 */
public class addflight extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER




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
        return inflater.inflate(R.layout.fragment_addflight, container, false);
    }

}
