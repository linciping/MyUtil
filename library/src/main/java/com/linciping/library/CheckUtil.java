package com.linciping.library;

import java.util.Collection;
import java.util.Map;

/**
 * @author linciping
 *         2017/9/7
 *         检查工具
 */

public class CheckUtil {
    /**
     * 判断字符串是否为空
     *
     * @param content 需要判断的字符串内容
     * @return 如果字符串为空返回 true,不然返回false
     */
    public static boolean isStringEmpty(String content) {
        return content == null || content.length() <= 0;
    }

    /**
     * 判断集合是否为空
     *
     * @param collection 需要判断的集合内容
     * @return 如果集合为空返回 true,不然返回false
     */
    public static boolean isCollectionEmpty(Collection<?> collection) {
        return collection == null || collection.size() <= 0;
    }

    /**
     * 判断Map是否为空
     *
     * @param map 需要判断的map内容
     * @return 如果map为空返回 true,不然返回false
     */
    public static boolean isMapEmpty(Map<?, ?> map) {
        return map == null || map.size() <= 0;
    }

    /**
     * 处理字符串
     *
     * @param content 需要处理的字符串
     * @return 如果为空，返回""，不然返回content
     */
    public static String commonString(String content) {
        return commonString(content, "");
    }

    /**
     * 处理字符串，
     *
     * @param content        需要处理的字符串
     * @param defaultContent 默认字符
     * @return 如果为空，返回defaultContent，不然返回content
     */
    public static String commonString(String content, String defaultContent) {
        if (isStringEmpty(content)) {
            return defaultContent;
        }
        return content;
    }

    /**
     * 判断对象数组是否为空
     *
     * @param array 需要判断的对象数组
     * @param <T>   对象泛型
     * @return 如果为空返回true，不然返回false
     */
    public static <T> boolean isArrayEmpty(T[] array) {
        return array == null || array.length <= 0;
    }
}
