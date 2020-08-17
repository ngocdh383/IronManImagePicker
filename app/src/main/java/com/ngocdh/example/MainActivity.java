package com.ngocdh.example;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.ngocdh.ironmanimagepicker.IronManImagePickerActivity;

public class MainActivity extends AppCompatActivity {

    private Button mBtnPickImage;
    private ImageView mImgPreview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mapping();


        this.mBtnPickImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IronManImagePickerActivity.show(MainActivity.this);
            }
        });



    }

    private void mapping() {
        this.mBtnPickImage = findViewById(R.id.btnPickImage);
        this.mImgPreview = findViewById(R.id.imgPreview);
    }


}
