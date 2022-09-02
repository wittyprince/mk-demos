package com.mk.demos.nowcoder.huawei;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * sort
 * <p>
 * Sort below string with the order input by user
 * abcdabcdabcd
 * <p>
 * <p>
 * For example,
 * if user input is dabc, then the ordered string is dddaaabbbccc
 * if user input is abcd, then the ordered string is aaabbbcccddd
 * <p>
 * <p>
 * Please create the unit test source code for your source code too.
 *
 * @author WangChen
 * Created on 2022/9/2
 * @since 1.0
 */
public class Sort {

    public static void main(String[] args) throws IOException {

        String str = "abcdabcdabcd";
        String sortType1 = "dabc";
        String sortedStr1 = "dddaaabbbccc";
        String sorted1 = sort(str, sortType1);
        System.out.println(sortedStr1.equals(sorted1));

        String sortType2 = "abcd";
        String sortedStr2 = "aaabbbcccddd";
        String sorted2 = sort(str, sortType2);
        System.out.println(sortedStr2.equals(sorted2));

    }

    /**
     * 按照sortType对str进行排序
     *
     * @param str      待排序字符串
     * @param sortType 排序方式
     */
    public static String sort(String str, String sortType) {
        /*
         * 用于保存待排序字符串
         */
        Map<Character, Integer> tobeSortedMap = new HashMap<>();
        // 暂不考虑异常情况
        char[] chars = str.toCharArray();
        for (char c : chars) {
            Integer v = tobeSortedMap.get(c);
            tobeSortedMap.put(c, v == null ? 1 : v + 1);
        }

        // 暂不考虑异常情况
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sortType.length(); i++) {
            char c = sortType.charAt(i);
            Integer num = tobeSortedMap.get(c);
            for (int j = 0; j < num; j++) {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
