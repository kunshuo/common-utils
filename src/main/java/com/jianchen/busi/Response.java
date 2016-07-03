package com.jianchen.busi;


import com.google.common.base.Objects;

//--------------------- Change Logs----------------------
// <p>@author jian.cai Initial Created at 2016-07-03</p>
//-------------------------------------------------------
public class Response<T> {

    public static final String SUCCESS_CODE_1 = "0000000";
    public static final String SUCCESS_CODE_2 = "SUCCESS";

    //非法参数
    public final static ApiErrorCode ARG_INVALID = new ApiErrorCode("ARG_INVALID", "非法参数");

    //系统异常
    public final static ApiErrorCode SYSTEM_FAILURE = new ApiErrorCode("SYSTEM_FAILURE", "系统异常");

    private String errCode;
    private String errMessage;
    private T data;

    public Response() {
    }

    public T getData() {
        return data;
    }

    public Response(String errCode, String errMessage, T data) {
        this.errCode = errCode;
        this.errMessage = errMessage;
        this.data = data;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public void setErrMessage(String errMessage) {
        this.errMessage = errMessage;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getErrCode() {
        return errCode;
    }

    public String getErrMessage() {
        return errMessage;
    }

    public boolean isSuccess() {
        return SUCCESS_CODE_1.equals(errCode) || SUCCESS_CODE_2.equals(errCode);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(errCode, errMessage, data);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Response)) return false;
        @SuppressWarnings("rawtypes")
        Response other = (Response) o;
        return Objects.equal(this.errCode, other.errCode) //NL
                && Objects.equal(this.errMessage, other.errMessage) //NL
                && Objects.equal(this.data, other.data);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)//NL
                .add("errcode", errCode)//NL
                .add("errmsg", errMessage)//NL
                .add("data", data)//NL
                .toString();
    }
}
