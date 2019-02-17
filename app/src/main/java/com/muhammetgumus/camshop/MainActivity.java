package com.muhammetgumus.camshop;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ImageView image;
    Bundle b;

    private static final String TAG = "MainActivity";

    //vars
    private ArrayList<String> mNames= new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();
    private ArrayList<String> mPricess = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_list);
        initImageBitmaps();



        //   image = findViewById(R.id.imageView);



            //b= savedInstanceState;
    //    if(b.getParcelable("photo")==null) {
       //     Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

    //        startActivityForResult(intent, 0);
      //  }



      /*  if(b!=null){
            image.setImageBitmap((Bitmap) b.getParcelable("photo"));
        }//else {image = findViewById(R.id.imageView);}
*/


    }




/*
    public void openCamera(){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent,0);

        }





    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
     //   Bitmap photo = (Bitmap) data.getExtras().get("data");
     //   Intent intent= new Intent();
     //   intent.putExtras("photo",photo);
       // image.setImageBitmap(photo);
     //  b= data.getExtras();
      // Bitmap bm = (Bitmap) b.get("data");
      // image.setImageBitmap(photo);
    //   b.putParcelable("photo",photo);
}
*/

private void initImageBitmaps(){
        mImageUrls.add("https://cdn.vatanbilgisayar.com/UPLOAD/PRODUCT/APPLE/thumb/v2-88233_medium.JPG");
        mNames.add("IPhone 7");
        mPricess.add("3500");

        mImageUrls.add("https://cdn.vatanbilgisayar.com/UPLOAD/PRODUCT/APPLE/thumb/v2-87791-40_medium.jpg");
        mNames.add("IPhone 8");
        mPricess.add("4500");

        mImageUrls.add("http://cdn.vatanbilgisayar.com/UPLOAD/PRODUCT/APPLE/thumb/v2-88880_medium.jpg");
        mNames.add("IPhone X");
        mPricess.add("7500");

        mImageUrls.add("http://cdn.vatanbilgisayar.com/UPLOAD/PRODUCT/APPLE/thumb/v2-92534_medium.jpg");
        mNames.add("IPhone X S");
        mPricess.add("10000");

        initRecyclerView();
}


    private void initRecyclerView(){
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this,mNames,mImageUrls,mPricess);

       // recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(adapter);
}



}
