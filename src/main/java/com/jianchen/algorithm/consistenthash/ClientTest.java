package com.jianchen.algorithm.consistenthash;

import java.util.Arrays;
import java.util.List;

//--------------------- Change Logs----------------------
// <p>@author jian.cai Initial Created at 2016-07-17</p>
//-------------------------------------------------------
public class ClientTest {

    public static void main(String[] args) {
        List<Node> nodes = Arrays.asList(new Node("node1"), new Node("node2"), new Node("node3"), new Node("node4"));
        MemcacheClient memCachedClient = new MemcacheClient(nodes);
        System.out.println("真实节点数=" + nodes.size());
        System.out.println("虚拟节点数=" + memCachedClient.getVitualNodeSize());
        System.out.println("添加key-value对数=" + 10000);
        System.out.println("=================开始==============");
        for (int i = 0; i < 100000; i++) {
            memCachedClient.setValurForKey(i + "-jianchen", "jianchen" + i);
        }
        System.out.println("node1缓存数据=" + nodes.get(0).getCachedMap().size());
        System.out.println("node2缓存数据=" + nodes.get(1).getCachedMap().size());
        System.out.println("node3缓存数据=" + nodes.get(2).getCachedMap().size());
        System.out.println("node4缓存数据=" + nodes.get(3).getCachedMap().size());
        System.out.println("=================结束==============");
        System.out.println("key=0-jianchen,value=" + memCachedClient.getValueForKey("0-jianchen"));
        System.out.println("key=2-jianchen,value=" + memCachedClient.getValueForKey("2-jianchen"));
    }
}
