package com.carsticaadrian.newsreader;

import android.app.Application;

import com.carsticaadrian.data.di.RepoModule;

public class NewsApplication extends Application {

    //move along, will be replaced with Dagger later
    private static RepoModule repoModule;

    public static RepoModule getRepoProvider() {
        return repoModule;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        this.repoModule = new RepoModule(this);
    }
}
