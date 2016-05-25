package com.example.benjaminlize.awake.detail;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.benjaminlize.awake.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by benjamin.lize on 22/05/2016.
 */
public class WakeAdapterDetail extends RecyclerView.Adapter<WakeAdapterDetail.WakeViewHolder> {

    private List<WakeItemDetail> mWakeItemList;
    private Context mContext;

    public WakeAdapterDetail(List<WakeItemDetail> wakeItemList, Context context) {
        this.mWakeItemList = wakeItemList;
        this.mContext = context;
    }

    @Override
    public WakeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.wake_item_detail, parent,
                false);        WakeViewHolder wakeViewHolder = new WakeViewHolder(view);
        return wakeViewHolder;
    }

    @Override
    public void onBindViewHolder(WakeViewHolder holder, int position) {

        WakeItemDetail wakeItem = mWakeItemList.get(position);
        holder.textViewTitle.setText(wakeItem.getTitle());
        holder.textViewDesription.setText(String.valueOf(wakeItem.getDescription()));
        holder.textViewFootprint.setText(String.valueOf(wakeItem.getFootprint()));

        Picasso.with(mContext).load(wakeItem.getImageUrl())
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
        protected TextView textViewFootprint;

        public WakeViewHolder(View view) {
            super(view);
            this.imageView          = (ImageView) view.findViewById(R.id.image);
            this.textViewTitle      = (TextView)  view.findViewById(R.id.title);
            this.textViewDesription = (TextView)  view.findViewById(R.id.description);
            this.textViewFootprint  = (TextView)  view.findViewById(R.id.footprint);

            view.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    // item clicked
                    int position = getAdapterPosition();
                    WakeItemDetail wakeItem = mWakeItemList.get(position);
                    String url = wakeItem.getUrlWebpage();
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    browserIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    mContext.startActivity(browserIntent);
                }
            });

            FloatingActionButton myFab = (FloatingActionButton) view.findViewById(R.id.fab);
            myFab.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                        Toast.makeText(mContext, "Wake item saved to clipboard", Toast.LENGTH_SHORT)
                                .show();
                }
            });
        }
    }



}