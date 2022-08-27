package com.mk.demos.nowcoder.huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

/**
 * HJ5 进制转换
 *
 * @author WangChen
 * Created on 2022/8/27
 * @since 1.0
 */
public class HJ5 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null) {
//            System.out.println(Integer.parseInt(str.substring(2), 16));
//            System.out.println(Integer.valueOf(str.substring(2), 16));
//            System.out.println(Integer.parseInt(str.substring(2, str.length()), 16));
            str = str.substring(2).toLowerCase();
            int result = 0;
            for (int i=0; i<str.length(); i++) {
                char c = str.charAt(i);
                if (c >= '0' && c <= '9') {
                    result = result + (c - '0') * Double.valueOf(Math.pow(16, str.length() - i - 1)).intValue();
                } else {
                    result = result + (c - 'a' + 10) * Double.valueOf(Math.pow(16, str.length() - i - 1)).intValue();
                }
            }
            System.out.println(result);
        }

//        System.out.println(Character.digit('a',16));


    }
}
