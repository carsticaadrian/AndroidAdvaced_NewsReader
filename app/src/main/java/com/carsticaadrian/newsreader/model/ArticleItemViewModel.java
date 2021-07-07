package com.carsticaadrian.newsreader.model;

import androidx.annotation.Nullable;
import androidx.databinding.ObservableField;

public class ArticleItemViewModel {

    public final ObservableField<String> title;
    public final ObservableField<String> content;
    public final ObservableField<String> imgSrc;
    @Nullable
    public Integer id;

    public ArticleItemViewModel() {
        title = new ObservableField<>();
        content = new ObservableField<>();
        imgSrc = new ObservableField<>();
    }


}
