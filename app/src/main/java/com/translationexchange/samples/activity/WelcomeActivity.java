package com.translationexchange.samples.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.translationexchange.android.TmlAndroid;
import com.translationexchange.android.activities.BaseActivity;
import com.translationexchange.android.activities.TmlAndroidActivity;
import com.translationexchange.android.interfaces.TmlAnnotation;
import com.translationexchange.android.utils.ViewUtils;
import com.translationexchange.core.Utils;
import com.translationexchange.samples.R;

public class WelcomeActivity extends BaseActivity {

    private Button button;
    private TextView textView;
    private TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        button = (Button) findViewById(R.id.btn_open_next);
        Button button1 = (Button) findViewById(R.id.btn_open_translator);
        textView = (TextView) findViewById(R.id.text);
        textView2 = (TextView) findViewById(R.id.text2);

        findViewById(R.id.btn_open_next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainIntent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(mainIntent);
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainIntent = new Intent(getApplicationContext(), TmlAndroidActivity.class);
                startActivity(mainIntent);
            }
        });

        initUi();
    }

    @TmlAnnotation
    @Override
    public void initUi() {
        TmlAndroid.translate(button, getText(R.string.open_next_activity).toString());

        textView.setText(TmlAndroid.translateSpannableString(
                "[style: Adjust fonts] using an attribute dictionary.",
                Utils.buildMap(
                        "style", Utils.buildMap(
                                "style", "bold")
                )
        ));

        textView2.setText(TmlAndroid.translateSpannableString(
                "[style: Adjust fonts] using an [typeface: attribute] dictionary.\nHello {user}. You have {count || message}.",
                Utils.buildMap("style",
                        Utils.buildMap(
                                "style", "italic",
                                "color", "red",
                                "size", ViewUtils.convertPixelsToSp(getApplicationContext(), 20)),
                        "typeface", Utils.buildMap("typeface", "sans-serif-thin"),
                        "user", "Alexander", "count", "5")
        ));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        TmlAndroid.destroy(getApplicationContext());
    }
}
