package com.chandan.android.assignment15;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by CHANDAN on 7/15/2017.
 */



public class AndroidFlavorAdapter
        extends RecyclerView.Adapter<AndroidFlavorAdapter.ViewHolder> {

    private ArrayList<AndroidFlavor>mAndroidFlavor;
    //Provide a direct reference to each of the views within a data item
    //Used to cache the views within the item layout for fast access
    public class ViewHolder extends RecyclerView.ViewHolder {
        //Your holder should contain a member variable
        //for any view that will be set as you render a row
        public TextView nameTextView;
        public ImageView androidImageView;

        //We also create a constructor that accepts the entire item row
        //and does the view lookup to find each subview
        public ViewHolder(View itemView){
            //Stores the itemView in a public final member variable that can be used
            //to access the context from any ViewHolder instance.
            super(itemView);

            nameTextView = (TextView)itemView.findViewById(R.id.android_text_view);
            androidImageView = (ImageView) itemView.findViewById(R.id.android_image_view);
        }

    }
    private Context mContext;

    //Pass in the contact array into the constructor
    public AndroidFlavorAdapter(Context context, ArrayList<AndroidFlavor> androidFlavors){
        super();
        mAndroidFlavor = androidFlavors;
        mContext = context;
    }

    //Easy access to the context object in the recyclerview
    private  Context getContext(){
        return mContext;
    }

    @Override
    public AndroidFlavorAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        //Inflate the custom layout
        View contactView = inflater.inflate(R.layout.wordlist_item, parent,false);

        //Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(AndroidFlavorAdapter.ViewHolder viewHolder, int position) {
        //Get the data model based on position
        AndroidFlavor androidFlavor = mAndroidFlavor.get(position);

        //Set item views based on your views an data model
        TextView textView = viewHolder.nameTextView;
        textView.setText(androidFlavor.getVersionName());

        ImageView imageView = viewHolder.androidImageView;
        imageView.setImageResource(androidFlavor.getImageResourceId());
    }

    @Override
    public int getItemCount() {
        return mAndroidFlavor.size();
    }
}
