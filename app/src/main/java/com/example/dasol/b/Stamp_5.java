package com.example.dasol.b;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;


public class Stamp_5 extends Fragment {
        public Stamp_5(){

        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
            GridView gridView;
            // Inflate the layout for this fragment
            View fv= inflater.inflate(R.layout.fragment_stamp_5, container, false);

            gridView = (GridView)fv.findViewById(R.id.gridView02);
            ImageAdapter2 imageAdapter2 = new ImageAdapter2(getActivity());
            gridView.setAdapter(imageAdapter2);
            return fv;
        }


        public static Stamp_5 newInstance() {
                return new Stamp_5();
        }
}
