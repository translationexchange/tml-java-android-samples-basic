package com.translationexchange.samples.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.translationexchange.android.TmlAndroid;
import com.translationexchange.android.activities.OptionActivity;
import com.translationexchange.android.interfaces.TmlAnnotation;
import com.translationexchange.core.TmlMode;
import com.translationexchange.core.Utils;
import com.translationexchange.samples.R;

public class SplashActivity extends AppCompatActivity {

    private Button button;
    private Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        TmlAndroid.getConfig().setApplication(Utils.buildMap(
                "key", "59b685270a0b60ac07f7c9cfd9c657377485f728df94e96973d285f13fdfd5be",
                "host", "https://sandbox-api.translationexchange.com/",
                "cdn_host", "https://cdn.translationexchange.com/",
                "auth_url", "https://sandbox-gateway.translationexchange.com"
        ));

        TmlAndroid.init(this, TmlMode.CDN, "20160825154951");

        button = (Button) findViewById(R.id.btn_open_next);
        button1 = (Button) findViewById(R.id.btn_open_translator);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainIntent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(mainIntent);
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainIntent = new Intent(getApplicationContext(), OptionActivity.class);
                startActivity(mainIntent);
            }
        });

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE}, 100);
//        } else {
//            startInit();
        }

        updateUi();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        TmlAndroid.destroy(this);
    }

    @TmlAnnotation
    public void updateUi() {
        button.setText(TmlAndroid.translate("Open Next Activity"));
        button1.setText(TmlAndroid.translate("Translator"));
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//        if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//            startInit();
//        }
    }
}
