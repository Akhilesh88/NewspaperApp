package com.example.newspaperapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.HashMap;


public class HomeListAdapter extends RecyclerView.Adapter<HomeListAdapter.ViewHolder>{
    Context mContext;
    ArrayList<HashMap<String, String>> mArray;//hash map: key value context //adapter is usded content view in recycle view  in main activity to store the image objects in

    public HomeListAdapter(Context cxt, ArrayList<HashMap<String, String>> mArray){
        this.mContext = cxt;
        this.mArray = mArray;
    }

    public  static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imgBanner;
        TextView txtTitle, txtDescription;
        public ViewHolder(View v){
            super(v);
            imgBanner = (ImageView) v.findViewById(R.id.imageView2);
            txtTitle = (TextView) v.findViewById(R.id.textView);
            txtDescription = (TextView) v.findViewById(R.id.txtDescription);
        }
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {


        HashMap<String,String> map = mArray.get(position);
        Glide.with(mContext).load(map.get("url")).into(holder.imgBanner);
        holder.txtTitle.setText(map.get("title"));
        holder.txtDescription.setText(map.get("detail"));
        MainActivity.description1=map.get("detail");
    }

    @Override
    public int getItemCount() {
        return mArray.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {               //layout inflater parent group
        View mRowView = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_list_row, parent, false);
        ViewHolder vh = new ViewHolder(mRowView);

        return vh;
    }
}