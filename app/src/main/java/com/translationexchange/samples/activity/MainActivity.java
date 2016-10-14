package com.translationexchange.samples.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.translationexchange.android.activities.TmlAndroidActivity;
import com.translationexchange.android.text.TmlContextWrapper;
import com.translationexchange.samples.R;
import com.translationexchange.samples.fragment.MainFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().add(android.R.id.content, new MainFragment(), "tag").commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            startActivity(new Intent(this, TmlAndroidActivity.class).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void attachBaseContext(Context newBase) {
        super.attachBaseContext(TmlContextWrapper.wrap(newBase));
    }
}
