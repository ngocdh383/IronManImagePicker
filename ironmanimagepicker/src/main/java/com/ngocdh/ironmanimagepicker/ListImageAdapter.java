package com.ngocdh.ironmanimagepicker;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class ListImageAdapter extends RecyclerView.Adapter<ListImageAdapter.MyViewHolder> {

    private ArrayList data;
    private Context context;

    private final String TAG = "ahihi-" + ListImageAdapter.class.getSimpleName();

    ListImageAdapter(Context context, ArrayList data) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(this.context).inflate(R.layout.image_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        String url = (String) this.data.get(position);
        Log.d(TAG, "onBindViewHolder: " + url);
        RequestOptions requestOptions = new RequestOptions();
        requestOptions = requestOptions.transforms(new CenterCrop(), new RoundedCorners(16));
        Glide.with(this.context).load(url)
                .centerCrop()
                .placeholder(R.drawable.ic_image_place_holder)
                .apply(requestOptions)
                .into(holder.mImgItem);
    }

    @Override
    public int getItemCount() {
        return this.data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        public ImageView mImgItem;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.mImgItem = itemView.findViewById(R.id.img_item);
        }
    }
}
