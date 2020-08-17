package com.ngocdh.ironmanimagepicker;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import androidx.recyclerview.widget.RecyclerView;

public class DemoLayoutManager extends RecyclerView.LayoutManager {

    private Context mContext;

    private int mItemRows = 3;
    private int mItemWidth = 0;

    public DemoLayoutManager(Context context, int itemRows) {
        this.mContext = context;
        this.mItemRows = itemRows;

        if (this.mItemRows <= 0) {
            this.mItemRows = 3;
        }

        if (this.mContext != null) {
            WindowManager windowManager = ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE));
            DisplayMetrics displayMetrics = new DisplayMetrics();
            windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
            this.mItemWidth = displayMetrics.widthPixels / this.mItemRows;
        }
    }

    @Override
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    }

    @Override
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        super.onLayoutChildren(recycler, state);
        int top = 0;
        for (int i = 0; i < state.getItemCount(); i++) {
            View view = recycler.getViewForPosition(i);
            addView(view);
            measureChild(view, this.mItemWidth, this.mItemWidth);
            int left = (i % this.mItemRows) * this.mItemWidth;
            if (i % this.mItemRows == 0) {
                top = (i / this.mItemRows) * this.mItemWidth;
            }
            int right = left + this.mItemWidth;
            int bottom = top + this.mItemWidth;
            layoutDecorated(view, left, top, right, bottom);
        }

    }
}
