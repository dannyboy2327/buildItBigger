package com.example.jokedisplay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;


public class JokeDisplay extends AppCompatActivity {

    public static final String LOG_TAG = JokeDisplay.class.getSimpleName();
    private  String joke = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_display);

        TextView textView = findViewById(R.id.tv_joke);

        Intent jokeIntent = getIntent();

        if (jokeIntent.hasExtra("joke")) {
            joke = jokeIntent.getStringExtra("joke");
            assert joke != null;
            Log.d(LOG_TAG, joke);
        }

        textView.setText(joke);

    }
}
