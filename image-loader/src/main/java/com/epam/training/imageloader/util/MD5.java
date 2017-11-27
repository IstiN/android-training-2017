package com.epam.training.imageloader.util;


import android.util.Log;

import java.security.NoSuchAlgorithmException;

public final class MD5 {

    public static String hash(String value) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte[] array = md.digest(value.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte anArray : array) {
                sb.append(Integer.toHexString((anArray & 0xFF) | 0x100).substring(1, 3));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            Log.e("MD5", "hash: ", e);
        }
        return value;
    }
}
