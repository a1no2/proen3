package com.kenji.android.proen3;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //レイアウトの生成
        //GridViewできたから、いらない子
//        dynamicViewGeneration(10);

        ArrayList<Bitmap> list = load();
        BitmapAdapter adapter = new BitmapAdapter(
                getApplicationContext(), R.layout.list_item,
                list);

        GridView gridView = (GridView) findViewById(R.id.images_gridView);
        gridView.setAdapter(adapter);


    }

    private ArrayList<Bitmap> load() {
        ArrayList<Bitmap> list = new ArrayList<Bitmap>();
        ContentResolver cr = getContentResolver();
        Uri uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        Cursor c = managedQuery(uri, null, null, null, null);
        c.moveToFirst();
        for (int i = 0; i < c.getCount(); i++) {
            long id = c.getLong(c.getColumnIndexOrThrow("_id"));
            Bitmap bmp = MediaStore.Images.Thumbnails.getThumbnail(cr, id, MediaStore.Images.Thumbnails.MICRO_KIND, null);
            list.add(bmp);
            c.moveToNext();
        }
        return list;
    }


    //動的にview生成
    //GridViewできたから、いらない子
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
                ll.addView(imgBtn, new RelativeLayout.LayoutParams(400, ViewGroup.LayoutParams.WRAP_CONTENT));
            }
        }

    }



    public void aa(View v){
        Intent i = new Intent(this,DetailImageActivity.class);
        startActivity(i);
    }
}
