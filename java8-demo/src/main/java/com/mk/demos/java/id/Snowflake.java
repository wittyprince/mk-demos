package com.mk.demos.java.id;

import java.util.concurrent.TimeUnit;

/**
 * SnowflakeTest
 *
 * @author WangChen
 * Created on 2024/11/25
 * @since 1.0
 */
public class Snowflake {

    // 机器ID 0~31
    private static long workerId;
    // 数据中心ID 0~31
    private static long datacenterId;
    // 毫秒内序列 0~4095
    private static long sequence = 0L;
    // 开始时间戳 2010-11-04 09:42:54 1288834974657 ms
    //                            1732522309381
    private static long twepoch = 29460000L;
    // 机器ID位数 5
    private static long workerIdBits = 5L;
    // 数据中心ID位数 5
    private static long datacenterIdBits = 5L;
    // 机器ID最大值 31
    private static long maxWorkerId = -1L ^ (-1L << workerIdBits);
    // 数据中心ID最大值 31
    private static long maxDatacenterId = -1L ^ (-1L << datacenterIdBits);
    // 毫秒内序列位数 12
    private static long sequenceBits = 12L;
    // 机器ID偏移位数 12
    private static long workerIdShift = sequenceBits;
    // 数据中心ID偏移位数 17
    private static long datacenterIdShift = sequenceBits + workerIdBits;
    // 时间戳左移位数 22
    private static long timestampLeftShift = sequenceBits + workerIdBits + datacenterIdBits;
    // 毫秒内序列掩码 4095
    private static long sequenceMask = -1L ^ (-1L << sequenceBits);
    // 上次生成ID的时间戳
    private static long lastTimestamp = -1L;

    static {
        workerId = 1;  // 设置 workerId 和 datacenterId
        datacenterId = 1;
    }

    public static synchronized String nextBid() {
        return String.valueOf(nextId());
    }

    /**
     * 生成下一个ID
     * @return id
     */
    public static synchronized long nextId() {
        long timestamp = timeGen();
        // 如果当前时间小于上一次ID生成的时间戳，说明系统时钟回退过，这个时候应当抛出异常
        // 这里是为了防止时钟回拨导致生成的ID重复
        // 一般情况下，如果时钟回拨，会等待1s，直到时间追上
        // 这里暂时不处理，静默等待1s
        if (timestamp < lastTimestamp) {
            // 异常处理
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                System.out.println("时钟回拨，等待1s");
                throw new RuntimeException(e);
            }
        }
        // 如果是同一时间生成的，则进行毫秒内序列
        if (lastTimestamp == timestamp) {
            sequence = (sequence + 1) & sequenceMask;
            // 毫秒内序列溢出
            if (sequence == 0) {
                // 阻塞到下一个毫秒，获得新的时间戳
                timestamp = tilNextMillis(lastTimestamp);
            }
        // 时间戳改变，毫秒内序列重置
        } else {
            sequence = 0;
        }
        // 上次生成ID的时间戳
        lastTimestamp = timestamp;
        // 移位并通过或运算拼到一起组成64位的ID
        return ((timestamp - twepoch) << timestampLeftShift) |
                (datacenterId << datacenterIdShift) |
                (workerId << workerIdShift) |
                sequence;
    }

    /**
     * 阻塞到下一个毫秒，直到获得新的时间戳
     * @param lastTimestamp 上次生成ID的时间戳
     * @return 当前时间戳
     */
    private static long tilNextMillis(long lastTimestamp) {
        long timestamp = timeGen();
        while (timestamp <= lastTimestamp) {
            timestamp = timeGen();
        }
        return timestamp;
    }

    /**
     * 获取当前时间戳-以毫秒为单位
     * @return ms
     */
    private static long timeGen() {
        return System.currentTimeMillis();
    }


    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {
            long nextId = nextId();
            System.out.println(nextId + "_" + Long.toBinaryString(nextId));
        }
    }
}
