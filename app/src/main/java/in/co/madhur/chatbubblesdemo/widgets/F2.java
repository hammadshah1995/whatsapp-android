package in.co.madhur.chatbubblesdemo.widgets;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import in.co.madhur.chatbubblesdemo.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class F2 extends Fragment {


    public F2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        TextView ab = (TextView) getView().findViewById(R.id.test);
        ab.setText("hi there");
        return inflater.inflate(R.layout.fragment_f2, container, false);
    }

}
