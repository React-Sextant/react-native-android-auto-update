package com.loveplusplus.update;

import junit.framework.Test;
import android.util.Log;

public class Constants {


    // json {"url":"http://192.168.205.33:8080/Hello/app_v3.0.1_Other_20150116.apk","versionCode":2,"updateMessage":"版本更新信息"}

    public static String APK_DOWNLOAD_URL = "url";
    void setAPK_DOWNLOAD_URL(String url){this.APK_DOWNLOAD_URL = url;}
    String getAPK_DOWNLOAD_URL(){ return this.APK_DOWNLOAD_URL; }

    public static String APK_UPDATE_CONTENT = "updateMessage";
    void setAPK_UPDATE_CONTENT(String arg){this.APK_UPDATE_CONTENT = arg;}
    String getAPK_UPDATE_CONTENT(){ return this.APK_UPDATE_CONTENT; }

    public static int TYPE_NOTIFICATION = 2;
    void setTYPE_NOTIFICATION(int arg){this.TYPE_NOTIFICATION = arg;}
    int getTYPE_NOTIFICATION(){ return this.TYPE_NOTIFICATION; }

    public static int TYPE_DIALOG = 1;
    void setTYPE_DIALOG(int arg){this.TYPE_DIALOG = arg;}
    int getTYPE_DIALOG(){ return this.TYPE_DIALOG; }

    public static String TAG = "UpdateChecker";
    void setTAG(String arg){this.TAG = arg;}
    String getTAG(){ return this.TAG; }

    public static String UPDATE_URL = "";
    void setUPDATE_URL(String arg){
        Log.e("set",arg);
        this.UPDATE_URL = arg;
    }
    String getUPDATE_URL(){
        Log.e("get",this.UPDATE_URL);
        return this.UPDATE_URL;
    }



    //APK_VERSION_CODE
    public static int APK_VERSION_CODE = 1;
    void setAPK_VERSION_CODE(int arg){this.APK_VERSION_CODE = arg;}
    int getAPK_VERSION_CODE(){ return this.APK_VERSION_CODE; }

}
