package com.mk.demos.nowcoder.huawei;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * *HJ23.删除字符串中出现次数最少的字符
 *
 * 描述
 * 实现删除字符串中出现次数最少的字符，若出现次数最少的字符有多个，则把出现次数最少的字符都删除。输出删除这些单词后的字符串，字符串中其它字符保持原来的顺序。
 *
 * 数据范围：输入的字符串长度满足 1 \le n \le 20 \1≤n≤20  ，保证输入的字符串中仅出现小写字母
 * 输入描述：
 * 字符串只包含小写英文字母, 不考虑非法输入，输入的字符串长度小于等于20个字节。
 *
 * 输出描述：
 * 删除字符串中出现次数最少的字符后的字符串。
 *
 * @author WangChen
 * Created on 2022/8/30
 * @since 1.0
 */
public class HJ23 {

    public static void main(String[] args) throws Exception{
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        String str = read.readLine();
        char[] chars = str.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char c: chars){
            int v = map.get(c) == null ? 0 : map.get(c);
            map.put(c, v + 1);
        }
        Integer min = map.values().stream().min(Integer::compare).get();

        List<Character> minList = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue().equals(min)) {
                minList.add(entry.getKey());
            }
        }

        List<Character> list = new LinkedList<>();
        for (char c: chars){
            if (!minList.contains(c)) {
                list.add(c);
            }
        }
//        Character[] objects = list.toArray(new Character[0]);
        list.forEach(System.out::print);

    }
}
