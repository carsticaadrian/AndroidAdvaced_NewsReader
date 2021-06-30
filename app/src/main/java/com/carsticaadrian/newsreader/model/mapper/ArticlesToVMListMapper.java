package com.carsticaadrian.newsreader.model.mapper;

import com.carsticaadrian.data.features.news.model.Article;
import com.carsticaadrian.newsreader.model.ArticleItemViewModel;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.functions.Function;


public class ArticlesToVMListMapper implements Function<List<Article>, List<ArticleItemViewModel>> {
    @Override
    public List<ArticleItemViewModel> apply(List<Article> articles) {
        List<ArticleItemViewModel> vmItems = new ArrayList<>();

        for (Article article : articles) {
            ArticleItemViewModel itemViewModel = new ArticleItemViewModel();
            itemViewModel.imgSrc.set(article.imageUrl);
            itemViewModel.content.set(article.content);
            itemViewModel.title.set(article.title);

            vmItems.add(itemViewModel);
        }

        return vmItems;
    }

}
