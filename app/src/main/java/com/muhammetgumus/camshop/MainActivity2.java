package com.muhammetgumus.camshop;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.TimeUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity2 extends AppCompatActivity {

    ImageView imageview;
    Button b;
    TextView textView2;
    Bitmap bmp;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity2);
        textView2=findViewById(R.id.textActivity2);
        imageview = (ImageView) findViewById(R.id.imageNew);
        bmp = (Bitmap) getIntent().getParcelableExtra("photo");
        imageview.setImageBitmap(bmp);
        b=(Button) findViewById(R.id.buttonSend);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startProcess();

            }
        });

    }
        public void startProcess(){

            Gson gson= new GsonBuilder().setLenient().create();

            Retrofit.Builder builder = new Retrofit.Builder()
                   .baseUrl("http://35.198.131.192:8080")
                   .addConverterFactory(GsonConverterFactory.create(gson));


            String fileName = new SimpleDateFormat("yyyyMMddHHmm'.jpeg'").format(new Date());
            File f = new File(getCacheDir(), fileName);
            try {
                f.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                Bitmap bitmap = bmp;
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 0 /*ignored for PNG*/, bos);
                byte[] bitmapdata = bos.toByteArray();

                FileOutputStream fos = new FileOutputStream(f);
                fos.write(bitmapdata);
                fos.flush();
                fos.close();

            } catch (Exception e) {
                Log.e(getClass().getSimpleName(), "Error writing bitmap", e);
            }
                                                                                    //imageFile
        RequestBody requestFile = RequestBody.create(MediaType.parse("image/*") ,f);


        Retrofit retrofit = builder.build();
                                                                                              //file.getName()
        MultipartBody.Part sendingFile= MultipartBody.Part.createFormData("file","imageToUpload",requestFile);
        GitHubClient client =retrofit.create(GitHubClient.class);

        Call<ImageResponse> call = client.processImage(sendingFile);
        call.enqueue(new Callback<ImageResponse>() {
            @Override
            public void onResponse(Call<ImageResponse> call, Response<ImageResponse> response) {
                ImageResponse imageResponse = response.body();
                textView2.setText(imageResponse.getName()+" "+imageResponse.getStatus()+" "+imageResponse.getToken()+" "+imageResponse.getUrl());

            }

            @Override
            public void onFailure(Call<ImageResponse> call, Throwable t) {
                textView2.setText("ERRORRRRRRR: "+ t.getMessage()+"!!!!!"+"\n"+t.getCause()  );
            }
        });






        }

}
