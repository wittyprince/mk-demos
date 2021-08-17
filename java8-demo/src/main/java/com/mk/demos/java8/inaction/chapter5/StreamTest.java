package com.mk.demos.java8.inaction.chapter5;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * stream test
 *
 * @author WangChen
 * Created on 2019/12/17 7:38
 * @since 1.0
 */
public class StreamTest {

    public static void main(String [] args){
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");
        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        // (1) 找出2011年发生的所有交易，并按交易额排序（从低到高）
        List<Transaction> collect = transactions.stream()
                .filter(t -> t.getYear() == 2011)
                .sorted(Comparator.comparingInt(Transaction::getValue))
                .collect(Collectors.toList());
//        transactions.sort(Comparator.comparing(Transaction::getValue));
        System.out.println("collect: " + collect);
//        System.out.println("transactions: " + transactions);

        // (2) 交易员都在哪些不同的城市工作过？
        List<String> collect1 = transactions.stream()
                .map(t -> t.getTrader().getCity())
                .distinct()
                .collect(Collectors.toList());
        System.out.println("collect1: " + collect1);

        // (3) 查找所有来自于剑桥的交易员，并按姓名排序。
        List<Trader> collect2 = transactions.stream()
                .map(Transaction::getTrader)
                .filter(t -> t.getCity().equals("Cambridge"))
                .sorted(Comparator.comparing(Trader::getName))
                .collect(Collectors.toList());
        System.out.println("collect2: " + collect2);

        // (4) 返回所有交易员的姓名字符串，按字母顺序排序。
        List<String> collect3 = transactions.stream()
                .map(Transaction::getTrader)
                .map(Trader::getName)
                .sorted(String::compareTo)
                .collect(Collectors.toList());
        System.out.println("collect3: " + collect3);

        String traderStr =
                transactions.stream()
                        .map(transaction -> transaction.getTrader().getName())
                        .distinct()
                        .sorted()
                        .reduce("", (n1, n2) -> n1 + n2);
        System.out.println("traderStr: " + traderStr);

        String traderStr2 =
                transactions.stream()
                        .map(transaction -> transaction.getTrader().getName())
                        .distinct()
                        .sorted()
                        .collect(Collectors.joining());
        System.out.println("traderStr2: " + traderStr2);


        // (5) 有没有交易员是在米兰工作的？
        Optional<Trader> milan = transactions.stream()
                .map(Transaction::getTrader)
                .filter(t -> t.getCity().equals("Milan"))
                .findAny();
        System.out.println(milan);

        boolean milanBased =
                transactions.stream()
                        .anyMatch(transaction -> transaction.getTrader()
                                .getCity()
                                .equals("Milan"));
        System.out.println(milanBased);

        // (6) 打印生活在剑桥的交易员的所有交易额。
        transactions.stream()
                .filter(t -> t.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .forEach(System.out::println);

        // (7) 所有交易中，最高的交易额是多少？
        Optional<Transaction> max = transactions.stream()
                .max(Comparator.comparingInt(Transaction::getValue));
        System.out.println(max);

        Optional<Integer> max1 = transactions.stream()
                .map(Transaction::getValue)
                .max(Integer::compareTo);
        System.out.println(max1.orElseGet(() -> -1));

        Optional<Integer> highestValue =
                transactions.stream()
                        .map(Transaction::getValue)
                        .reduce(Integer::max);

        // (8) 找到交易额最小的交易
        Optional<Transaction> first = transactions.stream()
                .sorted(new Comparator<Transaction>() {
                    @Override
                    public int compare(Transaction o1, Transaction o2) {
                        return o1.getValue() - o2.getValue();
                    }
                }).limit(1).findFirst();
        System.out.println(first);

        Optional<Transaction> smallestTransaction =
                transactions.stream()
                        .reduce((t1, t2) ->
                                t1.getValue() < t2.getValue() ? t1 : t2);
        System.out.println("smallestTransaction: " + smallestTransaction);

        Optional<Transaction> smallestTransaction2 =
                transactions.stream()
                        .min(Comparator.comparing(Transaction::getValue));
        System.out.println("smallestTransaction2: " + smallestTransaction2);
    }
}
