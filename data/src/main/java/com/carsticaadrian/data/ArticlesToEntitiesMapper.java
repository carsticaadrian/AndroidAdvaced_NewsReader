package com.carsticaadrian.data;

import com.carsticaadrian.data.features.news.local.ArticleEntity;
import com.carsticaadrian.data.features.news.model.Article;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.functions.Function;

public class ArticlesToEntitiesMapper implements Function<List<Article>, List<ArticleEntity>> {

    @Override
    public List<ArticleEntity> apply(List<Article> articleList) {
        List<ArticleEntity> articles = new ArrayList<>();

        for (Article article : articleList) {
            ArticleEntity entity = new ArticleEntity(
                    article.imageUrl != null ? article.imageUrl : "", //Adding default values for business model
                    article.title != null ? article.title : "",
                    article.content != null ? article.content : "",
                    article.description != null ? article.description : ""
            );

            articles.add(entity);
        }

        return articles;
    }
}
