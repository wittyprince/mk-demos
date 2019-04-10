package com.mk.demos.java8.chapter2;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/**
 * @author WangChen
 * Created on 2019/4/9 15:19
 * @since
 */
public class Test01 {

    public static void main(String[] args) throws IOException, URISyntaxException {
        String contents = new String(Files.readAllBytes(Paths.get(Test01.class.getResource("/alice.txt").toURI())), StandardCharsets.UTF_8);
        List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));//将字符串分割为单词，非字母被认为是分隔符

        long count = 0;
        for (String w : words) {
            if (w.length() > 12)
                count++;
        }
        System.out.println(count);

        count = words.stream().filter(w -> w.length() > 12).count();
        System.out.println(count);

        count = words.parallelStream().filter(w -> w.length() > 12).count();
        System.out.println(count);
    }
}
