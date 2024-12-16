package com.mk.demos.reactor.nio.single_reactor;

/**
 * SingleMain
 *
 * @author WangChen
 * Created on 2024/12/16
 * @since 1.0
 */
public class SingleMain {

    public static void main(String[] args) {
        SingleReactor reactor = new SingleReactor(9090);
//        reactor.run();
        Thread thread = new Thread(reactor);
        thread.start();
    }
}
