package com.translationexchange.samples.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.translationexchange.android.TmlAndroid;
import com.translationexchange.samples.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = (TextView) findViewById(R.id.text);
        textView.setText(TmlAndroid.translate("Hello world"));

        TextView textView1 = (TextView) findViewById(R.id.text1);
        textView1.setText(TmlAndroid.translate("hello, how are you?"));

        TextView textView2 = (TextView) findViewById(R.id.text2);
        textView2.setText(TmlAndroid.translate("Hello Mr!"));
    }
}
