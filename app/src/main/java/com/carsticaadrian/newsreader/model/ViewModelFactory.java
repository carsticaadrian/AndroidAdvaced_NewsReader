package com.carsticaadrian.newsreader.model;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.carsticaadrian.data.NewsRepository;
import com.carsticaadrian.newsreader.NewsApplication;

import org.jetbrains.annotations.NotNull;

public class ViewModelFactory implements ViewModelProvider.Factory {
    @NonNull
    @NotNull
    @Override
    public <T extends ViewModel> T create(@NonNull @NotNull Class<T> modelClass) {

        if (modelClass.isAssignableFrom(NewsListViewModel.class)) {
            NewsRepository repo = NewsApplication.getRepoProvider().provideNewsRepository();
            return (T) new NewsListViewModel(repo);
        }

        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
