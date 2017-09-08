package com.linciping.library;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.support.v4.content.ContextCompat;

import java.io.File;

import static com.linciping.library.MessageConstant.*;

/**
 * @author linciping
 *         2017/9/8
 *         文件工具
 */
public class FileUtil {

    /**
     * 获取系统下载根目录
     *
     * @return 如果存在返回系统下载根目录，不然返回SD卡不存在
     */
    public static String getDownloadPath() {
        if (isSdCardExist()) {
            return Environment.getDownloadCacheDirectory().getPath();
        }
        return SDCARD_NO_EXIST;
    }

    /**
     * 获取系统下载根目录（回调接口的形式）
     *
     * @param fileController 文件回调接口
     */
    public static void getDownloadPath(FileController fileController) {
        if (isSdCardExist()) {
            fileController.onPath(Environment.getDownloadCacheDirectory().getPath());
        } else {
            fileController.onFailed(SDCARD_NO_EXIST);
        }
    }

    /**
     * 获取SD卡根目录
     *
     * @return 如果存在返回SD卡根目录，不然返回SD卡不存在
     */
    public static String getSdCardPath() {
        if (isSdCardExist()) {
            return Environment.getExternalStorageDirectory().getPath();
        }
        return SDCARD_NO_EXIST;
    }

    /**
     * 获取SD卡根目录（回调接口的形式）
     *
     * @param fileController 文件回调接口
     */
    public static void getSdCardPath(FileController fileController) {
        if (isSdCardExist()) {
            fileController.onPath(Environment.getExternalStorageDirectory().getPath());
        } else {
            fileController.onFailed(SDCARD_NO_EXIST);
        }
    }

    /**
     * 创建APP包名目录
     *
     * @param context 上下文对象
     * @return 如果存在返回APP包名目录，不然返回SD卡不存在/创建目录失败
     */
    public static String getAppPath(Context context) {
        String appPath = "";
        if (isSdCardExist()) {
            String sdCardPath = Environment.getExternalStorageDirectory().getPath();
            appPath = sdCardPath + File.separator + context.getPackageName();
            File file = new File(appPath);
            if (ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
                return PERMISSION_NO_ALLOW;
            } else if (!file.exists() && file.mkdir()) {
                return appPath;
            } else if (file.exists()) {
                return appPath;
            } else {
                return CREATE_FILE_ERROR;
            }
        }
        return SDCARD_NO_EXIST;
    }

    /**
     * 创建APP包名目录
     *
     * @param context        上下文对象
     * @param fileController 文件回调接口
     */
    public static void getAppPath(Context context, FileController fileController) {
        String appPath = "";
        if (isSdCardExist()) {
            String sdCardPath = Environment.getExternalStorageDirectory().getPath();
            appPath = sdCardPath + File.separator + context.getPackageName();
            File file = new File(appPath);
            if (ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
                fileController.onFailed(PERMISSION_NO_ALLOW);
            } else if (!file.exists() && file.mkdir()) {
                fileController.onPath(appPath);
            } else if (file.exists()) {
                fileController.onPath(appPath);
            } else {
                fileController.onFailed(CREATE_FILE_ERROR);
            }
        } else {
            fileController.onFailed(SDCARD_NO_EXIST);
        }
    }

    /**
     * 判断APP包名目录包名目录是否存在,如果不存在，则创建
     * @param context 上下文对象
     * @return 如果存在或创建成功返回true，不然返回false;
     */
    public static boolean isAppPath(Context context){
        String appPath = "";
        if (isSdCardExist()) {
            String sdCardPath = Environment.getExternalStorageDirectory().getPath();
            appPath = sdCardPath + File.separator + context.getPackageName();
            File file = new File(appPath);
            return ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_DENIED
                    && (!file.exists() && file.mkdir() || file.exists());
        } else {
            return false;
        }
    }

    /**
     * 判断SDCard是否存在 [当没有外挂SD卡时，内置ROM也被识别为存在sd卡]
     *
     * @return 如果存在返回true, 不然返回false
     */
    public static boolean isSdCardExist() {
        return Environment.getExternalStorageState().equals(
                Environment.MEDIA_MOUNTED);
    }
}
