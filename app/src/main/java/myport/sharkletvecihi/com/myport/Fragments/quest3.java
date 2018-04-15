package myport.sharkletvecihi.com.myport.Fragments;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import myport.sharkletvecihi.com.myport.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link quest3#newInstance} factory method to
 * create an instance of this fragment.
 */
public class quest3 extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    private Button okBtn;

    public quest3() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static quest3 newInstance() {
        quest3 fragment = new quest3();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_quest3, container, false);
        okBtn = (Button)view.findViewById(R.id.okBtn);

        final FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();

        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putInt("init", 1);
                editor.commit();
                getActivity().finish();
            }
        });

        // Inflate the layout for this fragment
        return view;
    }

}
