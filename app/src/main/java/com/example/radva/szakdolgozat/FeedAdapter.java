package com.example.radva.szakdolgozat;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class FeedAdapter extends RecyclerView.Adapter<FeedAdapter.PostViewHolder> {
    Context context = null;

    static class PostViewHolder extends RecyclerView.ViewHolder {

        final TextView feedDescription;
        final ImageView feedPhoto;
        final TextView feedLink;
        final TextView feedCreatedTime;
        final TextView feedStory;
        final TextView feedMessage;


        public PostViewHolder(View itemView) {
            super(itemView);

            feedDescription = (TextView) itemView.findViewById(R.id.feedDescription); //description
            feedMessage = (TextView) itemView.findViewById(R.id.feedMessage); // message
            feedCreatedTime = (TextView) itemView.findViewById(R.id.feedCreatedTime);
            feedLink = (TextView) itemView.findViewById(R.id.feedLink); //link
            feedStory = (TextView) itemView.findViewById(R.id.feedStory); //story
            feedPhoto = (ImageView) itemView.findViewById(R.id.feedPhoto); //full_picture
        }
    }

    List<Feed> feeds;

    FeedAdapter(List<Feed> feeds) {
        this.feeds = feeds;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public FeedAdapter.PostViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_post, null);
        PostViewHolder postViewHolder = new PostViewHolder(itemView);

        context = parent.getContext();
        return postViewHolder;
    }

    @Override
    public void onBindViewHolder(FeedAdapter.PostViewHolder holder, int position) {

            System.out.println("Description HOLDER:" + feeds.get(position).story);

            if(feeds.get(position).description != null) {
                holder.feedDescription.setVisibility(View.VISIBLE);
                holder.feedDescription.setText(feeds.get(position).description);
            }
            if(feeds.get(position).message != null) {
                holder.feedMessage.setVisibility(View.VISIBLE);
                holder.feedMessage.setText(feeds.get(position).message);
            }
            if(feeds.get(position).full_picture != null) {
                holder.feedPhoto.setVisibility(View.VISIBLE);
                Glide
                        .with(context)
                        .load(feeds.get(position).full_picture)
                        .into(holder.feedPhoto);
            }
            if(feeds.get(position).link != null) {
                holder.feedLink.setVisibility(View.VISIBLE);
                holder.feedLink.setText(feeds.get(position).link);
            }

            if(feeds.get(position).created_time != null) {
                holder.feedCreatedTime.setVisibility(View.VISIBLE);
                holder.feedCreatedTime.setText(feeds.get(position).created_time);
            }

            if(feeds.get(position).story != null) {
                holder.feedStory.setVisibility(View.VISIBLE);
                holder.feedStory.setText(feeds.get(position).story);
            }
        }


    @Override
    public int getItemCount() {
        return feeds.size();
    }

}
