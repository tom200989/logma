package com.logma.logma.tool;

import android.content.Context;
import android.util.Log;

/* 操作类 */
public class Logg {

    public static Context context;// 用于兼容android Q  - 在application进行初始化
    private static Thread logThread;// 写出日志的线程

    private static int VERBOSE = 1;
    private static int DEBUG = 2;
    private static int INFO = 3;
    private static int WARN = 4;
    private static int ERROR = 5;
    private static int ASSERT = 6;

    private static int SHOW_ALL = 7;// 全部打开
    private static int STOP_ALL = 0;// 全部关闭

    private static int LOG_FLAG = SHOW_ALL;/* 日志开关 */
    private static String tag;
    private static Logg logs;

    public Logg() {
    }

    public static Logg t(String tag) {
        Logg.tag = tag;
        if (logs == null) {
            synchronized (Logg.class) {
                if (logs == null) {
                    logs = new Logg();
                }
            }
        }
        return logs;
    }

    public Logg openClose(boolean printTag) {
        LOG_FLAG = printTag ? SHOW_ALL : STOP_ALL;
        return this;
    }

    public void vv(String msg) {
        if (VERBOSE < LOG_FLAG) {
            Log.v(tag, msg);
        }
    }

    public static void v(String tag, String msg) {
        if (VERBOSE < LOG_FLAG) {
            Log.v(tag, msg);
        }
    }

    public void dd(String msg) {
        if (DEBUG < LOG_FLAG) {
            Log.d(tag, msg);
        }
    }

    public static void d(String tag, String msg) {
        if (DEBUG < LOG_FLAG) {
            Log.d(tag, msg);
        }
    }

    public void ii(String msg) {
        if (INFO < LOG_FLAG) {
            Log.i(tag, msg);
        }
    }

    public static void i(String tag, String msg) {
        if (INFO < LOG_FLAG) {
            Log.i(tag, msg);
        }
    }

    public void ww(String msg) {
        if (WARN < LOG_FLAG) {
            Log.w(tag, msg);
        }
    }

    public static void w(String tag, String msg) {
        if (WARN < LOG_FLAG) {
            Log.w(tag, msg);
        }
    }

    public void ee(String msg) {
        if (ERROR < LOG_FLAG) {
            Log.e(tag, msg);
        }
    }

    public static void e(String tag, String msg) {
        if (ERROR < LOG_FLAG) {
            Log.e(tag, msg);
        }
    }

    /**
     * 开启线程记录(在APPLICATION:ONCREATE中使用)
     */
    public static void startRecordLog(Context cts) {
        context = cts;
        if (logThread == null) {
            logThread = new LogThread(cts);
            logThread.start();
        }
    }

    /**
     * 停止线程记录(在退出APP:ONDESTROY使用)
     */
    public static void stopRecordLog() {
        if (logThread != null) {
            // 先停止循环, 再中断线程
            LogThread.killLoop();
            logThread.interrupt();
            logThread = null;
        }
    }

    /**
     * 写入SD卡
     *
     * @param content 待写入的内容
     */
    public static void writeToSD(String content) {
        if (logThread != null) {
            LogThread.addContentToList(content);
        }
    }

    /**
     * 在首次安装首次运行首次登陆时启用
     */
    public static void createdLogDir() {
        if (logThread != null) {
            LogThread.createdLogDirOut(context);
        }
    }

}
