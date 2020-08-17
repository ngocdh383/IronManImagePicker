package com.ngocdh.ironmanimagepicker;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.makeramen.roundedimageview.RoundedImageView;

public class EvenGridLayoutManager extends GridLayoutManager {
    private int mItemWidth = 0;

    private final String TAG = "ahihi-" + EvenGridLayoutManager.class.getSimpleName();

    public EvenGridLayoutManager(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public EvenGridLayoutManager(Context context, int spanCount) {
        super(context, spanCount);
        int itemRows = this.getSpanCount();

        if (itemRows <= 0) {
            itemRows = 3;
        }

        if (context != null) {
            WindowManager windowManager = ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE));
            DisplayMetrics displayMetrics = new DisplayMetrics();
            windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
            this.mItemWidth = (displayMetrics.widthPixels / itemRows);
        }
    }

    public EvenGridLayoutManager(Context context, int spanCount, int orientation, boolean reverseLayout) {
        super(context, spanCount, orientation, reverseLayout);
    }

    @Override
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        super.onLayoutChildren(recycler, state);

        int itemRows = this.getSpanCount();
        int space = (int) (this.mItemWidth * 0.0125);
        int size = this.mItemWidth;
        int top = 0;

        for (int i = 0; i < state.getItemCount(); i++) {
            Log.d(TAG, "onLayoutChildren: " + i);
            FrameLayout view = (FrameLayout) recycler.getViewForPosition(i);
            addView(view);
            measureChild(view, size, size);
            int left = (i % itemRows) * size;
            if (i % itemRows == 0) {
                top = (i / itemRows) * size;
            }
            int right = left + size;
            int bottom = top + size;
            layoutDecorated(view, left, top, right, bottom);
            View child = view.getChildAt(0);
            child.layout(0, 0, size, size);
            child.setPadding(space, space, space, space);
//            view.setPadding(space, space, space, space);
            view.forceLayout();
        }

    }


}
