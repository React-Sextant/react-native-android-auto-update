package com.loveplusplus.update;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;


/**
 * @author feicien (ithcheng@gmail.com)
 * @since 2016-07-05 19:21
 */
class CheckUpdateTask extends AsyncTask<Void, Void, String> {

    private ProgressDialog dialog;
    private Context mContext;
    private int mType;
    private boolean mShowProgressDialog;
    private static final String url = new Constants().getUPDATE_URL();
    private static final String updateMessage = new Constants().getAPK_UPDATE_CONTENT();

    CheckUpdateTask(Context context, int type, boolean showProgressDialog) {

        this.mContext = context;
        this.mType = type;
        this.mShowProgressDialog = showProgressDialog;

    }


    protected void onPreExecute() {
        if (mShowProgressDialog) {
            dialog = new ProgressDialog(mContext);
            dialog.setMessage(mContext.getString(R.string.android_auto_update_dialog_checking));
            dialog.show();
        }
    }


    @Override
    protected void onPostExecute(String result) {

        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }

        if (!TextUtils.isEmpty(result)) {
            Log.e("onPostExecute",result);
            parseJson();
        }
    }

    private void parseJson() {
        if (mType == new Constants().getTYPE_NOTIFICATION()) {
            new NotificationHelper(mContext).showNotification(updateMessage, url);
        } else if (mType == new Constants().getTYPE_DIALOG()) {
            showDialog(mContext, updateMessage, url);
        }
    }


    /**
     * Show dialog
     */
    private void showDialog(Context context, String content, String apkUrl) {
        UpdateDialog.show(context, content, apkUrl);
    }


    @Override
    protected String doInBackground(Void... args) {
        return HttpUtils.get(url);
    }
}
