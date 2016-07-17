package com.jianchen.algorithm.consistenthash;

import java.util.List;

//--------------------- Change Logs----------------------
// <p>@author jian.cai Initial Created at 2016-07-17</p>
//-------------------------------------------------------
public class MemcacheClient<T> {
    /**
     * 一致性hash的环
     */
    private Loop loop;

    public MemcacheClient(List nodes) {
        this.loop = new Loop(nodes);
    }

    public T getValueForKey(String key) {
        Node node = loop.getNode(key);
        return (T) node.getCachedMap().get(key);
    }

    public void setValurForKey(String key, String value) {
        Node node = loop.getNode(key);
        node.getCachedMap().put(key, value);
    }

    public int getVitualNodeSize() {
        return loop.getVirtualNodeSize();
    }
}
