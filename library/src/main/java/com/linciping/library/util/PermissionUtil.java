package com.linciping.library.util;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;

/**
 * @author linciping
 * @time 2017/9/13
 * @note 权限工具
 */
public class PermissionUtil {

    private static final int PERMISSION_REQUEST = 10001;

    /**
     * 查看是否拥有读取外部存储器的权限
     *
     * @param activity activity对象
     * @return 如果拥有权限返回true, 不然返回false，并且申请权限
     */
    public static boolean checkReadStoragePermission(Activity activity) {
        return checkPermission(activity, Manifest.permission.READ_EXTERNAL_STORAGE);
    }

    /**
     * 查看是否拥有写入外部存储器的权限
     *
     * @param activity activity对象
     * @return 如果拥有权限返回true, 不然返回false，并且申请权限
     */
    public static boolean checkWriteStoragePermission(Activity activity) {
        return checkPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE);
    }

    /**
     * 查看是否拥有电话权限
     *
     * @param activity activity对象
     * @return 如果拥有权限返回true, 不然返回false，并且申请权限
     */
    public static boolean checkPhonePermission(Activity activity) {
        return checkPermission(activity, Manifest.permission.CALL_PHONE);
    }

    /**
     * 查看是否拥有相机权限
     *
     * @param activity activity对象
     * @return 如果拥有权限返回true, 不然返回false，并且申请权限
     */
    public static boolean checkCameraPermission(Activity activity) {
        return checkPermission(activity, Manifest.permission.CAMERA);
    }


    /**
     * 检查权限
     *
     * @param context    上下文对象
     * @param permission 需要检查的权限
     * @return 如果拥有权限返回true, 不然返回false
     */
    public static boolean checkPermission(Context context, String permission) {
        return CheckUtil.havePermission(context, permission);
    }

    /**
     * 检查权限
     *
     * @param context     上下文对象
     * @param permissions 需要检查的权限
     * @return 如果拥有权限返回true, 不然返回false
     */
    public static boolean checkPermission(Context context, String[] permissions) {
        for (String permission : permissions) {
            if (!CheckUtil.havePermission(context, permission)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 检查权限
     *
     * @param activity   activity对象
     * @param permission 需要检查的权限
     * @return 如果拥有权限返回true, 不然返回false，并且申请权限
     */
    public static boolean checkPermission(Activity activity, String permission) {
        if (!CheckUtil.havePermission(activity, permission)) {
            requestPermission(activity, permission);
            return false;
        }
        return true;
    }

    /**
     * 检查权限
     *
     * @param activity    activity对象
     * @param permissions 需要检查的权限
     * @return 如果拥有权限返回true, 不然返回false，并且申请权限
     */
    public static boolean checkPermission(Activity activity, String[] permissions) {
        for (String permission : permissions) {
            if (!CheckUtil.havePermission(activity, permission)) {
                requestPermission(activity, permissions);
                return false;
            }
        }
        return true;
    }

    /**
     * 检查权限
     *
     * @param fragment   fragment对象
     * @param permission 需要检查的权限
     * @return 如果拥有权限返回true, 不然返回false，并且申请权限
     */
    public static boolean checkPermission(Fragment fragment, String permission) {
        if (!CheckUtil.havePermission(fragment.getContext(), permission)) {
            requestPermission(fragment, permission);
            return false;
        }
        return true;
    }

    /**
     * 请求某些权限
     *
     * @param fragment   fragment对象
     * @param permission 需要检查的权限
     */
    public static void requestPermission(Fragment fragment, String permission) {
        requestPermission(fragment, new String[]{permission});
    }

    /**
     * 请求某些权限
     *
     * @param fragment    fragment对象
     * @param permissions 需要检查的权限
     */
    public static void requestPermission(Fragment fragment, String[] permissions) {
        fragment.requestPermissions(permissions, PERMISSION_REQUEST);
    }

    /**
     * 请求某个权限
     *
     * @param activity   activity对象
     * @param permission 需要检查的权限
     */
    public static void requestPermission(Activity activity, String permission) {
        requestPermission(activity, new String[]{permission});
    }

    /**
     * 请求某些权限
     *
     * @param activity    activity对象
     * @param permissions 需要检查的权限
     */
    public static void requestPermission(Activity activity, String[] permissions) {
        ActivityCompat.requestPermissions(activity, permissions, PERMISSION_REQUEST);
    }


    /**
     * 处理权限结果
     *
     * @param requestCode  请求CODE
     * @param grantResults 请求结果
     * @return 如果申请成功，返回true，不然返回false
     */
    public static boolean onPermissionResult(int requestCode, int[] grantResults) {
        if (requestCode == PERMISSION_REQUEST) {
            for (int grantResult : grantResults) {
                if (grantResult == PackageManager.PERMISSION_DENIED) {
                    return false;
                }
            }
        }
        return true;
    }
}
