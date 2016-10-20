package com.translationexchange.samples;

import android.app.Application;

import com.translationexchange.android.TmlAndroid;
import com.translationexchange.core.Utils;

/**
 * Created by ababenko on 10/6/16.
 */

public class SampleApplication extends Application {
    private static SampleApplication instance;

    public static synchronized SampleApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
//        TmlAndroid.getConfig().setApplication(Utils.buildMap(
////                "key", "3c78685670a8722b21ed098f1576f6b6673a3fe34dfa9590ffa523d47e3cb5f9", // iOS Demo prod
//                "key", "6668fdc0dba93366717e6521fede7d3dfff321f2dbc72e6a1c86cd1e77d086e0", // Android prod
//                "host", "https://api.translationexchange.com/",
//                "cdn_host", "https://cdn.translationexchange.com/",
//                "auth_url", "https://gateway.translationexchange.com"
//        ));

        TmlAndroid.getConfig().setApplication(Utils.buildMap(
                "key", "59b685270a0b60ac07f7c9cfd9c657377485f728df94e96973d285f13fdfd5be",
                "host", "https://sandbox-api.translationexchange.com/",
                "cdn_host", "https://cdn.translationexchange.com/",
                "auth_url", "https://sandbox-gateway.translationexchange.com"
        ));

        TmlAndroid.init(this, "20161007111605");
    }

}
