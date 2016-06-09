package com.kenji.android.proen3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //レイアウトの生成
//        dynamicViewGeneration(15);


    }



    private void dynamicViewGeneration(int GenerationNumber){
        ScrollView sv = new ScrollView(this);
        sv.setMinimumWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        sv.setMinimumHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        setContentView(sv);


        LinearLayout linear_v = new LinearLayout(this);
        linear_v.setOrientation(LinearLayout.VERTICAL);
        sv.addView(linear_v, new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        for (int i=0; i<GenerationNumber; i++){
            LinearLayout ll = new LinearLayout(this);
            ll.setOrientation(LinearLayout.HORIZONTAL);
            linear_v.addView(ll, new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            for (int j=0; j<3; j++){
                Button imgBtn = new Button(this);
                imgBtn.setText(i + "-" + j);
                ll.addView(imgBtn, new RelativeLayout.LayoutParams(300, ViewGroup.LayoutParams.WRAP_CONTENT));
            }
        }

    }



    public void aa(View v){
        Intent i = new Intent(this,DetailImageActivity.class);
        startActivity(i);
    }
}
