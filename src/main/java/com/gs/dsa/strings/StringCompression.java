package com.gs.dsa.strings;

import java.util.Arrays;

public class StringCompression {

    public static void main(String[] args) {
        char[] chars = {'a', 'a', 'a', 'b', 'b', 'c', 'c'};
        int result = compress(chars);
        System.out.println(result);
        for (char ch : chars) {
            System.out.print(ch + " ");
        }
    }

    public static int compress(char[] chars) {
        int count = 0, write = 0;
        char curr = chars[0];

        for (char ch : chars) {
            if (ch == curr) {
                count++;
            } else {
                chars[write++] = curr;
                curr = ch;
                if (count > 1) {
                    for (char digit : String.valueOf(count).toCharArray()) {
                        chars[write++] = digit;
                    }
                }
                count = 1;
            }
        }

        chars[write++] = curr;
        if (count > 1) {
            for (char digit : String.valueOf(count).toCharArray()) {
                chars[write++] = digit;
            }
        }

        return write;
    }
}
