package com.linciping.library;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * @author linciping
 * 2017/9/7
 * 检查工具
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
     * 判断对象数组是否为空
     *
     * @param array 需要判断的对象数组
     * @param <T>   对象泛型
     * @return 如果为空返回true，不然返回false
     */
    public static <T> boolean isArrayEmpty(T[] array) {
        return array == null || array.length <= 0;
    }

    /**
     * 判断set是否为空
     *
     * @param set 需要判断的set对象
     * @return 如果set为空返回 true,不然返回false
     */
    public static boolean isSetEmpty(Set<?> set) {
        return set == null || set.size() <= 0;
    }
}
