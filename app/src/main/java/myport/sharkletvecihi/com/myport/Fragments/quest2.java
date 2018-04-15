package myport.sharkletvecihi.com.myport.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.ButtonBarLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import myport.sharkletvecihi.com.myport.R;
import myport.sharkletvecihi.com.myport.Fragments.quest3;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link quest2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class quest2 extends Fragment {

    private Button nextBtn;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    public quest2() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static quest2 newInstance() {
        quest2 fragment = new quest2();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_quest2, container, false);
        nextBtn = (Button)view.findViewById(R.id.nextBtn);
        final FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentTransaction.replace(R.id.rect1, quest3.newInstance());
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        // Inflate the layout for this fragment
        return view;
    }

}
