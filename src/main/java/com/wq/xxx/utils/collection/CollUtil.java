package com.wq.xxx.utils.collection;

import java.util.Collection;
import java.util.function.Predicate;

/**
 * 集合工具
 * Created by wuqiang on 2021/5/12-15:48
 */
public final class CollUtil {
    private CollUtil() {
    }
    
    /**
     * 集合是否为空
     *
     * @param collection 集合
     * @return 是否为空
     */
    public static boolean isEmpty(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }
    
    /**
     * 集合是否不是空
     *
     * @param collection 集合
     * @return 是否为空
     */
    public static boolean isNotEmpty(Collection<?> collection) {
        return !isEmpty(collection);
    }
    
    /**
     * 自定义函数判断集合是否包含某类值
     *
     * @param collection  集合
     * @param containFunc 自定义判断函数
     * @param <T>         值类型
     * @return 是否包含自定义规则的值
     */
    public static <T> boolean contains(Collection<T> collection, Predicate<? super T> containFunc) {
        if (isEmpty(collection)) {
            return false;
        }
        for (T t : collection) {
            if (containFunc.test(t)) {
                return true;
            }
        }
        return false;
    }
}
