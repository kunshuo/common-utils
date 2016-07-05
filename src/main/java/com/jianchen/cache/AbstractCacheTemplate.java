package com.jianchen.cache;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.InitializingBean;

//--------------------- Change Logs----------------------
// <p>@author jian.cai Initial Created at 2016-07-04</p>
//-------------------------------------------------------
public abstract class AbstractCacheTemplate<CacheClient> implements ICacheTemplate<CacheClient>, InitializingBean {

    private static final String CURR_TIME_STAMP = "" + System.currentTimeMillis();

    /**
     * 实际的缓存客户端实现
     */
    private CacheClient cacheClient;

    /**
     * 缓存项的前缀,可以用于区分不同的环境
     */
    private String prefix;

    public void setPrefix(String prefix) {
        if (prefix == null) prefix = "";

        if (prefix.trim().equals("%time%"))
            prefix = CURR_TIME_STAMP;

        this.prefix = prefix;
    }

    public CacheClient getClient() {
        return cacheClient;
    }

    public String getInnerKey(String key) {
        String innerKey = key;

        if (StringUtils.isNotBlank(prefix))
            innerKey = prefix + innerKey;

        return innerKey;
    }

    public <T> boolean set(String key, T value) throws CacheException {
        return set(key, value, 0);
    }

    public <T> T get(String key) throws CacheException {
        return get(key);
    }

    public <T> boolean setWithoutException(String key, T value) {
        try {
            return set(key, value, 0);
        } catch (CacheException e) {
            return false;
        }
    }

    public <T> T getWithoutException(String key) {
        return null;
    }

    public <T> T getWithDefaultNull(String key) {
        return null;
    }

    public <T> T getWithDefault(String key, T defaultValue) {
        return null;
    }

    public boolean delete(String key) throws CacheException {
        return false;
    }

    public boolean deleteWithoutException(String key) {
        return false;
    }

    public void afterPropertiesSet() throws Exception {

    }
}
