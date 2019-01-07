package com.loveplusplus.update;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

public class UpdateChecker {


    public static void checkForDialog(Context context) {
        if (context != null) {
            new CheckUpdateTask(context,new Constants().getTYPE_DIALOG(), true).execute();
        } else {
            Toast.makeText(context, "The arg context is null", Toast.LENGTH_SHORT).show();
            Log.e(new Constants().getTAG(), "The arg context is null");
        }
    }


    public static void checkForNotification(Context context) {
        if (context != null) {
            new CheckUpdateTask(context, new Constants().getTYPE_NOTIFICATION(), false).execute();
        } else {
            Toast.makeText(context, "The arg context is null", Toast.LENGTH_SHORT).show();
            Log.e(new Constants().getTAG(), "The arg context is null");
        }

    }


}
