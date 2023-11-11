package com.example.l1_m3_intent_prodoljenie;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private Button btnGo;
    private ImageView imgPhoto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initListener();
    }
    private void initListener(){
     btnGo.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             Intent intent=new Intent();
             intent.setAction(Intent.ACTION_GET_CONTENT);
             intent.setType("image/*");
             startActivityForResult(Intent.createChooser(intent,"Select Picture"),77); //  startActivityForResult(intent,77);//и так работает
         }
     });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==77 && resultCode==RESULT_OK && data!=null){
            Uri imageResult=data.getData();
            imgPhoto.setImageURI(imageResult);
        }
    }

    private void initView(){
        btnGo=findViewById(R.id.btn_go);
        imgPhoto=findViewById(R.id.img_photo);
    }
}