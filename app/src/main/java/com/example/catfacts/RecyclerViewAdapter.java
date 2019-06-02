package com.example.catfacts;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public  class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    Context mContext;
    List<Fact> mData;

    public RecyclerViewAdapter(Context mContext, List<Fact> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public  MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v;// узнать почему не принимает parent
        v= LayoutInflater.from(mContext).inflate(R.layout.fact_item,parent,false);
        MyViewHolder viewHolder= new MyViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
    holder.titleTextView.setText(mData.get(position).getId());
    holder.textView.setText(mData.get(position).getText());
     holder.isFavoriteCheckBox.setChecked(mData.get(position).getFavorite());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView titleTextView;
        private TextView textView;
        private ImageView img;
        private CheckBox isFavoriteCheckBox;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        titleTextView=(TextView)itemView.findViewById(R.id.textView_title_id);
        textView=(TextView)itemView.findViewById(R.id.textView_id);
        //img=(ImageView)itemView.findViewById(R.drawable.ic_info_black_24dp);

    }
}
}
