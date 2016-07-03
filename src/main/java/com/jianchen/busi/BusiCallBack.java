package com.jianchen.busi;

//--------------------- Change Logs----------------------
// <p>@author jian.cai Initial Created at 2016-07-03</p>
//-------------------------------------------------------
public interface BusiCallBack<T> {

    public Response<T> execute();

}
