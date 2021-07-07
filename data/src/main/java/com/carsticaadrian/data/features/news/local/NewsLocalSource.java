package com.carsticaadrian.data.features.news.local;

import com.carsticaadrian.data.ArticlesToEntitiesMapper;
import com.carsticaadrian.data.features.news.model.Article;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

public class NewsLocalSource {

    private ArticleDao dao;

    public NewsLocalSource(ArticleDao dao) {
        this.dao = dao;
    }

    public Single<List<Article>> getArticles() {
        return dao.getArticles();
    }

    public void saveArticles(List<Article> news) {
        Single.just(news)
                .subscribeOn(Schedulers.io())
                .map(new ArticlesToEntitiesMapper())
                .flatMapCompletable(entities -> dao.saveArticles(entities))
                .subscribe();

    }
}
