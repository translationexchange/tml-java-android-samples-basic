package com.translationexchange.samples.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.Menu;
import android.view.MenuItem;

import com.translationexchange.android.activities.BaseActivity;
import com.translationexchange.android.text.TmlContextWrapper;
import com.translationexchange.samples.R;
import com.translationexchange.samples.fragment.MainFragment;

public abstract class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        enableBackButton(true);
        if (savedInstanceState == null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().add(android.R.id.content, new MainFragment(), "tag").commit();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void attachBaseContext(Context newBase) {
        super.attachBaseContext(TmlContextWrapper.wrap(newBase));
    }
}
