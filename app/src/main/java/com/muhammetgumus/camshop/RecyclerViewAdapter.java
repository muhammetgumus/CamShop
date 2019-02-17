package com.muhammetgumus.camshop;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>  {

    private static final String TAG = "RecyclerViewAdapter";
    private ArrayList<String> mImageNames= new ArrayList<>();
    private ArrayList<String> mImagesUrls = new ArrayList<>();
    private ArrayList<String> mPrices = new ArrayList<>();
    private Context mContext;

    public RecyclerViewAdapter( Context mContext,ArrayList<String> mImageNames, ArrayList<String> mImagesUrls,ArrayList<String> mPrices) {
        this.mContext = mContext;
        this.mImageNames = mImageNames;
        this.mImagesUrls = mImagesUrls;
        this.mPrices=mPrices;

    }

    //onCreateViewHolder responsible for inflating the view
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called");

        Picasso.get().load(mImagesUrls.get(position)).resize(50,50).centerCrop()
                .into(holder.imageView);

        //Glide.with(mContext).load(mImagesUrls.get(position)).into(holder.imageView);

        holder.productName.setText(mImageNames.get(position));
        holder.productPrice.setText(mPrices.get(position));
        holder.mainContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: clicked on "+mImageNames.get(position));
                Toast.makeText(mContext,mImageNames.get(position),Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return mImageNames.size();
    }

    //ViewHolder class her satırı tek tek tutuyor.
    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView productName;
        TextView productPrice;
        LinearLayout innerLinearLayout;
        CardView cardView;
        LinearLayout outerLinearLayout;
        RelativeLayout mainContainer;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.productImage);
            productName=itemView.findViewById(R.id.productName);
            productPrice=itemView.findViewById(R.id.productPrice);
            innerLinearLayout=itemView.findViewById(R.id.rowInsideLinearLayout);
            outerLinearLayout=itemView.findViewById(R.id.imageAndLinearLayoutHolder);
            mainContainer=itemView.findViewById(R.id.parent_layout);
            cardView=itemView.findViewById(R.id.cardview);
        }
    }


}
