package com.jianchen.cache;

//--------------------- Change Logs----------------------
// <p>@author jian.cai Initial Created at 2016-07-06</p>
//-------------------------------------------------------
public class CacheKeyBuilder {

    public CacheKeyBuilder() {
    }

    /**
     * 生成缓存条目的key
     *
     * @param keys
     * @param <V>
     * @return
     */
    public static <V> String of(V... keys) {
        if (keys == null || keys.length == 0)
            throw new IllegalArgumentException("keys must be specified");

        StringBuilder sb = new StringBuilder(64);
        for (int i = 0; i < keys.length; i++) {
            if (keys[i] == null)
                sb.append("%");
            else
                sb.append(keys[i].toString() + "_");
        }

        return sb.toString();
    }


    /**
     * 生成缓存条目的key
     *
     * @param prefix 缓存key的前缀
     * @param keys
     * @param <V>
     * @return
     */
    public static <V> String of(V prefix, V... keys) {
        if (prefix == null) throw new IllegalArgumentException("prefix must be specified");
        if (keys == null || keys.length == 0)
            throw new IllegalArgumentException("keys must be specified");
        return prefix + "_" + of(keys);
    }
}
