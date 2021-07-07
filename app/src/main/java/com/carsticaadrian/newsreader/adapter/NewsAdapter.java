package com.carsticaadrian.newsreader.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.carsticaadrian.newsreader.databinding.NewsRowBinding;
import com.carsticaadrian.newsreader.model.ArticleItemViewModel;

import java.util.ArrayList;
import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {

    private List<ArticleItemViewModel> newsModelList;

    public NewsAdapter() {
        newsModelList = new ArrayList<>();
    }

    @NonNull
    @Override
    public NewsAdapter.NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        NewsRowBinding binder = NewsRowBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new NewsViewHolder(binder);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsAdapter.NewsViewHolder holder, int position) {
        holder.binding.setViewModel(newsModelList.get(position));
    }

    @Override
    public int getItemCount() {
        return newsModelList.size();
    }

    public void setItems(List<ArticleItemViewModel> news) {
        this.newsModelList = news;
        notifyDataSetChanged();
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder {
        final NewsRowBinding binding;

        public NewsViewHolder(NewsRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
