package me.book.www.bookme;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "books")
public class Book {
    @PrimaryKey
    public int id;

    @ColumnInfo(name = "title")
    public String title;

    @ColumnInfo(name = "author")
    public String author;

    @ColumnInfo(name = "year")
    public int year;

    @ColumnInfo(name = "category")
    public String category;

    @ColumnInfo(name = "sub_categories")
    public String sub_categories;

    @ColumnInfo(name = "genre")
    public String genre;

    @ColumnInfo(name = "sub_genres")
    public String sub_genres;

    @ColumnInfo(name = "feel")
    public String feel;

    @ColumnInfo(name = "tags")
    public String tags;

    @ColumnInfo(name = "meta_rating")
    public double meta_rating;
}
