package com.example.benjaminlize.awake.detail;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.benjaminlize.awake.R;
import com.example.benjaminlize.awake.main.WakeItem;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by benjamin.lize on 22/05/2016.
 */
public class WakeAdapterDetail extends RecyclerView.Adapter<WakeAdapterDetail.WakeViewHolder> {

    private List<WakeItem> mWakeItemList;
    private Context mContext;

    public WakeAdapterDetail(List<WakeItem> wakeItemList, Context context) {
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

            view.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    // item clicked
                    int position = getAdapterPosition();
                    Intent intent = new Intent(mContext, DetailActivity.class);
                    WakeItem wakeItem = mWakeItemList.get(position);
                    intent.putExtra(DetailActivity.URL_APPEND, wakeItem.getDetailURL()); //Put
                    // your id to your
                    mContext.startActivity(intent);
                }
            });
        }
    }

}