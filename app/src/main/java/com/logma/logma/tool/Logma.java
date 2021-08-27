package com.logma.logma.tool;

import android.annotation.SuppressLint;
import android.content.Context;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * 代理类
 */
public class Logma {
    public static String dir_name = "ma_pudu";

    // 设置文件夹名
    public static void set_dir_name(String name) {
        dir_name = name;
    }

    public static void init(Context context) {
        Logg.startRecordLog(context);
    }

    public static void stop() {
        Logg.stopRecordLog();
    }

    public static void v(String tag, String msg) {
        Logg.i(tag, msg);
    }

    public static void vsd(String tag, String msg) {
        Logg.v(tag, msg);
        Logg.writeToSD(formatter(msg));
    }

    public static void i(String tag, String msg) {
        Logg.i(tag, msg);
    }

    public static void isd(String tag, String msg) {
        Logg.i(tag, msg);
        Logg.writeToSD(formatter(msg));
    }

    public static void w(String tag, String msg) {
        Logg.i(tag, msg);
    }

    public static void wsd(String tag, String msg) {
        Logg.w(tag, msg);
        Logg.writeToSD(formatter(msg));
    }

    public static void e(String tag, String msg) {
        Logg.i(tag, msg);
    }

    public static void esd(String tag, String msg) {
        Logg.i(tag, msg);
        Logg.writeToSD(formatter(msg));
    }

    @SuppressLint("SimpleDateFormat")
    public static String formatter(String msg) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        String format = formatter.format(new Date());
        StringBuffer buffer = new StringBuffer();
        buffer.append("\n").append("----------------------------------------").append("\n");
        buffer.append(format).append("-> ").append(msg);
        return buffer.toString();
    }
}
