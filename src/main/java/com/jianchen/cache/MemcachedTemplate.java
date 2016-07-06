package com.jianchen.cache;

import net.rubyeye.xmemcached.MemcachedClient;

//--------------------- Change Logs----------------------
// <p>@author jian.cai Initial Created at 2016-07-06</p>
//-------------------------------------------------------
public class MemcachedTemplate extends AbstractCacheTemplate<MemcachedClient> {

    public void setOpTimeout(long timeout) {
        this.getCacheClient().setOpTimeout(timeout);
    }

    public <T> T get(String key) throws CacheException {
        try {
            return this.getCacheClient().get(getInnerKey(key));
        } catch (Exception e) {
            throw new CacheException(e);
        }
    }

    public <T> boolean set(String key, T value, int expireTime) throws CacheException {
        try {
            return this.getCacheClient().set(key, expireTime, value);
        } catch (Exception e) {
            throw new CacheException(e);
        }
    }

    public boolean delete(String key) throws CacheException {
        try {
            return this.getCacheClient().delete(key);
        } catch (Exception e) {
            throw new CacheException(e);
        }
    }

    public long incr(String key, long delta, long initValue) throws CacheException {
        try {
            return this.getCacheClient().incr(key, delta, initValue);
        } catch (Exception e) {
            throw new CacheException(e);
        }
    }

    public long decr(String key, long delta, long initValue) throws CacheException {
        try {
            return this.getCacheClient().decr(key, delta, initValue);
        } catch (Exception e) {
            throw new CacheException(e);
        }
    }
}
