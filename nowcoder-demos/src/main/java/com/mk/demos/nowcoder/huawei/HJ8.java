package com.mk.demos.nowcoder.huawei;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * HJ8.合并表记录
 *
 * 描述
 * 数据表记录包含表索引index和数值value（int范围的正整数），请对表索引相同的记录进行合并，即将相同索引的数值进行求和运算，输出按照index值升序进行输出。
 *
 *
 * 提示:
 * 0 <= index <= 11111111
 * 1 <= value <= 100000
 *
 * 输入描述：
 * 先输入键值对的个数n（1 <= n <= 500）
 * 接下来n行每行输入成对的index和value值，以空格隔开
 *
 * 输出描述：
 * 输出合并后的键值对（多行）
 *
 * @author WangChen
 * Created on 2022/9/2
 * @since 1.0
 */
public class HJ8 {

    public static void main(String[] args) throws Exception{
//        StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        String next = scanner.nextLine();
        int cap = Integer.parseInt(next);

        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < cap; i++) {
            String line = scanner.nextLine();
            String[] arr = line.split(" ");
            Integer k = Integer.parseInt(arr[0]);
            Integer v = Integer.parseInt(arr[1]);
            map.put(k, map.get(k) == null ? v : v + map.get(k));
        }

        map.forEach((k, v) -> System.out.println(k + " " + v));
    }
}
