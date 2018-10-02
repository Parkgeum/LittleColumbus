package com.example.columbus;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.view.StandaloneActionMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;


public class Fragment5 extends Fragment implements View.OnClickListener {
    public static Fragment5 newInstance() {
        return new Fragment5();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ImageButton bt_camera, bt_stamp, bt_setting;
        GridView gridView;

        // Inflate the layout for this fragment
        View fv = inflater.inflate(R.layout.fragment_fragment5, container, false);
        // 위젯에 대한 참조

        //button - 버튼 눌렀을 때 뭐할지 하기 위해
        bt_camera = (ImageButton) fv.findViewById(R.id.bt_camera);
        bt_camera.setOnClickListener(this);
        bt_stamp = (ImageButton) fv.findViewById(R.id.bt_stamp);
        bt_stamp.setOnClickListener(this);

        bt_setting = (ImageButton) fv.findViewById(R.id.bt_setting);
        bt_setting.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), setting.class);
                startActivity(intent);
            }
        });

        //grid
        gridView = (GridView) fv.findViewById(R.id.gridView01);
        ImageAdapter imageAdapter = new ImageAdapter(getActivity());
        gridView.setAdapter(imageAdapter);


        return fv;
    }



    @Override
    public void onClick(View view) {
        Fragment fg;

        switch (view.getId()) {
            case R.id.bt_camera:
                fg = Camera_5.newInstance();
                setChildFragment(fg);
                break;
            case R.id.bt_stamp:
                fg = Stamp_5.newInstance();
                setChildFragment(fg);
                break;
        }
    }

    public void setChildFragment(Fragment child) {
        FragmentTransaction childFt = getChildFragmentManager().beginTransaction();

        if (!child.isAdded()) {
            childFt.replace(R.id.child_fragment_container, child);
            childFt.addToBackStack(null);
            childFt.commit();

        }
    }
}
