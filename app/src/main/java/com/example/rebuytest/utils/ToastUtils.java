package com.example.rebuytest.utils;

import android.content.Context;
import android.widget.Toast;

public class ToastUtils {

    /**
     * 可以在子线程中弹出 Toast
     * @param context
     * @param msg
     */

    public static void showToast(final Context context, final String msg) {
        ThreadUtils.runInUIThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
