package com.carsticaadrian.data;

import androidx.annotation.NonNull;

import com.carsticaadrian.data.features.news.model.Article;

import java.util.List;

import io.reactivex.Single;

public interface NewsRepository {

    @NonNull
    Single<List<Article>> getNewsArticles();
}
