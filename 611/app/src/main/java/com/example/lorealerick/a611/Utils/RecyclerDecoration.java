package com.example.lorealerick.a611.Utils;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by LoreAleRick on 18/03/2018.
 */

public class RecyclerDecoration extends RecyclerView.ItemDecoration {

    private int mItemOffset;

    public RecyclerDecoration(int itemOffset) {

        mItemOffset = itemOffset;
    }

    public RecyclerDecoration(Context context, int itemOffsetId) {

        this(context.getResources().getDimensionPixelSize(itemOffsetId));
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {

        super.getItemOffsets(outRect, view, parent, state);

        outRect.set(mItemOffset, mItemOffset, mItemOffset, mItemOffset);
    }

}
