package me.book.www.bookme;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

@Dao
public interface BookDao {
    @Query("SELECT * FROM books")
    List<Book> getAllBooks();

    @Query("SELECT * FROM books WHERE title = :title")
    List<Book> getBooksByTitle(String title);

    @Query("SELECT * FROM books WHERE author = :author")
    List<Book> getBooksByAuthor(String author);

    @Query("SELECT * FROM books WHERE year = :year")
    List<Book> getBooksByYear(int year);

    @Query("SELECT * FROM books WHERE category = :category")
    List<Book> getBooksByCategory(String category);

    @Query("SELECT * FROM books WHERE sub_categories LIKE :sub_categories")
    List<Book> getBooksBySubCategories(String sub_categories);

    @Query("SELECT * FROM books WHERE genre = :genre")
    List<Book> getBooksByGenre(String genre);

    @Query("SELECT * FROM books WHERE sub_genres LIKE :sub_genres")
    List<Book> getBooksBySubGenres(String sub_genres);

    @Query("SELECT * FROM books WHERE feel = :feel")
    List<Book> getBooksByFeel(String feel);

    @Query("SELECT * FROM books WHERE tags LIKE :tags")
    List<Book> getBooksByTags(String tags);

    @Query("SELECT * FROM books WHERE meta_rating = :meta_rating")
    List<Book> getBooksByMetaRating(double meta_rating);

    @Query("INSERT INTO books (title, author, year, category, sub_categories, genre, sub_genres, feel, tags, meta_rating) " +
            "Values (:title, :author, :year, :category, :sub_categories, :genre, :sub_genres, :feel, :tags, :meta_rating)")
    void create(String title, String author, int year, String category, String sub_categories, String genre, String sub_genres, String feel, String tags, double meta_rating);

    // NO LONGER NECESSARY FOR THIS APP
    /*@Query("INSERT INTO books (category, genre, sub_genre, feel, year, title, author, meta_rating) Values (:category, :genre, :sub_genre, :feel, :year, :title, :author, :meta_rating)")
    void create(String category, String genre, String sub_genre, String feel, int year, String title, String author, double meta_rating);

    @Query("UPDATE books SET title = :title WHERE id = :id")
    void save(String title, int id);

    @Query("DELETE FROM books WHERE id = :id")
    void delete(int id);*/
}
