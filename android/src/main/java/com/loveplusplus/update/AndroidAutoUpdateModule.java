package com.loveplusplus.update;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import android.app.Activity;
import android.content.Intent;

public class AndroidAutoUpdateModule extends ReactContextBaseJavaModule {

    public AndroidAutoUpdateModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @ReactMethod
    public void goToDownload (String url){
        final Activity activity = getCurrentActivity();
        Intent intent = new Intent(activity.getApplicationContext(), DownloadService.class);
        intent.putExtra("url", url);
        activity.startService(intent);
    }

    @Override
    public String getName() {
        return "RNAndroidAutoUpdate";
    }
}
