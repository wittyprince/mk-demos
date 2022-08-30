package com.mk.demos.nowcoder.huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * HJ20.密码验证合格程序
 *
 * 字符串操作
 *
 * 描述
 * 密码要求:
 *
 * 1.长度超过8位
 *
 * 2.包括大小写字母.数字.其它符号,以上四种至少三种
 *
 * 3.不能有长度大于2的包含公共元素的子串重复 （注：其他符号不含空格或换行）
 *
 * 数据范围：输入的字符串长度满足 1 \le n \le 100 \1≤n≤100
 * 输入描述：
 * 一组字符串。
 *
 * 输出描述：
 * 如果符合要求输出：OK，否则输出NG
 *
 * @author WangChen
 * Created on 2022/8/29
 * @since 1.0
 */
public class HJ20 {


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = null;
        lableX:
        while ((input = reader.readLine()) != null) {
            if (input.length() <= 8) {
                System.out.println("NG");
                continue;
            }
            for (int i = 0; i < input.length() - 6; i++) {
                String first = input.substring(i, i + 3);
                String second = input.substring(i + 3);
                if (second.contains(first)) {
                    System.out.println("NG");
                    continue lableX;
                }
            }

            StringBuffer sb = new StringBuffer();
            Map<Character, Integer> characterMap = new HashMap<>();
            Map<String, Integer> typeMap = new HashMap<>();
            char[] chars = input.toCharArray();
            for (char c : chars) {
//                if (characterMap.get(c) != null && characterMap.get(c) > 0) {
//                    System.out.println("NG");
//                    continue lableX;
//                }
//                characterMap.put(c, 1);

                if (c >= 'A' && c <= 'Z') {
                    typeMap.put("A", 1);
                } else
                if (c >= 'a' && c < 'z') {
                    typeMap.put("a", 1);
                } else
                if (c >= '0' && c <= '9') {
                    typeMap.put("0", 1);
                } else if ((byte)c != 10 && (byte)c != 32){
                    typeMap.put("#", 1);
                }

            }
            int size = typeMap.values().size();
            if (size < 3) {
                System.out.println("NG");
            } else {
                System.out.println("OK");
            }
        }

    }
}
