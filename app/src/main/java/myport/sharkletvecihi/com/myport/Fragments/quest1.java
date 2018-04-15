package myport.sharkletvecihi.com.myport.Fragments;


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
 * Use the {@link quest1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class quest1 extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    private Button yesBtn;

    public quest1() {
        // Required empty public constructor
    }


    public static quest1 newInstance() {
        quest1 fragment = new quest1();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_quest1, container, false);

        yesBtn = (Button)view.findViewById(R.id.yesBtn);


        final FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();

        yesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentTransaction.replace(R.id.rect1, quest2.newInstance());
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });



        // Inflate the layout for this fragment
        return view;
    }

}
