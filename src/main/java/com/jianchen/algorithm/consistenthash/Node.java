package com.jianchen.algorithm.consistenthash;

import com.google.common.collect.Maps;

import java.util.Map;

//--------------------- Change Logs----------------------
// <p>@author jian.cai Initial Created at 2016-07-17</p>
//  物理节点
//-------------------------------------------------------
public class Node {
    /**
     * 物理节点名称
     */
    private String name;
    /**
     * 表示缓存的内容,key=value
     */
    private Map cachedMap;

    public Node() {
        cachedMap = Maps.newConcurrentMap();
    }

    public Node(String name) {
        this();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map getCachedMap() {
        return cachedMap;
    }

    public void setCachedMap(Map cachedMap) {
        this.cachedMap = cachedMap;
    }

    @Override
    public String toString() {
        return "Node {" + " name = '" + name + '\'' + ", cachedMap=" + cachedMap + "}";
    }
}
