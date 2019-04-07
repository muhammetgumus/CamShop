package com.muhammetgumus.camshop;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.w3c.dom.Text;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Sample1Activity extends AppCompatActivity {

    TextView text;
    ImageView img;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity2);
       // text =(TextView)findViewById(R.id.textView);
       final Bitmap bmp= (Bitmap) getIntent().getParcelableExtra("image");
        img= (ImageView) findViewById(R.id.imageView3);
        img.setImageBitmap(bmp);

        /*
        Gson gson= new GsonBuilder().setLenient().create();

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("http://35.198.131.192:8080")
                .addConverterFactory(GsonConverterFactory.create(gson));

        Bitmap bitmap = (Bitmap)getIntent().getParcelableExtra("image");
        File filesDir = getFilesDir();
        File imageFile = new File(filesDir, "imageAsd" + ".jpg");

        OutputStream os;
        try {
            os = new FileOutputStream(imageFile);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, os);
            os.flush();
            os.close();
        } catch (Exception e) {
            Log.e(getClass().getSimpleName(), "Error writing bitmap", e);
        }

*/


        /* "//storage//DCIM//'Camera//20190405_123026.jpg";   */
        String path= Environment.DIRECTORY_PICTURES+"//download.jpg";
        Uri denemeUri= Uri.parse(path);

        System.out.println(denemeUri);

        File file = new File(path);
        file.getAbsolutePath();

       /* Uri uri;
        uri=Uri.parse(file.getAbsolutePath());
        int lengthString=uri.toString().length()+1;
        String uriModified= uri.toString().substring(1,lengthString);
        Uri uri2=Uri.parse(uriModified);
        System.out.println(uri2);*/

        //RequestBody requestFile = RequestBody.create(MediaType.parse("image/jpeg") ,file);
 /*       RequestBody requestFile = RequestBody.create(MediaType.parse("image/jpeg") ,imageFile);


        Retrofit retrofit = builder.build();
                                                                                              //file.getName()
        MultipartBody.Part sendingFile= MultipartBody.Part.createFormData("photoToUpload","imageToUpload",requestFile);
        GitHubClient client =retrofit.create(GitHubClient.class);

        Call<ImageResponse> call = client.processImage(sendingFile);
        call.enqueue(new Callback<ImageResponse>() {
            @Override
            public void onResponse(Call<ImageResponse> call, Response<ImageResponse> response) {
                text.setText("ALLLL OF DONEEEEE : " + response.body().getName()
                        +" "+ " " );


            }

            @Override
            public void onFailure(Call<ImageResponse> call, Throwable t) {
                text.setText("ERRORRRRRRR: "+ t.getMessage()+"!!!!!"+"\n"+t.getCause()  );
            }
        });


*/








    }





}
