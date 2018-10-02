package com.example.dasol.b;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import com.example.dasol.b.qrscanner;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private final int FRAGMENT1 = 1;
    private final int FRAGMENT2 = 2;
    private final int FRAGMENT3 = 3;
    private final int FRAGMENT4 = 4;
    private final int FRAGMENT5 = 5;
    private ImageButton bt_tab1, bt_tab2, bt_tab3, bt_tab4, bt_tab5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 위젯에 대한 참조
        bt_tab1 = (ImageButton)findViewById(R.id.bt_tab1);
        bt_tab2 = (ImageButton)findViewById(R.id.bt_tab2);
        bt_tab3 = (ImageButton)findViewById(R.id.bt_tab3);
        bt_tab4 = (ImageButton)findViewById(R.id.bt_tab4);
        bt_tab5 = (ImageButton)findViewById(R.id.bt_tab5);
        // 탭 버튼에 대한 리스너 연결
        bt_tab1.setOnClickListener(this);
        bt_tab2.setOnClickListener(this);
        bt_tab3.setOnClickListener(this);
        bt_tab4.setOnClickListener(this);
        bt_tab5.setOnClickListener(this);
        // 임의로 액티비티 호출 시점에 어느 프레그먼트를 프레임레이아웃에 띄울 것인지를 정함
       callFragment(FRAGMENT1);


    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_tab1:
                // '버튼1' 클릭 시 '프래그먼트1' 호출
                bt_tab2.setBackgroundColor(Color.WHITE);
                bt_tab3.setBackgroundColor(Color.WHITE);
                bt_tab4.setBackgroundColor(Color.WHITE);
                bt_tab5.setBackgroundColor(Color.WHITE);
                bt_tab1.setBackgroundColor(Color.LTGRAY);
                callFragment(FRAGMENT1);
                break;

            case R.id.bt_tab2:
                // '버튼2' 클릭 시 '프래그먼트2' 호출
                bt_tab1.setBackgroundColor(Color.WHITE);
                bt_tab3.setBackgroundColor(Color.WHITE);
                bt_tab4.setBackgroundColor(Color.WHITE);
                bt_tab5.setBackgroundColor(Color.WHITE);
                bt_tab2.setBackgroundColor(Color.LTGRAY);
                callFragment(FRAGMENT2);
                break;
            case R.id.bt_tab3:
                // '버튼2' 클릭 시 '프래그먼트2' 호출
                bt_tab2.setBackgroundColor(Color.WHITE);
                bt_tab1.setBackgroundColor(Color.WHITE);
                bt_tab4.setBackgroundColor(Color.WHITE);
                bt_tab5.setBackgroundColor(Color.WHITE);
                bt_tab3.setBackgroundColor(Color.LTGRAY);
                callFragment(FRAGMENT3);
                break;
            case R.id.bt_tab4:
                // '버튼2' 클릭 시 '프래그먼트2' 호출
                bt_tab2.setBackgroundColor(Color.WHITE);
                bt_tab3.setBackgroundColor(Color.WHITE);
                bt_tab1.setBackgroundColor(Color.WHITE);
                bt_tab5.setBackgroundColor(Color.WHITE);
                bt_tab4.setBackgroundColor(Color.LTGRAY);
                callFragment(FRAGMENT4);
                break;
            case R.id.bt_tab5:
                // '버튼2' 클릭 시 '프래그먼트2' 호출
                bt_tab2.setBackgroundColor(Color.WHITE);
                bt_tab3.setBackgroundColor(Color.WHITE);
                bt_tab4.setBackgroundColor(Color.WHITE);
                bt_tab1.setBackgroundColor(Color.WHITE);
                bt_tab5.setBackgroundColor(Color.LTGRAY);
                callFragment(FRAGMENT5);
                break;
        }
    }
    private void callFragment(int frament_no){

        // 프래그먼트 사용을 위해
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        switch (frament_no){
            case 1:
                // '프래그먼트1' 호출
                Fragment1 fragment1 = new Fragment1();
                transaction.replace(R.id.fragment_container, fragment1);
                transaction.commit();
                break;

            case 2:
                // '프래그먼트2' 호출
                Fragment2 fragment2 = new Fragment2();
                transaction.replace(R.id.fragment_container, fragment2);
                transaction.commit();
                break;

            case 3:
                // '프래그먼트2' 호출
                qrscanner fragment3 = new qrscanner();
                Intent intent_qrscanner = new Intent(getBaseContext(),qrscanner.class);
                startActivity(intent_qrscanner);
                break;
            case 4:
                // '프래그먼트2' 호출
                Fragment4 fragment4 = new Fragment4();
                transaction.replace(R.id.fragment_container, fragment4);
                transaction.commit();
                break;
            case 5:
                // '프래그먼트2' 호출
                Fragment5 fragment5 = new Fragment5();
                transaction.replace(R.id.fragment_container, fragment5);
                transaction.commit();
                break;
        }

    }
}
