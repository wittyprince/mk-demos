package com.mk.demos.bloom.redis;

import redis.clients.jedis.Jedis;

/**
 * redis bloom filter
 *
 * @author WangChen
 * Created on 2022/2/18
 * @since 0.1
 */
public class JedisClient {

    public static void main(String[] args) {
        //Connecting to Redis server on localhost
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        System.out.println("Connection to server sucessfully");
        //check whether server is running or not
        System.out.println("Server is running: "+jedis.ping());

        System.out.println("Stored string in redis:: "+ jedis.get("myname"));

        //set the data in redis string
        jedis.set("tutorial-name", "Redis tutorial");
        // Get the stored data and print it
        System.out.println("Stored string in redis:: "+ jedis.get("tutorial-name"));

    }
}
