package com.carsticaadrian.newsreader.ui.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.carsticaadrian.newsreader.databinding.NewsListFragmentBinding;
import com.carsticaadrian.newsreader.model.NewsListViewModel;
import com.carsticaadrian.newsreader.model.ViewModelFactory;

public class NewsListFragment extends Fragment {

    private NewsListViewModel mViewModel;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ViewModelFactory factory = new ViewModelFactory();
        mViewModel = ViewModelProviders.of(requireActivity(), factory).get(NewsListViewModel.class);
        getLifecycle().addObserver(mViewModel);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {


        NewsListFragmentBinding binding = NewsListFragmentBinding.inflate(inflater, container, false);

        binding.setViewModel(mViewModel);

        return binding.getRoot();
    }


}