package com.example.benjaminlize.awake.main;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.benjaminlize.awake.R;
import com.example.benjaminlize.awake.detail.DetailActivity;
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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.wake_item, parent,
                false);
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
        if (mWakeItemList != null){
            return mWakeItemList.size();
        }else {
            Toast.makeText(mContext, "Please connect to the internet and restart the app", Toast
                    .LENGTH_SHORT).show();
            return 0;
        }
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
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtra(DetailActivity.URL_APPEND, wakeItem.getDetailURL()); //Put
                    // your id to your
                    mContext.startActivity(intent);
                }
            });
        }
    }



}
