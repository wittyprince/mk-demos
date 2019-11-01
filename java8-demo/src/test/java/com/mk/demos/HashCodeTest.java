package com.mk.demos;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

/**
 * hash code test
 *
 * @author WangChen
 * Created on 2019/11/1 18:03
 * @since 1.0
 */
public class HashCodeTest {

    /**
     * 以1-256为乘数，分别计算/usr/share/dict/words所有单词的哈希冲突率、总耗时.
     *
     * @throws IOException
     */
    @Test
    public void testHash() throws IOException {
        List<String> words = getWords();

        System.out.println();
        System.out.println("multiplier, conflictSize, conflictRate, timeCost, listSize, minHash, maxHash");
        for (int i = 1; i <=256; i++) {
            computeConflictRate(words, i);
        }
    }

    /**
     * 读取/usr/share/dict/words所有单词
     *
     * @return
     * @throws IOException
     */
    private List<String> getWords() throws IOException {
        // read file
        InputStream is = HashCodeTest.class.getClassLoader().getResourceAsStream("./linux.words");
        List<String> lines = IOUtils.readLines(is, "UTF-8");
        return lines;
    }

    /**
     * 计算冲突率
     *
     * @param lines
     */
    private void computeConflictRate(List<String> lines, int multiplier) {
        // compute hash
        long startTime = System.currentTimeMillis();
        List<Integer> hashList = computeHashes(lines, multiplier);
        long timeCost = System.currentTimeMillis() - startTime;

        // find max and min hash
        Comparator<Integer> comparator = (x, y) -> x > y ? 1 : (x < y ? -1 : 0);
        int maxHash = hashList.parallelStream().max(comparator).get();
        int minHash = hashList.parallelStream().min(comparator).get();

        // hash set
        Set<Integer> hashSet = hashList.parallelStream().collect(Collectors.toSet());

        int conflictSize = lines.size() - hashSet.size();
        float conflictRate = conflictSize * 1.0f / lines.size();
        System.out.println(String.format("%s, %s, %s, %s, %s, %s, %s", multiplier, conflictSize, conflictRate, timeCost, lines.size(), minHash, maxHash));
    }

    /**
     * 根据乘数计算hash值
     *
     * @param lines
     * @param multiplier
     * @return
     */
    private List<Integer> computeHashes(List<String> lines, int multiplier) {
        Function<String, Integer> hashFunction = x -> {
            int hash = 0;
            for (int i = 0; i < x.length(); i++) {
                hash = (multiplier * hash) + x.charAt(i);
            }
            return hash;
        };
        return lines.parallelStream().map(hashFunction).collect(Collectors.toList());
    }

    @Test
    public void testHashDistribution() throws IOException {
        int[] multipliers = {2, 17, 31, 33, 63, 127, 73, 133, 237, 161};
        List<String> words = getWords();
        for (int multiplier : multipliers) {
            List<Integer> hashList = computeHashes(words, multiplier);
            Map<Integer, Integer> hashMap = partition(hashList);
            System.out.println("\n" + multiplier + "\n,count");
            hashMap.forEach((x, y) -> System.out.println(x + "," + y));
        }
    }

    /**
     * 将整个哈希空间等分成128份，统计每个空间内的哈希值数量
     *
     * @param hashs
     */
    public static Map<Integer, Integer> partition(List<Integer> hashs) {
        // step = 2^32 / 128 = 33554432
        final int step = 33554432;
        List<Integer> nums = new ArrayList<>();
        Map<Integer, Integer> statistics = new LinkedHashMap<>();
        int start = 0;
        for (long i = Integer.MIN_VALUE; i <= Integer.MAX_VALUE; i += step) {
            final long min = i;
            final long max = min + step;
            int num = (int) hashs.parallelStream().filter(x -> x >= min && x < max).count();

            statistics.put(start++, num);
            nums.add(num);
        }

        // 为了防止计算出错，这里验证一下
        int hashNum = nums.stream().reduce((x, y) -> x + y).get();
        assert hashNum == hashs.size();

        return statistics;
    }

}
