package com.linciping.library.util;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * @author linciping
 * @time 2017/9/12
 * @note 通用工具
 */

public class CommonUtil {

    /**
     * 处理字符串 See {@link CheckUtil#isStringEmpty(String)}
     *
     * @param content 需要处理的字符串
     * @return 如果为空，返回""，不然返回content
     */
    public static String commonString(String content) {
        return commonString(content, "");
    }

    /**
     * 处理字符串
     *
     * @param content        需要处理的字符串
     * @param defaultContent 默认字符
     * @return 如果为空，返回defaultContent，不然返回content
     */
    public static String commonString(String content, String defaultContent) {
        if (CheckUtil.isStringEmpty(content)) {
            return defaultContent;
        }
        return content;
    }

    /**
     * 返回集合的大小 Use {@link CheckUtil#isCollectionEmpty(Collection)}
     *
     * @param collection 目标集合
     * @return 集合的大小，如果为空为0 ，不然返回集合的大小
     */
    public static int collectionSize(Collection<?> collection) {
        if (CheckUtil.isCollectionEmpty(collection)) {
            return 0;
        }
        return collection.size();
    }

    /**
     * 返回数组的大小  Use {@link CheckUtil#isArrayEmpty(T[])}
     *
     * @param array 目标数组
     * @param <T>   泛型
     * @return 数组的大小，如果为空为0，不然返回数组的大小
     */
    public static <T> int arraySize(T[] array) {
        if (CheckUtil.isArrayEmpty(array)) {
            return 0;
        }
        return array.length;
    }

    /**
     * 返回map的大小 Use {@link CheckUtil#isMapEmpty(Map)}
     *
     * @param map 目标map
     * @return map的大小，如果为空为0 ，不然返回map的大小
     */
    public static int mapSize(Map<?, ?> map) {
        if (CheckUtil.isMapEmpty(map)) {
            return 0;
        }
        return map.size();
    }

    /**
     * 返回set的大小 Use {@link CheckUtil#isSetEmpty(Set)}
     *
     * @param set 目标set
     * @return set的大小，如果为空为0 ，不然返回set的大小
     */
    public static int setSize(Set<?> set) {
        if (CheckUtil.isSetEmpty(set)) {
            return 0;
        }
        return set.size();
    }
}
