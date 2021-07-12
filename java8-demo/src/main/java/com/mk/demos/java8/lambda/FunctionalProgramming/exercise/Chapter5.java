package com.mk.demos.java8.lambda.FunctionalProgramming.exercise;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.mk.demos.java8.lambda.FunctionalProgramming.model.Artist;

/**
 * @author WangChen
 * Created on 2021/7/12 9:40
 * @since
 */
public class Chapter5 {

    // reduce 重写 count
//    public static <T> List<T> filter(Stream<T> stream, Predicate<T> predicate) {
//
//    }

    //2.a
    String longestArtistName(List<Artist> artists) {
        Artist longestArtist = artists.stream().max(Comparator.comparing(artist -> artist.getName().length())).orElse(null);
        return longestArtist == null ? null : longestArtist.getName();
    }

    private static Comparator<Artist> byNameLength = Comparator.comparing(artist -> artist.getName().length());

    public static Artist byReduce(List<Artist> artists) {
        Optional<Artist> longestArtist = artists.stream().reduce((acc, a) -> {
            if (acc.getName().length() < a.getName().length()) {
                acc = a;
            }
            return acc;
        });
        return longestArtist.orElse(null);
    }

    public static Artist byReduce2(List<Artist> artists) {
        Optional<Artist> longestArtist = artists.stream().reduce((acc, a) -> {
            int compare = byNameLength.compare(acc, a);
            if (compare > 0) {
                return acc;
            } else {
                return a;
            }
        });
        return longestArtist.orElse(null);
    }

    public static Artist byCollecting(List<Artist> artists) {
        return artists.stream().collect(Collectors.maxBy(byNameLength)).orElse(null);
    }


    // 2.b 计算每个单词出现的次数
    Map<String, Long> getNum(Stream<String> names){
        Map<String, Long> collect = names.collect(Collectors.groupingBy(name -> name, Collectors.counting()));
        return collect;
    }


}
