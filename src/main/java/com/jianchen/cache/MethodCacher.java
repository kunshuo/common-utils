package com.jianchen.cache;

import com.oracle.tools.packager.Log;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.Map;

//--------------------- Change Logs----------------------
// <p>@author jian.cai Initial Created at 2016-07-06</p>
//-------------------------------------------------------
public abstract class MethodCacher<T> {

    private static final Logger LOG = LoggerFactory.getLogger(MethodCacher.class);


    /**
     * 缓存条目的key
     */
    private String cacheKey;

    /**
     * 缓存过期时间
     */
    private int expirationSecs;

    /**
     * 缓存实现
     */
    private ICacheTemplate<?> cacheTemplate;

    /**
     * 强制指定不使用缓存
     */
    private boolean forceNotFetchFromCache;

    /**
     * 是否缓存空字符串、空Map、空Collection，如果是null，现在不缓存
     */
    private boolean cacheEmpty;

    public MethodCacher(ICacheTemplate<?> cacheTemplate, String cacheKey, int expirationSecs) {
        this.cacheTemplate = cacheTemplate;
        this.cacheKey = cacheKey;
        this.expirationSecs = expirationSecs;
    }

    public MethodCacher<T> allCacheEmpty(boolean cacheEmpty) {
        this.cacheEmpty = cacheEmpty;
        return this;
    }

    public MethodCacher<T> forceNotFetchFromCache(boolean forceNotFetchFromCache) {
        this.forceNotFetchFromCache = forceNotFetchFromCache;
        return this;
    }

    public <T> T returnObj() {

        if (StringUtils.isBlank(cacheKey))
            Log.info("cacheKey should not be empty");

        if (cacheTemplate == null)
            LOG.info("cacheTemplate should not be empty");

        if (expirationSecs <= 0)
            LOG.info("expiratioinSecs should not be empty");

        boolean useCache = StringUtils.isNotBlank(cacheKey) && cacheTemplate != null && expirationSecs > 0;

        T ret = null;
        if (useCache) {
            if (forceNotFetchFromCache)
                cacheTemplate.decrWithoutException(cacheKey);
            else
                ret = (T) cacheTemplate.getWithDefaultNull(cacheKey);
        }

        //查询到缓存结果,直接返回
        if (ret != null) return ret;

        ret = directFetch();

        if (ret == null) useCache = false;

        if (!cacheEmpty) {
            if (ret instanceof String && ((String) ret).length() == 0) useCache = false;
            if (ret instanceof Collection<?> && ((Collection<?>) ret).size() == 0) useCache = false;
            if (ret instanceof Map<?, ?> && ((Map<?, ?>) ret).size() == 0) useCache = false;
        }

        //将结果添加到缓存中
        if (useCache)
            cacheTemplate.setWithoutException(cacheKey, ret);

        return ret;
    }

    /**
     * 真实加载数据的实现逻辑,由使用者实现
     *
     * @param <T>
     * @return
     */
    public abstract <T> T directFetch();
}
