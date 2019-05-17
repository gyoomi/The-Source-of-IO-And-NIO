/**
 * Copyright © 2019, LeonKeh
 * <p>
 * All Rights Reserved.
 */

package com.gyoomi.nio.buffer;

import java.nio.CharBuffer;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2019/5/17 14:46
 */
public class Buffer01 {

    public static void main(String[] args) throws Exception {
        CharBuffer cb = CharBuffer.allocate(100);
        while (fillBuffer(cb)) {
            cb.flip();
            drainBuffer(cb);
            cb.clear();
        }
    }

    private static String[] strs = {
            "hello buffer",
            "help me!",
            "dooo",
            "i am very happy"
    };

    private static int index = 0;

    private static boolean fillBuffer(CharBuffer cb) {
        if (index >= strs.length) {
            return false;
        }
        String str = strs[index++];
        for (int i = 0; i < str.length(); i++) {
            cb.put(str.charAt(i));
        }
        return true;
    }

    private static void drainBuffer(CharBuffer cb) {
        while (cb.hasRemaining()) {
            System.out.println(cb.get());
        }
        System.out.println("***");
    }
}
