package com.example.dasol.b;

import android.app.Activity;
import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.widget.TextView;
import android.widget.Toast;
import android.widget.ImageView;

import com.example.dasol.b.R;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import org.json.JSONException;
import org.json.JSONObject;

import static java.security.AccessController.getContext;
public class qrscanner extends AppCompatActivity {

    private Button buttonScan;
    private IntentIntegrator qrScan;
    private ImageView imageView;
    private String str;

    public qrscanner(){

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrscanner);
        buttonScan = (Button) findViewById(R.id.buttonScan);
        imageView = (ImageView)findViewById(R.id.view);

        qrScan = new IntentIntegrator(this);
        buttonScan.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //scan option
                qrScan.setPrompt("Scanning...");
                //qrScan.setOrientationLocked(false);
                qrScan.initiateScan();
            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            //qrcode 가 없으면
            if (result.getContents() == null) {
                Toast.makeText(qrscanner.this, "취소!", Toast.LENGTH_SHORT).show();
            } else {
                buttonScan.setText("홈으로가기");
              /* findViewById(R.id.buttonScan).setOnClickListener(
                        new Button.OnClickListener(){
                            public void onClick(View v){
                                Intent intent_home = new Intent(getApplicationContext(),first.feed.class);
                                startActivity(intent_home);
                            }}
                );*/

                try {
                    //data를 json으로 변환
                    JSONObject obj = new JSONObject(result.getContents());
                    String str = obj.getString("name");



                    if (obj.getString("name").equals("한성대학교")){
                        imageView.setImageResource(R.drawable.hansunguniv);

                    }
                    else if (obj.getString("name").equals("경복궁")){
                        imageView.setImageResource(R.drawable.kungbook);

                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                    //Toast.makeText(MainActivity.this, result.getContents(), Toast.LENGTH_LONG).show();

                }
            }

        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }    }
}
