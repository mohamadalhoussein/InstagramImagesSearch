package com.example.student.instagramuserssearch.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.student.instagramuserssearch.R;
import com.example.student.instagramuserssearch.beans.ThumbnailBean;
import com.loopj.android.image.SmartImageView;

import java.util.List;

/**
 * Created by student on 9/21/2017.
 */

public class ImagesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<ThumbnailBean> images;
    private Context context;


    public ImagesAdapter(Context context, List<ThumbnailBean> images) {
        this.images = images;
        this.context = context;

    }

    public static class ImagesHolder extends RecyclerView.ViewHolder {
        public SmartImageView imageView;
        public View root;

        public ImagesHolder(View root) {
            super(root);
            this.root = root;
            imageView = (SmartImageView) root.findViewById(R.id.iv_user_image);
        }

    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.image_item, parent, false);
        return new ImagesAdapter.ImagesHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        onBindUserHolder((ImagesAdapter.ImagesHolder) holder, position);
    }

    public List<ThumbnailBean> getImages() {
        return images;
    }

    private void onBindUserHolder(final ImagesHolder holder, int position) {
        final ThumbnailBean image = images.get(position);
        holder.imageView.setImageUrl(image.getUrl());

    }
}
