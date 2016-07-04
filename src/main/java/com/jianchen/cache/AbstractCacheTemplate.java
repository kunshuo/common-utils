package com.jianchen.cache;

import org.springframework.beans.factory.InitializingBean;

//--------------------- Change Logs----------------------
// <p>@author jian.cai Initial Created at 2016-07-04</p>
//-------------------------------------------------------
public class AbstractCacheTemplate<CacheClient> implements ICacheTemplate<CacheClient>, InitializingBean {

    private CacheClient cacheClient;

    public CacheClient getClient() {
        return null;
    }

    public <T> boolean set(String key, T value) throws CacheException {
        return false;
    }

    public <T> T get(String key) throws CacheException {
        return null;
    }

    public <T> boolean set(String key, T value, int expireTime) throws CacheException {
        return false;
    }

    public <T> boolean setWithoutException(String key, T value) {
        return false;
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
