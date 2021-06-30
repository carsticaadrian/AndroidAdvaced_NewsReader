package com.carsticaadrian.newsreader.model;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModel;

import com.carsticaadrian.data.NewsRepository;
import com.carsticaadrian.newsreader.model.mapper.ArticlesToVMListMapper;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;

public class NewsListViewModel extends ViewModel implements LifecycleObserver {

    private static final String TAG = NewsListViewModel.class.getName();

    @NonNull
    public final ObservableList<ArticleItemViewModel> newsList;

    private final NewsRepository repository;

    public NewsListViewModel(NewsRepository repository) {
        this.repository = repository;
        this.newsList = new ObservableArrayList();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void refresh() {


        repository.getNewsArticles()
                .map(new ArticlesToVMListMapper())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        this::onNewsArticlesReceived,
                        this::onNewsArticlesError
                );

    }

    private void onNewsArticlesError(Throwable throwable) {
        Log.e(TAG, "fetchToDoList error: ", throwable);
    }

    private void onNewsArticlesReceived(List<ArticleItemViewModel> articleList) {
        this.newsList.clear();
        this.newsList.addAll(articleList);
    }

}
