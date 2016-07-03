package com.jianchen.busi;

import com.google.common.base.Objects;
import org.apache.commons.lang.StringUtils;

import java.io.Serializable;

//--------------------- Change Logs----------------------
// <p>@author jian.cai Initial Created at 2016-07-03</p>
//-------------------------------------------------------
public final class ApiErrorCode implements Serializable {

    private static final long serialVersionUID = -7023943964273347411L;

    public final String errcode;

    public final String errmsg;

    public ApiErrorCode(String errcode, String errmsg) {
        if (StringUtils.isBlank(errcode)) {
            throw new IllegalArgumentException("errcode must not be blank");
        }
        this.errcode = errcode;
        this.errmsg = errmsg;
    }

    public int hashCode() {
        return errcode.hashCode();
    }

    public String getErrcode() {
        return errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public boolean equals(Object o) {
        if (!(o instanceof ApiErrorCode)) return false;
        if (o == this) return true;
        ApiErrorCode aec = (ApiErrorCode) o;
        return StringUtils.equals(this.errcode, aec.errcode);
    }

    public String toString() {
        return Objects.toStringHelper(ApiErrorCode.class)//NL
                .add("errcode", errcode)//NL
                .add("errmsg", errmsg)//NL
                .toString();
    }
}
