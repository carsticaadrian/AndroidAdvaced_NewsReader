package com.carsticaadrian.data.features.news.local;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.carsticaadrian.data.features.news.model.Article;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

@Dao
public interface ArticleDao {

    @Query("SELECT * FROM articles")
    Single<List<Article>> getArticles();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Completable saveArticles(List<ArticleEntity> news);


}
