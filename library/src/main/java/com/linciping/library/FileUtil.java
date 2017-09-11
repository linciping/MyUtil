package com.linciping.library;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.support.v4.content.ContextCompat;

import com.linciping.library.exception.CreateFileException;
import com.linciping.library.exception.PermissionException;
import com.linciping.library.exception.SDCardNoFoundException;

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
     * @throws SDCardNoFoundException {@link SDCardNoFoundException}  sd卡不存在异常
     */
    public static String getDownloadPath() throws SDCardNoFoundException {
        if (isSdCardExist()) {
            return Environment.getDownloadCacheDirectory().getPath();
        }
        throw new SDCardNoFoundException();
    }

    /**
     * 获取系统下载根目录（回调接口的形式）
     *
     * @param fileController {@link FileController} 文件回调接口
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
     * @throws SDCardNoFoundException {@link SDCardNoFoundException}  sd卡不存在异常
     */
    public static String getSdCardPath() throws SDCardNoFoundException {
        if (isSdCardExist()) {
            return Environment.getExternalStorageDirectory().getPath();
        }
        throw new SDCardNoFoundException();
    }

    /**
     * 获取SD卡根目录（回调接口的形式）
     *
     * @param fileController {@link FileController} 文件回调接口
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
     * @throws SDCardNoFoundException {@link SDCardNoFoundException}  sd卡不存在异常
     * @throws CreateFileException    {@link CreateFileException}  创建文件异常
     * @throws PermissionException    {@link PermissionException} 权限异常
     */
    public static String getAppPath(Context context) throws SDCardNoFoundException, CreateFileException, PermissionException {
        String appPath = "";
        if (isSdCardExist()) {
            String sdCardPath = Environment.getExternalStorageDirectory().getPath();
            appPath = sdCardPath + File.separator + context.getPackageName();
            File file = new File(appPath);
            if (ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
                throw new PermissionException();
            } else if (!file.exists() && file.mkdir()) {
                return appPath;
            } else if (file.exists()) {
                return appPath;
            } else {
                throw new CreateFileException();
            }
        }
        throw new SDCardNoFoundException();
    }

    /**
     * 创建APP包名目录
     *
     * @param context        上下文对象
     * @param fileController {@link FileController} 文件回调接口
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
     * 创建APP图片目录
     *
     * @param context 上下文对象
     * @return 如果存在返回APP图片目录，不然返回SD卡不存在/创建目录失败
     * @throws SDCardNoFoundException {@link SDCardNoFoundException}  sd卡不存在异常
     * @throws CreateFileException    {@link CreateFileException}  创建文件异常
     * @throws PermissionException    {@link PermissionException} 权限异常
     */
    public static String getAppImagePath(Context context) throws CreateFileException, SDCardNoFoundException, PermissionException {
        return getAppDivPath(context, Constant.IMAGE_PATH);
    }

    /**
     * 创建APP文件目录
     *
     * @param context 上下文对象
     * @return 如果存在返回APP文件目录，不然返回SD卡不存在/创建目录失败
     * @throws SDCardNoFoundException {@link SDCardNoFoundException}  sd卡不存在异常
     * @throws CreateFileException    {@link CreateFileException}  创建文件异常
     * @throws PermissionException    {@link PermissionException} 权限异常
     */
    public static String getAppFilePath(Context context) throws CreateFileException, SDCardNoFoundException, PermissionException {
        return getAppDivPath(context, Constant.FILE_PATH);
    }

    /**
     * 创建APP视频目录
     *
     * @param context 上下文对象
     * @return 如果存在返回APP视频目录，不然返回SD卡不存在/创建目录失败
     * @throws SDCardNoFoundException {@link SDCardNoFoundException}  sd卡不存在异常
     * @throws CreateFileException    {@link CreateFileException}  创建文件异常
     * @throws PermissionException    {@link PermissionException} 权限异常
     */
    public static String getAppVideoPath(Context context) throws CreateFileException, SDCardNoFoundException, PermissionException {
        return getAppDivPath(context, Constant.VIDEO_PATH);
    }


    /**
     * 创建APP图片目录
     *
     * @param context        上下文对象
     * @param fileController 回调对象
     */
    public static void getAppImagePath(Context context, FileController fileController) {
        getAppDivPath(context, Constant.IMAGE_PATH, fileController);
    }

    /**
     * 创建APP文件目录
     *
     * @param context        上下文对象
     * @param fileController 回调对象
     */
    public static void getAppFilePath(Context context, FileController fileController) {
        getAppDivPath(context, Constant.FILE_PATH, fileController);
    }

    /**
     * 创建APP视频目录
     *
     * @param context        上下文对象
     * @param fileController 回调对象
     */
    public static void getAppVideoPath(Context context, FileController fileController) {
        getAppDivPath(context, Constant.VIDEO_PATH, fileController);
    }

    /**
     * 创建APP自定义功能目录(回调接口)
     *
     * @param context        上下文对象
     * @param name           自定义文件名
     * @param fileController 回调对象
     */
    public static void getAppDivPath(Context context, String name, FileController fileController) {
        int result = isAppPath(context);
        switch (result) {
            case MessageKeyConstant.SUCCESS:
                String sdCardPath = Environment.getExternalStorageDirectory().getPath();
                String appPath = sdCardPath + File.separator + context.getPackageName();
                String appDiyPath = appPath + File.separator + name;
                File imageDir = new File(appDiyPath);
                if (imageDir.exists()) {
                    fileController.onPath(appDiyPath);
                } else if (imageDir.mkdir()) {
                    fileController.onPath(appDiyPath);
                } else {
                    fileController.onFailed(CREATE_FILE_ERROR);
                }
            case MessageKeyConstant.CREATE_FILE_ERROR:
                fileController.onFailed(CREATE_FILE_ERROR);
            case MessageKeyConstant.PERMISSION_NO_ALLOW:
                fileController.onFailed(PERMISSION_NO_ALLOW);
            case MessageKeyConstant.SDCARD_NO_EXIST:
                fileController.onFailed(SDCARD_NO_EXIST);
            default:
                fileController.onFailed(SDCARD_NO_EXIST);
        }
    }


    /**
     * 创建APP自定义功能目录
     *
     * @param context 上下文对象
     * @param name    自定义文件名
     * @return 如果存在返回APP自定义功能目录，不然返回SD卡不存在/创建目录失败
     * @throws SDCardNoFoundException {@link SDCardNoFoundException}  sd卡不存在异常
     * @throws CreateFileException    {@link CreateFileException}  创建文件异常
     * @throws PermissionException    {@link PermissionException} 权限异常
     */
    public static String getAppDivPath(Context context, String name) throws CreateFileException, SDCardNoFoundException, PermissionException {
        int result = isAppPath(context);
        switch (result) {
            case MessageKeyConstant.SUCCESS:
                String sdCardPath = Environment.getExternalStorageDirectory().getPath();
                String appPath = sdCardPath + File.separator + context.getPackageName();
                String appImagePath = appPath + File.separator + name;
                File imageDir = new File(appImagePath);
                if (imageDir.exists()) {
                    return appImagePath;
                } else if (imageDir.mkdir()) {
                    return appImagePath;
                } else {
                    throw new CreateFileException();
                }
            case MessageKeyConstant.CREATE_FILE_ERROR:
                throw new CreateFileException();
            case MessageKeyConstant.PERMISSION_NO_ALLOW:
                throw new PermissionException();
            case MessageKeyConstant.SDCARD_NO_EXIST:
                throw new SDCardNoFoundException();
            default:
                throw new SDCardNoFoundException();
        }
    }


    /**
     * 判断APP包名目录包名目录是否存在,如果不存在，则创建
     *
     * @param context 上下文对象
     * @return {@link MessageKeyConstant}
     */
    public static int isAppPath(Context context) {
        String appPath = "";
        if (isSdCardExist()) {
            String sdCardPath = Environment.getExternalStorageDirectory().getPath();
            appPath = sdCardPath + File.separator + context.getPackageName();
            File file = new File(appPath);
            if (ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_DENIED) {
                return MessageKeyConstant.PERMISSION_NO_ALLOW;
            } else if (!file.exists() && file.mkdir()) {
                return MessageKeyConstant.SUCCESS;
            } else if (file.exists()) {
                return MessageKeyConstant.SUCCESS;
            } else {
                return MessageKeyConstant.CREATE_FILE_ERROR;
            }
        } else {
            return MessageKeyConstant.SDCARD_NO_EXIST;
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
