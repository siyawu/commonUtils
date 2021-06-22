package com.wq.xxx.utils.function;

import com.wq.xxx.utils.StringUtil;
import com.wq.xxx.utils.collection.CollUtil;

import java.util.Collection;
import java.util.function.Consumer;

/*
 * 函数工具方法
 * Created by wuqiang on 2021/4/23-11:00
 */
public final class CallUtil {
    private CallUtil() {
    }
    
    /**
     * 对象为真回调
     *
     * @param flag     标记位
     * @param callback 回调
     */
    public static void ifTrue(boolean flag, Action callback) {
        if (flag) {
            callback.call();
        }
    }
    
    /**
     * 对象不为空回调
     *
     * @param t        对象
     * @param consumer 回调
     * @param <T>      类型
     */
    public static <T> void ifNotNull(T t, Consumer<T> consumer) {
        if (t != null) {
            consumer.accept(t);
        }
    }
    
    public static void ifNotEmpty(String s, Consumer<String> consumer) {
        if (StringUtil.isNotNullOrEmpty(s)) {
            consumer.accept(s);
        }
    }
    
    /**
     * 列表不为空回调
     *
     * @param tCollection 容器列表
     * @param consumer    回调
     * @param <T>         类型
     */
    public static <T extends Collection<?>> void ifNotEmpty(T tCollection, Consumer<T> consumer) {
        if (CollUtil.isNotEmpty(tCollection)) {
            consumer.accept(tCollection);
        }
    }
}
