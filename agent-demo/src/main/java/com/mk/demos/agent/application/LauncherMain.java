package com.mk.demos.agent.application;

/**
 * Launcher
 *
 * @author WangChen
 * Created on 2024/4/10
 * @since 1.0
 */
public class LauncherMain {

    public static void main(String[] args) throws Exception {
        if(args.length == 0) {
            System.err.println("Please provide an argument to run the application");
            return;
        }
        if(args[0].equals("StartMyAtmApplication")) {
            MyAtmApplication.run(args);
        } else if(args[0].equals("LoadAgent")) {
            AgentLoader.run(args);
        }
        System.out.println("no application run...");
    }
}
