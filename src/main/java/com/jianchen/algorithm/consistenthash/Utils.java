package com.jianchen.algorithm.consistenthash;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

//--------------------- Change Logs----------------------
// <p>@author jian.cai Initial Created at 2016-07-17</p>
//-------------------------------------------------------
public class Utils {
    public static Long hash(byte[] bytes, int index) {
        long result = (long) (bytes[3 + index * 4] << 24) | (long) (bytes[2 + index * 4] << 16) | (long) (bytes[1 + index * 4] << 8) | (long) (bytes[index * 4]);
        return result & 0xffffffffL;
    }

    public static byte[] Md5(String key) {
        byte[] input = key.getBytes();
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(input);
            return md5.digest();
        } catch (NoSuchAlgorithmException e) {

        }
        return input;
    }
}
