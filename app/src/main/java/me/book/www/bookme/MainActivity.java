package me.book.www.bookme;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    TextView titleTextView1;
    TextView categoryTextView1;
    TextView feelTextView1;
    TextView titleTextView2;
    TextView categoryTextView2;
    TextView feelTextView2;
    TextView titleTextView3;
    TextView categoryTextView3;
    TextView feelTextView3;
    TextView titleTextView4;
    TextView categoryTextView4;
    TextView feelTextView4;
    public static BooksDatabase database;
    private List<Book> books = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        titleTextView1 = findViewById(R.id.title_text_view1);
        categoryTextView1 = findViewById(R.id.category_text_view1);
        feelTextView1 = findViewById(R.id.feel_text_view1);
        titleTextView2 = findViewById(R.id.title_text_view2);
        categoryTextView2 = findViewById(R.id.category_text_view2);
        feelTextView2 = findViewById(R.id.feel_text_view2);
        titleTextView3 = findViewById(R.id.title_text_view3);
        categoryTextView3 = findViewById(R.id.category_text_view3);
        feelTextView3 = findViewById(R.id.feel_text_view3);
        titleTextView4 = findViewById(R.id.title_text_view4);
        categoryTextView4 = findViewById(R.id.category_text_view4);
        feelTextView4 = findViewById(R.id.feel_text_view4);

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
        books = database.bookDao().getBooksByFeel("pensive");
        titleTextView1.setText(books.get(0).title);
        categoryTextView1.setText(books.get(0).category);
        feelTextView1.setText(books.get(0).feel);

        books = database.bookDao().getBooksByCategory("life improvement");
        titleTextView2.setText(books.get(0).title);
        categoryTextView2.setText(books.get(0).category);
        feelTextView2.setText(books.get(0).feel);

        books = database.bookDao().getBooksByTitle("Meditations");
        titleTextView3.setText(books.get(0).title);
        categoryTextView3.setText(books.get(0).category);
        feelTextView3.setText(books.get(0).feel);

        books = database.bookDao().getBooksByYear(1946);
        titleTextView4.setText(books.get(0).title);
        categoryTextView4.setText(books.get(0).category);
        feelTextView4.setText(books.get(0).feel);
    }
}