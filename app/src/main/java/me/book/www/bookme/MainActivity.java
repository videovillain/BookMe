package me.book.www.bookme;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    TextView titleTextView;
    TextView categoryTextView;
    TextView feelTextView;
    public static BooksDatabase database;
    private List<Book> books = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        titleTextView = findViewById(R.id.title_text_view);
        categoryTextView = findViewById(R.id.category_text_view);
        feelTextView = findViewById(R.id.feel_text_view);

        // Have Room make the database!
        database = Room.databaseBuilder(getApplicationContext(), BooksDatabase.class, "books")
                .allowMainThreadQueries()
                .build();

        // currently manually populating with some preset values
        database.bookDao().create("Meditations","Marcus Aurelius",180,
                "finding meaning","life improvement",
                "non-fiction","stoicism, passive, digestible",
                "happy","relationships, friendships, work, personal, spiritual, nature", 10.00);

        database.bookDao().create("Man's Search for Meaning","Viktor E. Frankl",1946,
                "finding meaning","new perspectives",
                "non-fiction","logotherapy, passive, digestible",
                "sad","relationships, friendships, personal", 10.00);

        database.bookDao().create("Ishmael","Daniel Quinn",1992,
                "new perspectives","",
                "fiction","digestible",
                "pensive","nature, spirituality", 9.5);

        database.bookDao().create("The Subtle Art of Not Giving a Fuck","Mark Manson",2016,
                "life improvement","new perspectives",
                "self-help","active, instructional",
                "anxious","relationships, friendships, work, personal", 9.0);

        // checking to see if some of the SQL in the Dao work and database is working right
        books = database.bookDao().getAllBooks();
        titleTextView.setText(books.get(0).title);
        categoryTextView.setText(books.get(0).category);
        feelTextView.setText(books.get(0).feel);
    }
}