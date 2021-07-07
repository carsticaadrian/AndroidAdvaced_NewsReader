package com.carsticaadrian.data.di;

import android.app.Application;
import android.content.Context;

import androidx.room.Room;

import com.carsticaadrian.data.NewsRepository;
import com.carsticaadrian.data.features.news.NewsRepositoryImpl;
import com.carsticaadrian.data.features.news.local.NewsLocalSource;
import com.carsticaadrian.data.features.news.local.store.NewsDataBase;
import com.carsticaadrian.data.features.news.remote.NewsRemoteSource;
import com.carsticaadrian.data.remote.HttpClientFactory;

import io.reactivex.annotations.NonNull;

public class RepoModule {
    @NonNull
    private Context context;
    @NonNull
    private HttpClientFactory httpClientFactory;

    private volatile NewsDataBase database;


    public RepoModule(@NonNull Application application) {
        this.context = application.getApplicationContext();
        this.httpClientFactory = new HttpClientFactory();
    }

    public NewsRepository provideNewsRepository() {
        return new NewsRepositoryImpl(provideNewsRemoteSource(), provideNewsLocalSource());
    }

    private NewsRemoteSource provideNewsRemoteSource() {
        return new NewsRemoteSource(httpClientFactory.getNewsApi());
    }

    private NewsLocalSource provideNewsLocalSource() {
        NewsDataBase database = getInstance();
        return new NewsLocalSource(database.newsDao());
    }

    NewsDataBase getInstance() {
        if (database == null) {
            synchronized (NewsDataBase.class) {
                if (database == null) {
                    database = Room.databaseBuilder(context.getApplicationContext(),
                            NewsDataBase.class, "News.db")
                            .build();
                }
            }
        }
        return database;
    }

}
