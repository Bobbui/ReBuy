package com.example.rebuytest.utils;

import android.os.Handler;

/**
 * @author Baominyang
 * @Date 2019/3/28
 */

public class ThreadUtils {
    /**子线程执行task*/
    public static void runInThread(Runnable task) {
        new Thread(task).start();
    }

    /**
     * 主线程里的一个 Handler
     */
    public static Handler mHandler = new Handler();

    /**UI线程执行Task*/
    public static void runInUIThread(Runnable task) {
        mHandler.post(task);
    }

}
