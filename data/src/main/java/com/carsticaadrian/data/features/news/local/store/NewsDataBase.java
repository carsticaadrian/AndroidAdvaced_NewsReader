package com.carsticaadrian.data.features.news.local.store;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.carsticaadrian.data.features.news.local.ArticleDao;
import com.carsticaadrian.data.features.news.local.ArticleEntity;

@Database(entities = {ArticleEntity.class}, version = 1)
public abstract class NewsDataBase extends RoomDatabase {

    public abstract ArticleDao newsDao();

}
