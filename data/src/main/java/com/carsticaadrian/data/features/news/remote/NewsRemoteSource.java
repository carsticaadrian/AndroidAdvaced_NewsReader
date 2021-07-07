package com.carsticaadrian.data.features.news.remote;

import com.carsticaadrian.data.features.news.model.Article;
import com.carsticaadrian.data.features.news.remote.mapper.NewsDtoToNewsMapper;
import com.carsticaadrian.data.remote.NewsApi;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.annotations.NonNull;
import io.reactivex.schedulers.Schedulers;

public class NewsRemoteSource {

    //Don't copy this api key, use your own by registering here https://newsapi.org/register
    private static final String API_KEY = "7c5e1cff043a4699baa78bc8a396c847";
    private static final String EN_LANGUAGE_FILTER = "en";
    @NonNull
    private final NewsApi newsApi;

    public NewsRemoteSource(NewsApi newsApi) {
        this.newsApi = newsApi;
    }

    public Single<List<Article>> getNewsArticles() {
        return newsApi.getNewsArticles(API_KEY, EN_LANGUAGE_FILTER)
                .map(new NewsDtoToNewsMapper())
                .subscribeOn(Schedulers.io());
    }
}
