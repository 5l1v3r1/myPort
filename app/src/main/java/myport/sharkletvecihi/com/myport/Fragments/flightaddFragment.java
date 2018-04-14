package myport.sharkletvecihi.com.myport.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import myport.sharkletvecihi.com.myport.R;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link flightaddFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class flightaddFragment extends Fragment {

    private RecyclerView recyclerView;





    public flightaddFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static flightaddFragment newInstance() {
        flightaddFragment fragment = new flightaddFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_flightadd, container, false);










        return view;
    }

}
