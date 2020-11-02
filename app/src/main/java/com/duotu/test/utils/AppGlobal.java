package com.duotu.test.utils;

import android.annotation.SuppressLint;
import android.app.Application;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * author : zhy
 * date   : 2020/11/1 19:57
 * desc   :
 */
public class AppGlobal {
    private static Application sApplication;

    public static Application getApplication() {
        if (null == sApplication) {
            try {
                sApplication = (Application) Class.forName("android.app.ActivityThread")
                        .getMethod("currentApplication")
                        .invoke(null, (Object[]) null);
            } catch (IllegalAccessException | InvocationTargetException | ClassNotFoundException | NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
        return sApplication;
    }
}
