package com.carsticaadrian.data.features.news;

import com.carsticaadrian.data.NewsRepository;
import com.carsticaadrian.data.features.news.local.NewsLocalSource;
import com.carsticaadrian.data.features.news.model.Article;
import com.carsticaadrian.data.features.news.remote.NewsRemoteSource;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.annotations.NonNull;

public class NewsRepositoryImpl implements NewsRepository {


    private final NewsRemoteSource remoteSource;

    private final NewsLocalSource localSource;

    public NewsRepositoryImpl(NewsRemoteSource remoteSource, NewsLocalSource localSource) {
        this.remoteSource = remoteSource;
        this.localSource = localSource;
    }

    @Override
    @NonNull
    public Single<List<Article>> getNewsArticles() {
        return remoteSource.getNewsArticles()
                .doOnSuccess(localSource::saveArticles)
                .onErrorResumeNext(localSource.getArticles());
    }
}
