package com.loveplusplus.update;

import junit.framework.Test;

public class Constants {

    // json {"url":"http://192.168.205.33:8080/Hello/app_v3.0.1_Other_20150116.apk","versionCode":2,"updateMessage":"版本更新信息"}

    String APK_DOWNLOAD_URL = "url";
    void setAPK_DOWNLOAD_URL(String url){this.APK_DOWNLOAD_URL = url;}
    String getAPK_DOWNLOAD_URL(){ return APK_DOWNLOAD_URL; }

    String APK_UPDATE_CONTENT = "updateMessage";
    void setAPK_UPDATE_CONTENT(String arg){this.APK_UPDATE_CONTENT = arg;}
    String getAPK_UPDATE_CONTENT(){ return APK_UPDATE_CONTENT; }

    String APK_VERSION_CODE = "versionCode";
    void setAPK_VERSION_CODE(String arg){this.APK_VERSION_CODE = arg;}
    String getAPK_VERSION_CODE(){ return APK_VERSION_CODE; }

    int TYPE_NOTIFICATION = 2;
    void setTYPE_NOTIFICATION(int arg){this.TYPE_NOTIFICATION = arg;}
    int getTYPE_NOTIFICATION(){ return TYPE_NOTIFICATION; }

    int TYPE_DIALOG = 1;
    void setTYPE_DIALOG(int arg){this.TYPE_DIALOG = arg;}
    int getTYPE_DIALOG(){ return TYPE_DIALOG; }

    String TAG = "UpdateChecker";
    void setTAG(String arg){this.TAG = arg;}
    String getTAG(){ return TAG; }

    String UPDATE_URL = "";
    void setUPDATE_URL(String arg){this.UPDATE_URL = arg;}
    String getUPDATE_URL(){ return UPDATE_URL; }

}
