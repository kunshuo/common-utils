package com.jianchen.algorithm.consistenthash;

import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

//--------------------- Change Logs----------------------
// <p>@author jian.cai Initial Created at 2016-07-17</p>
//-------------------------------------------------------
public class Loop {
    /**
     * 虚拟节点集合,用有序的map表示
     */
    private TreeMap<Long, Node> virtualNodes;
    /**
     * 对应的实际底层物理节点
     */
    private List<Node> nodes;
    /**
     * 每个节点对应的最多虚拟节点数量
     */
    private final static int VIRTUAL_NUM = 100;

    public Loop(List<Node> nodes) {
        this.nodes = nodes;
        virtualNodes = new TreeMap();
        init();
    }

    /**
     * 初始化虚拟节点
     */
    private void init() {
        for (Node node : nodes) {
            for (int m = 0; m <= VIRTUAL_NUM / 4; m++) {
                byte[] result = Utils.Md5(node.hashCode() + "" + m);  //0-24
                for (int index = 0; index < 4; index++) {
                    virtualNodes.put(Utils.hash(result, index), node);//0-3
                }
            }
        }
    }

    public Node getNode(String key) {
        SortedMap<Long, Node> loop = virtualNodes.tailMap(hash(key)); //取满足条件的最小集合
        if (loop.size() == 0) {
            return virtualNodes.get(virtualNodes.firstKey());//如果没有满足的,则返回loop的第一个虚拟节点
        }
        return loop.get(loop.firstKey());//否则返回满足条件的集合中的第一个虚拟节点
    }

    private long hash(String key) {
        byte[] bytes = Utils.Md5(key);
        long result = 0;
        for (int i = 0; i < 4; i++) {
            result |= Utils.hash(bytes, i);
        }
        return result;
    }

    public int getVirtualNodeSize() {
        return virtualNodes.size();
    }
}
