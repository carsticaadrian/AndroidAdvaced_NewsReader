package com.carsticaadrian.data.features.news.local;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "articles")
public class ArticleEntity {

    @PrimaryKey(autoGenerate = true)
    @Nullable
    public int id;

    public String imageUrl;

    public String title;

    public String content;

    public String description;

    public ArticleEntity(@NonNull String imageUrl, @NonNull String title, @NonNull String content, @NonNull String description) {
        this.imageUrl = imageUrl;
        this.title = title;
        this.content = content;
        this.description = description;
    }

}
