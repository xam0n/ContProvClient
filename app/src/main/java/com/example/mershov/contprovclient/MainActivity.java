package com.example.mershov.contprovclient;

import android.database.Cursor;
import android.net.Uri;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    final String LOG_TAG = "myLogs";

    final Uri GAMES_URI = Uri
            .parse("content://com.example.mershov.contentprov/games");

    final String GAME_NAME = "name";
    final String GAME_PRICE = "price";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Cursor cursor = getContentResolver().query(GAMES_URI, null, null, null, null);
        startManagingCursor(cursor);
        String[] from = {GAME_NAME, GAME_PRICE};
        int[] to = {android.R.id.text1, android.R.id.text2};
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_2, cursor, from, to, 0);

        ListView lvGames = (ListView) findViewById(R.id.lvGames);
        lvGames.setAdapter(adapter);
    }
}
