package com.mk.demos.reactor.nio.multi_reactor;

/**
 * MultiMain
 *
 * @author WangChen
 * Created on 2024/12/16
 * @since 1.0
 */
public class MultiMain {

    public static void main(String[] args) {
        MainReactor reactor = new MainReactor(9090);
        Thread thread = new Thread(reactor);
        thread.start();
    }
}
