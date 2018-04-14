package myport.sharkletvecihi.com.myport.Activities;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import myport.sharkletvecihi.com.myport.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class fragmentActivityFragment extends Fragment {

    public fragmentActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        return inflater.inflate(R.layout.fragment_addflight, container, false);
    }
}
