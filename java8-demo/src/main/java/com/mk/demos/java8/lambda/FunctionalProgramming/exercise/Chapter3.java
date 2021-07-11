package com.mk.demos.java8.lambda.FunctionalProgramming.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.mk.demos.java8.lambda.FunctionalProgramming.model.Album;
import com.mk.demos.java8.lambda.FunctionalProgramming.model.Artist;

/**
 * @author WangChen
 * Created on 2021/7/11 16:51
 * @since 0.1
 */
public class Chapter3 {

    // 1.a
    int addUp(Stream<Integer> numbers) {
//        return numbers.reduce(0, (acc, e) -> acc + e);
        return numbers.reduce(0, Integer::sum);
    }

    // 1.b
    List<String> getArtistNameAndNational(List<Artist> artists) {
        return artists.stream().map(artist -> artist.getName() + "_" + artist.getOrigin()).collect(Collectors.toList());
    }

    // 1.c
    List<Album> filter(List<Album> albums) {
        return albums.stream().filter(album -> album.getMusicians().size() <= 3).collect(Collectors.toList());
    }

    // 2.
    void rewrite() {
        List<Artist> artists = new ArrayList<>();
        int totalMembers = 0;
        for (Artist artist : artists) {
            List<String> members = artist.getMembers();
            totalMembers += members.size();
        }

        artists.stream().mapToInt(a -> a.getMembers().size()).count();// 不应该是count, 而应该是reduce
        artists.stream().map(artist -> artist.getMembers().size()).reduce(0, (a, b) -> a + b);

    }

    // 3.

    // 6.计算一个字符串中小写字母的个数
    long getNumOfString(String s) {
        List<char[]> charsList = Arrays.asList(s.toCharArray());

//        char start = 'a';
//        char end = 'z';
//        charsList.stream().flatMap(chars -> chars.)


        return s.chars().filter(c -> c >= 'a' && c <= 'z').count();
    }

    // 7.
    Optional<String> find(List<String> list){
        return list.stream().max(Comparator.comparing(this::getNumOfString));
    }

    public static void fun(String str) {
        char[] c = str.toCharArray();
        int daxie = 0;
        int xiaoxie = 0;
        int num = 0;
        for (int i = 0; i < str.length(); i++) {
            if (c[i] >= 'a' && c[i] <= 'z') {
                xiaoxie++;
            } else if (c[i] >= 'A' && c[i] <= 'Z') {
                daxie++;
            } else if (c[i] >= '0' && c[i] <= '9') {
                num++;
            }
        }
        System.out.println("大写字母有：" + daxie + "个，小写字母有：" + xiaoxie + "个，数字有：" + num + "个");
    }

    // ==============================================
    // reduce 重写 map
//    <R, T> Stream<R> map(Function<? super T, ? extends R> mapper){
//
//    }

    public static <I, O> List<O> map(Stream<I> stream, Function<I, O> mapper) {
        List<O> reduction = stream.reduce(new ArrayList<O>(), (acc, x) -> {
            ArrayList<O> accList = new ArrayList<>(acc);
            accList.add(mapper.apply(x));
            return accList;
        }, (List<O> left, List<O> right) -> {
            List<O> newLeft = new ArrayList<>(left);
            newLeft.addAll(right);
            return newLeft;
        });
        return reduction;
    }

    // reduce 重写 filter
    public static <T> List<T> filter(Stream<T> stream, Predicate<T> predicate) {
        List<T> reduction = stream.reduce(new ArrayList<T>(), (acc, x) -> {
            List<T> newAcc = new ArrayList<>(acc);
            if (predicate.test(x)) {
                newAcc.add(x);
            }
            return (ArrayList<T>) newAcc;
        }, (List<T> left, List<T> right) -> {
            List<T> newLeft = new ArrayList<>(left);
            newLeft.addAll(right);
            return newLeft;
        });
        return reduction;
    }
}
