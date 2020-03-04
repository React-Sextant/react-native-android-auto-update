package com.loveplusplus.update;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;

import java.util.HashMap;
import java.util.Map;

import constacne.UiType;
import model.UiConfig;
import model.UpdateConfig;
import update.UpdateAppUtils;


public class AndroidAutoUpdateModule extends ReactContextBaseJavaModule {

    private static ReactApplicationContext context;
    public AndroidAutoUpdateModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.context = reactContext;
    }

    @ReactMethod
    public void UpdateApp(ReadableMap map){
        String apkUrl = "";
        String updateTitle = "";
        String updateContent = "";

        if(map.hasKey("apkUrl")){
            apkUrl = map.getString("apkUrl");
        }
        if(map.hasKey("updateTitle")){
            updateTitle = map.getString("updateTitle");
        }
        if(map.hasKey("updateContent")){
            updateContent = map.getString("updateContent");
        }

        //updateConfig
        UpdateConfig updateConfig = new UpdateConfig();
        if(map.hasKey("force")){
            updateConfig.setForce(map.getBoolean("force"));
        }
        if(map.hasKey("needCheckMd5")){
            updateConfig.setNeedCheckMd5(map.getBoolean("needCheckMd5"));
        }
        if(map.hasKey("checkWifi")){
            updateConfig.setCheckWifi(map.getBoolean("checkWifi"));
        }
        if(map.hasKey("isShowNotification")){
            updateConfig.setShowNotification(map.getBoolean("isShowNotification"));
        }
        if(map.hasKey("serverVersionName")){
            updateConfig.setServerVersionName(map.getString("serverVersionName"));
        }
        if(map.hasKey("serverVersionCode")){
            updateConfig.setServerVersionCode(map.getInt("serverVersionCode"));
        }
        if(map.hasKey("alwaysShow")){
            updateConfig.setAlwaysShow(map.getBoolean("alwaysShow"));
        }
        if(map.hasKey("thisTimeShow")){
            updateConfig.setThisTimeShow(map.getBoolean("thisTimeShow"));
        }
        if(map.hasKey("alwaysShowDownLoadDialog")){
            updateConfig.setAlwaysShowDownLoadDialog(map.getBoolean("alwaysShowDownLoadDialog"));
        }
        if(map.hasKey("showDownloadingToast")){
            updateConfig.setShowDownloadingToast(map.getBoolean("showDownloadingToast"));
        }


        // uiConfig
        UiConfig uiConfig = new UiConfig();
        if(map.hasKey("uiType")){
            uiConfig.setUiType(map.getString("uiType"));

        }

        uiConfig.setUpdateLogoImgRes(context.getResources().getIdentifier("ic_launcher","mipmap",context.getPackageName()));

        // TODO: RN require() to getResourceId
        if(map.hasKey("updateLogoImgRes")){
            uiConfig.setUpdateLogoImgRes(map.getInt("updateLogoImgRes"));
        }


        UpdateAppUtils
                .getInstance()
                .apkUrl(apkUrl)
                .updateTitle(updateTitle)
                .updateContent(updateContent)
                .uiConfig(uiConfig)
                .updateConfig(updateConfig)
                .update();
    }

    @Override
    public Map<String, Object> getConstants() {
        final Map<String, Object> constants = new HashMap<>();
        constants.put("SIMPLE", UiType.SIMPLE);
        constants.put("PLENTIFUL", UiType.PLENTIFUL);
        constants.put("CUSTOM", UiType.CUSTOM);

        return constants;
    }

    @Override
    public String getName() {
        return "RNAndroidAutoUpdate";
    }
}
