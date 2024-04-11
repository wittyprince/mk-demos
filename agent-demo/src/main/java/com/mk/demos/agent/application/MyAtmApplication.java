package com.mk.demos.agent.application;

/**
 * MyAtmApplication
 *
 * @author WangChen
 * Created on 2024/4/10
 * @since 1.0
 */
public class MyAtmApplication {

    public static void run(String[] args) throws Exception {
        System.out.println("[Application] Starting ATM application");
        MyAtm.withdrawMoney(Integer.parseInt(args[2]));

        Thread.sleep(Long.parseLong(args[1]));

        MyAtm.withdrawMoney(Integer.parseInt(args[3]));
    }
}
