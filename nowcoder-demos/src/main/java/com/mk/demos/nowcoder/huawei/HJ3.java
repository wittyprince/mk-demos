package com.mk.demos.nowcoder.huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * HJ3 明明的随机数
 *
 * 描述
 * 明明生成了NN个1到500之间的随机整数。请你删去其中重复的数字，即相同的数字只保留一个，把其余相同的数去掉，然后再把这些数从小到大排序，按照排好的顺序输出。
 *
 * 数据范围： 1 \le n \le 1000 \1≤n≤1000  ，输入的数字大小满足 1 \le val \le 500 \1≤val≤500
 * 输入描述：
 * 第一行先输入随机整数的个数 N 。 接下来的 N 行每行输入一个整数，代表明明生成的随机数。 具体格式可以参考下面的"示例"。
 * 输出描述：
 * 输出多行，表示输入数据处理后的结果
 *
 * @author WangChen
 * Created on 2022/8/27
 * @since 1.0
 */
public class HJ3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        for(int i =0 ; i < num ;i++){
            list.add(Integer.parseInt(br.readLine()));
        }

        list.sort((x, y) -> {
            if ( x < y) {
                return -1;
            }
            if (x > y) {
                return 1;
            }
            return -0;
        });

        List<Integer> resultList = new ArrayList<>();
        for (int i=0; i<list.size(); i++) {
            if (resultList.contains(list.get(i))) {
                continue;
            }
            resultList.add(list.get(i));
        }
        resultList.forEach(System.out::println);
    }
}
