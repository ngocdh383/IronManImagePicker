package com.ngocdh.ironmanimagepicker;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
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
    private int mItemWidth;

    private final String TAG = "ahihi-" + ListImageAdapter.class.getSimpleName();

    ListImageAdapter(Context context, ArrayList data, int itemCount) {
        this.data = data;
        this.context = context;
        WindowManager windowManager = ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE));
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
        this.mItemWidth = (displayMetrics.widthPixels / itemCount);
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
        Glide.with(this.context).load(url)
                .centerCrop()
                .placeholder(R.drawable.ic_image_place_holder)
                .error(R.drawable.ic_image)
                .override(this.mItemWidth, this.mItemWidth)
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
