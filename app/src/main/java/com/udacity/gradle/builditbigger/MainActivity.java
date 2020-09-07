package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.jokedisplay.JokeDisplay;
import com.example.jokeprovider.JokeProvider;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

public class MainActivity extends AppCompatActivity implements EndpointsAsyncTask.AsyncCallback {

    private EndpointsAsyncTask.AsyncCallback mAsyncCallback;
    private ProgressBar mProgressBar;
    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAsyncCallback = this;

        mProgressBar = findViewById(R.id.pb_loader);

        if (!com.udacity.gradle.builditbigger.BuildConfig.PAID_VERSION) {
            mInterstitialAd = new InterstitialAd(this);
            mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
            mInterstitialAd.loadAd(new AdRequest.Builder().build());
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view) {
        JokeProvider jokeProvider = new JokeProvider();
        String joke = jokeProvider.getJoke();
        Toast.makeText(this, joke, Toast.LENGTH_SHORT).show();
    }

    public void seeJoke(View view) {
        mProgressBar.setVisibility(View.VISIBLE);
        new EndpointsAsyncTask(mAsyncCallback).execute();
    }


    @Override
    public void onCompleteTask(final String joke) {
        if (!BuildConfig.PAID_VERSION) {
            if (mInterstitialAd.isLoaded()) {
                mProgressBar.setVisibility(View.INVISIBLE);
                mInterstitialAd.show();
                mInterstitialAd.setAdListener(new AdListener() {
                    @Override
                    public void onAdClosed() {
                        mInterstitialAd.loadAd(new AdRequest.Builder().build());
                        startIntent(joke);
                    }
                });
            }
        } else {
            mProgressBar.setVisibility(View.INVISIBLE);
            startIntent(joke);
        }
    }

        private void startIntent(String joke) {
            Intent intent = new Intent(MainActivity.this, JokeDisplay.class);
            intent.putExtra("joke", joke);
            startActivity(intent);
        }
}
