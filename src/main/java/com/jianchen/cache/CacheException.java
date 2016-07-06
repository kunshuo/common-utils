package com.jianchen.cache;

//--------------------- Change Logs----------------------
// <p>@author jian.cai Initial Created at 2016-07-03</p>
//-------------------------------------------------------
public class CacheException extends RuntimeException {

    public CacheException() {
    }

    public CacheException(String message) {
        super(message);
    }

    public CacheException(String message, Throwable e) {
        super(message, e);
    }

    public CacheException(Throwable e) {
        super(e);
    }
}

