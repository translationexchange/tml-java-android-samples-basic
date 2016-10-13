package com.translationexchange.samples.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.TextView;

import com.translationexchange.android.activities.BaseActivity;
import com.translationexchange.samples.ExampleContent;
import com.translationexchange.samples.R;
import com.translationexchange.samples.fragment.ViewExampleFragment;

public class ViewExampleActivity extends BaseActivity {

    public static void openExample(Context context, int position) {
        Intent intent = new Intent(context, ViewExampleActivity.class);
        intent.putExtra(ViewExampleFragment.ARG_POSITION, position);
        context.startActivity(intent);
    }

    private TextView pageIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_example);
        enableBackButton(true);
        Bundle bundle = getIntent().getExtras();
        int position = bundle == null ? 0 : bundle.getInt(ViewExampleFragment.ARG_POSITION, 0);
        pageIndicator = (TextView) findViewById(R.id.text_indicator);
        pageIndicator.setText((position + 1) + "/" + ExampleContent.ITEMS.size());
        ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        viewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                pageIndicator.setText((position + 1) + "/" + ExampleContent.ITEMS.size());
            }
        });
        ScreenSlidePagerAdapter pagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);
        viewPager.setCurrentItem(position);
    }

    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return ViewExampleFragment.newInstance(position);
        }

        @Override
        public int getCount() {
            return ExampleContent.ITEMS.size();
        }
    }
}
