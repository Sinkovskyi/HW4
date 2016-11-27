package com.example.admin.hw;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;



public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {


    private String[] mDataset;




    public static class ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout linearLayout;
        TextView textView;
        ImageView imageView;

        public ViewHolder(View v) {
            super(v);
            textView= (TextView) v.findViewById(R.id.tv_recycler_item);
            imageView = (ImageView) v.findViewById(R.id.iv_recycler_item);
            linearLayout =(LinearLayout) v.findViewById(R.id.ll_recycler_item);
        }
    }


    public RecyclerAdapter(String[] dataset) {
        mDataset = dataset;
    }

    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_item, parent, false);
        
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.textView.setText(mDataset[position]);
        holder.linearLayout.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Toast.makeText( view.getContext(),holder.textView.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }




    @Override
    public int getItemCount() {
        return mDataset.length;
    }

}
