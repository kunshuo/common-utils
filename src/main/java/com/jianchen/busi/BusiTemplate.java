package com.jianchen.busi;

import org.slf4j.Logger;

//--------------------- Change Logs----------------------
// <p>@author jian.cai Initial Created at 2016-07-03</p>
//-------------------------------------------------------
public class BusiTemplate {

    /**
     * 通用的业务处理模板
     *
     * @param logger
     * @param callback
     * @param <T>
     * @return
     */
    public <T> Response<T> exceuteBusiness(Logger logger, BusiCallBack<T> callback) {
        Response<T> response = new Response<T>();
        try {
            response = callback.execute();
        } catch (IllegalArgumentException e) {
            logger.error(e.getMessage(), e);
            response.setErrCode(Response.ARG_INVALID.errcode);
            response.setErrMessage(Response.ARG_INVALID.errmsg);
        } catch (BusiException e) {
            logger.error(e.getMessage(), e);
            response.setErrCode(e.getErrCode());
            response.setErrMessage(e.getErrMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            response.setErrCode(Response.SYSTEM_FAILURE.errcode);
            response.setErrMessage(Response.SYSTEM_FAILURE.errmsg);
        }

        return response;
    }
}
