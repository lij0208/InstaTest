package com.liz.ktest.instatest.list;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.liz.ktest.instatest.R;
import com.liz.ktest.instatest.model.Recent;

import java.util.List;

public class InstaAdapter extends RecyclerView.Adapter<ImageHolder> {

    private List<Recent> recentList;

    public void setRecentList(List<Recent> recentList) {
        this.recentList = recentList;
        notifyDataSetChanged();
    }

    @Override
    public ImageHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ImageHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false));
    }

    @Override
    public void onBindViewHolder(ImageHolder holder, int position) {
        holder.bind(recentList.get(position));
    }

    @Override
    public int getItemCount() {
        return recentList == null ? 0 : recentList.size();
    }
}
