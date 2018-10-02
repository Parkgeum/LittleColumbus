package com.example.columbus;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.columbus.ImageAdapter;


public class Camera_5 extends Fragment {
    public Camera_5(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        GridView gridView;
        // Inflate the layout for this fragment
       View fv = inflater.inflate(R.layout.fragment_camera_5, container, false);

        gridView = (GridView)fv.findViewById(R.id.gridView01);
        ImageAdapter imageAdapter = new ImageAdapter(getActivity());
        gridView.setAdapter(imageAdapter);
        return fv;
    }

    public static Camera_5 newInstance() {
        return new Camera_5();
    }
}