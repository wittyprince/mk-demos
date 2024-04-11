package com.mk.demos.agent.application;

/**
 * MyAtm
 *
 * @author WangChen
 * Created on 2024/4/10
 * @since 1.0
 */
public class MyAtm {

    private static final int account = 10;

    public static void withdrawMoney(int amount) throws InterruptedException {
        Thread.sleep(2000L); //processing going on here
        System.out.println("[Application] Successful Withdrawal of [" + amount + "] units!");

    }
}
