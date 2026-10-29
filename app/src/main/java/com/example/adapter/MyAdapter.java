package com.example.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{
    private ArrayList<Item> mData;
    public MyAdapter(ArrayList<Item> data) {
        this.mData = data;
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        //public final ImageView ivImage;
        public final TextView tvText1;
        public final TextView tvText2;
            public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //ivImage = itemView.findViewById(R.id.imageView);
            tvText1 = itemView.findViewById(R.id.textView);
            tvText2 = itemView.findViewById(R.id.textView2);
        }
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.layout_custom , parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        viewHolder.tvText1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = viewHolder.getAdapterPosition();
                Item data = mData.get(position);
                Toast.makeText(parent.getContext(), data.getDescription(),
                        Toast.LENGTH_LONG).show();

            }
        });

        return viewHolder;

    }



    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Item item = mData.get(position);
        holder.tvText1.setText(item.getName());
        holder.tvText2.setText(item.getDescription());
        //holder.ivImage.setImageResource(R.drawable.image);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}

