package com.bbva.intranet.behappy.modules.animometro;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bbva.intranet.behappy.R;
import com.bbva.intranet.behappy.models.Status;

import java.util.List;

public class StatusHeaderAdapter extends ArrayAdapter<Status> {
    private Context context;
    private List<Status> list;
    private int layoutId;
    private Holder holder;
    public View view;
    public int currPosition = 0;

    public StatusHeaderAdapter(Context context, int textViewResourceId,
                             List<Status> list) {
        super(context, textViewResourceId, list);
        this.context = context;
        this.list = list;
        layoutId = textViewResourceId;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Status getItem(int position) {
        return list.get(position);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        RelativeLayout layout;
        Status status = getItem(position);
        if (convertView == null) {

            layout = (RelativeLayout) View.inflate(context, layoutId, null);

            holder = new Holder();
            holder.ivStatus = layout.findViewById(R.id.iv_status);
            holder.ivStatus.setImageResource(status.getHeaderResIdOff());
            layout.setTag(holder);

        } else {
            layout = (RelativeLayout) convertView;
            view = layout;
            holder = (Holder) layout.getTag();
            holder.ivStatus.setImageResource(status.getHeaderResIdOff());
        }
        layout.setId(position);
        return layout;
    }

    private class Holder {
        public ImageView ivStatus;

    }
    public int getCurrentPosition(){
        return currPosition;
    }
}