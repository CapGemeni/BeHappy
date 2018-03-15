package com.bbva.intranet.behappy.components;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;

import com.bbva.intranet.behappy.R;
import com.bbva.intranet.behappy.app.Config;
import com.bbva.intranet.behappy.models.Status;
import com.bbva.intranet.behappy.modules.animometro.StatusHeaderAdapter;

import java.util.List;

public class CenterLockHorizontalScrollView extends HorizontalScrollView {
    Context context;
    int prevIndex = 0;
    List<Status> status;

    public CenterLockHorizontalScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        this.setSmoothScrollingEnabled(true);

    }

    public void setAdapter(StatusHeaderAdapter mAdapter, List<Status> status) {
        this.status = status;
        try {
            fillViewWithAdapter(mAdapter);
        } catch (Exception e) {
            Log.w(Config.TAG, e);
        }
    }

    private void fillViewWithAdapter(StatusHeaderAdapter mAdapter)
            throws Exception {
        if (getChildCount() == 0) {
            throw new Exception(
                    "CenterLockHorizontalScrollView must have one child");
        }
        if (getChildCount() == 0 || mAdapter == null)
            return;

        ViewGroup parent = (ViewGroup) getChildAt(0);
        parent.removeAllViews();
        for (int i = 0; i < mAdapter.getCount(); i++) {
            parent.addView(mAdapter.getView(i, null, parent));
        }
    }

    public void setCenter(int index, StatusHeaderAdapter adapter) {
        ViewGroup parent = (ViewGroup) getChildAt(0);
        View preView = parent.getChildAt(prevIndex);
        ImageView iv = preView.findViewById(R.id.iv_status);
        iv.setImageResource(adapter.getItem(prevIndex).getHeaderResIdOff());

        View view = parent.getChildAt(index);
        ImageView ivCurrent = view.findViewById(R.id.iv_status);
        ivCurrent.setImageResource(adapter.getItem(index).getHeaderResIdOn());

        int screenWidth = ((Activity) context).getWindowManager()
                .getDefaultDisplay().getWidth();

        int scrollX = (view.getLeft() - (screenWidth / 2))
                + (view.getWidth() / 2);
        this.smoothScrollTo(scrollX, 0);
        prevIndex = index;
    }

}