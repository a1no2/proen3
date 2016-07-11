package com.kenji.android.proen3;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Color;
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
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

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
                getApplicationContext(),
                R.layout.list_item,
                list);

        LinearLayout allWrap_Linear = (LinearLayout) findViewById(R.id.allWrap_Linear);

        GridView gridView = (GridView) findViewById(R.id.images_gridView);
//        gridView.setHorizontalSpacing(100);
        gridView.setAdapter(adapter);

        //位置指定　XMLで指定してあるなら要らない
//        allWrap_Linear.addView(gridView, 1, new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));


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


    //仮置き
    public void aa(View v) {
        Intent i = new Intent(this, DetailImageActivity.class);
        startActivity(i);
    }

}