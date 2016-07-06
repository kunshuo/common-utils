package com.jianchen.cache;

//--------------------- Change Logs----------------------
// <p>@author jian.cai Initial Created at 2016-07-03</p>
//-------------------------------------------------------
public interface ICacheTemplate<CacheClient> {

    /**
     * 获取底层真正的缓存实现,便于使用特定缓存的特性
     *
     * @return
     */
    public CacheClient getCacheClient();

    /**
     * 获取内部的key值，如果是使用本接口提供的函数，不需要显示的调用这个函数，否则，需要显示的调用
     */
    public String getInnerKey(String key);


    /**
     * 设置缓存值,使用默认的过期时间
     *
     * @param key
     * @param value
     * @param <T>
     * @return
     * @throws CacheException
     */
    public <T> boolean set(String key, T value) throws CacheException;

    /**
     * 获取缓存值
     *
     * @param key
     * @param <T>
     * @return
     * @throws CacheException
     */
    public <T> T get(String key) throws CacheException;

    /**
     * 设置缓存值,使用指定的过期时间
     *
     * @param key
     * @param value
     * @param <T>
     * @return
     * @throws CacheException
     */
    public <T> boolean set(String key, T value, int expireTime) throws CacheException;

    /**
     * set的无异常版本
     *
     * @param key
     * @param value
     * @param <T>
     * @return
     */
    public <T> boolean setWithoutException(String key, T value);

    /**
     * get的无异常版本
     *
     * @param key
     * @param <T>
     * @return
     */
    public <T> T getWithDefaultNull(String key);

    /**
     * 获取缓存值,取不到或者抛出异常返回默认值
     *
     * @param key
     * @param <T>
     * @return
     * @throws CacheException
     */
    public <T> T getWithDefault(String key, T defaultValue);

    /**
     * 删除指定key
     *
     * @param key
     * @return
     * @throws CacheException
     */
    public boolean delete(String key) throws CacheException;

    /**
     * 删除指定key,无异常版本
     *
     * @param key
     * @return
     * @throws CacheException
     */
    public boolean deleteWithoutException(String key);

    /**
     * 计数器,增加delta
     *
     * @param key
     * @param delta
     * @param initValue
     * @return
     * @throws CacheException
     */
    public long incr(String key, long delta, long initValue) throws CacheException;


    /**
     * 计数器增加1
     *
     * @param key
     * @return
     * @throws CacheException
     */
    public long incr(String key) throws CacheException;


    /**
     * 计数器减少delta
     *
     * @param key
     * @param delta
     * @param initValue
     * @return
     * @throws CacheException
     */
    public long decr(String key, long delta, long initValue) throws CacheException;


    /**
     * 计数器减少1
     *
     * @param key
     * @return
     * @throws CacheException
     */
    public long decr(String key) throws CacheException;

    /**
     * 如果调用缓存抛出异常，那么会返回Integer.MAX_VALUE
     *
     * @param key
     * @return
     */
    public long incrWithoutException(String key);

    /**
     * 如果调用缓存抛出异常，那么会返回Integer.MAX_VALUE
     *
     * @param key
     * @param delta
     * @return
     */
    public long incrWithoutException(String key, long delta, long initValue);

    /**
     * 如果调用缓存抛出异常，那么会返回Integer.MIN_VALUE
     *
     * @param key
     * @return
     */
    public long decrWithoutException(String key);

    /**
     * 如果调用缓存抛出异常，那么会返回Integer.MIN_VALUE
     *
     * @param key
     * @param delta
     * @return
     */
    public long decrWithoutException(String key, long delta, long initValue);

}
