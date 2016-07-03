package com.jianchen.busi;

//--------------------- Change Logs----------------------
// <p>@author jian.cai Initial Created at 2016-07-03</p>
//-------------------------------------------------------
public class BusiException extends RuntimeException {

    private String errCode = null;

    public BusiException(String errCode, String errMessage) {
        super(errMessage);
        this.errCode = errCode;
    }

    public BusiException(ApiErrorCode errCode) {
        super(errCode.errmsg);
        this.errCode = errCode.errcode;
    }

    public BusiException(ApiErrorCode errCode, String errMessage) {
        super(errMessage);
        this.errCode = errCode.errcode;
    }

    public BusiException(String errCode, String errMessage, Throwable t) {
        super(errMessage, t);
        this.errCode = errCode;
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getErrMessage() {
        return getErrMessage();
    }
}
