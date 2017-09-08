package com.linciping.library;

import android.content.Context;
import android.util.TypedValue;

/**
 * @author linciping
 *         2017/9/7
 *         尺寸工具
 */
public class MeasureUtil {

    /**
     * 获取屏幕宽度
     *
     * @param context 上下文对象
     * @return 屏幕宽度
     */
    public static int getWindowWidth(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    /**
     * 获取屏幕高度
     *
     * @param context 上下文对象
     * @return 屏幕高度
     */
    public static int getWindowHeight(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    /**
     * dp 转 px
     *
     * @param context 上下文对象
     * @param dp      需要转换的dp值
     * @return px结果
     */
    public static float dp2px(Context context, float dp) {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                dp, context.getResources().getDisplayMetrics());
    }

    /**
     * px 转 dp
     *
     * @param context 上下文对象
     * @param px      需要转换的px值
     * @return dp结果
     */
    public static float px2dp(Context context, float px) {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PX, px, context.getResources().getDisplayMetrics());
    }

}
