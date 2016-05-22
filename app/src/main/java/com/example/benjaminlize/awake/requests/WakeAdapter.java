package com.example.benjaminlize.awake.requests;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.benjaminlize.awake.R;
import com.example.benjaminlize.awake.pojo.WakeItem;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by benjamin.lize on 22/05/2016.
 */
public class WakeAdapter extends RecyclerView.Adapter<WakeAdapter.WakeViewHolder> {

    private List<WakeItem> mWakeItemList;
    private Context mContext;

    public WakeAdapter(List<WakeItem> wakeItemList, Context context) {
        this.mWakeItemList = wakeItemList;
        this.mContext = context;
    }

    @Override
    public WakeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.wake_item, null);
        WakeViewHolder wakeViewHolder = new WakeViewHolder(view);
        return wakeViewHolder;
    }

    @Override
    public void onBindViewHolder(WakeViewHolder holder, int position) {

        WakeItem wakeItem = mWakeItemList.get(position);
        holder.textViewTitle.setText(wakeItem.getTitle());
        holder.textViewDesription.setText(String.valueOf(wakeItem.getDescription()) + " items");

        Picasso.with(mContext).load(wakeItem.getImage())
                .error(R.mipmap.ic_launcher)
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return mWakeItemList.size();
    }

    protected class WakeViewHolder extends RecyclerView.ViewHolder {
        protected ImageView imageView;
        protected TextView textViewTitle;
        protected TextView textViewDesription;

        public WakeViewHolder(View view) {
            super(view);
            this.imageView          = (ImageView) view.findViewById(R.id.image);
            this.textViewTitle      = (TextView)  view.findViewById(R.id.title);
            this.textViewDesription = (TextView)  view.findViewById(R.id.description);
        }
    }

}
