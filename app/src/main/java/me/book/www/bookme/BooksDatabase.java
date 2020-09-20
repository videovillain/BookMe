package me.book.www.bookme;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Book.class}, version = 1)
public abstract class BooksDatabase extends RoomDatabase {
    public abstract BookDao bookDao();
}