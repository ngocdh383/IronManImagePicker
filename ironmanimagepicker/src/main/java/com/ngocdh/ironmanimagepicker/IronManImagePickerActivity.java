package com.ngocdh.ironmanimagepicker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Presentation;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;

import java.util.ArrayList;
import java.util.Random;

public class IronManImagePickerActivity extends AppCompatActivity {

    private final String TAG = "ahihi-" + IronManImagePickerActivity.class.getSimpleName();

    private RecyclerView mRecyclerViewListImage;

    private ListImageAdapter mListImageAdapter;


    public static void show(Context context) {
        Intent intent = new Intent(context, IronManImagePickerActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iron_man_image_picker);

        this.mRecyclerViewListImage = this.findViewById(R.id.recyclerview_list_image);

        ArrayList data = new ArrayList();
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            data.add("http://image.phimmoizz.net/film/" + random.nextInt(3000) + "/poster.medium.jpg");
        }

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
//        EvenGridLayoutManager evenGridLayoutManager = new EvenGridLayoutManager(this, 3);
        this.mListImageAdapter = new ListImageAdapter(this, data, 3);
//        this.mRecyclerViewListImage.setLayoutManager(evenGridLayoutManager);
        this.mRecyclerViewListImage.setLayoutManager(gridLayoutManager);
        this.mRecyclerViewListImage.setAdapter(this.mListImageAdapter);
        this.mRecyclerViewListImage.setHasFixedSize(true);
    }
}
