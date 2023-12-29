package com.mk.demos.nowcoder.huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * HJ101.输入整型数组和排序标识
 *
 * 描述
 * 输入整型数组和排序标识，对其元素按照升序或降序进行排序
 *
 * 数据范围： 1 \le n \le 1000 \1≤n≤1000  ，元素大小满足 0 \le val \le 100000 \0≤val≤100000
 * 输入描述：
 * 第一行输入数组元素个数
 * 第二行输入待排序的数组，每个数用空格隔开
 * 第三行输入一个整数0或1。0代表升序排序，1代表降序排序
 *
 * 输出描述：
 * 输出排好序的数字
 *
 * @author WangChen
 * Created on 2022/8/30
 * @since 1.0
 */
public class HJ101 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String numStr = br.readLine();
        int num = Integer.parseInt(numStr);

        String arrStr = br.readLine();
        String[] arr = arrStr.split(" ");
        List<String> list = Arrays.asList(arr);
        list.stream().map(Integer::parseInt).sorted(Integer::compare).forEach(a -> {
            System.out.print(a);
            System.out.println(" ");
        });



    }


}
