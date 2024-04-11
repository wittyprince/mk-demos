package com.mk.demos.agent.application;

import com.sun.tools.attach.VirtualMachine;

import java.io.File;
import java.util.Optional;

/**
 * AgentLoader
 *
 * @author WangChen
 * Created on 2024/4/10
 * @since 1.0
 */
public class AgentLoader {

    public static void run(String[] args) {
        String rootPath = "D:/Gitspace/mk/mk-demos/agent-demo/";
        String jarFilePath = args[1];//"target/agent-demo-jar-with-dependencies.jar";
        String agentFilePath = rootPath + jarFilePath;
        String applicationName = "MyAtmApplication";

        //iterate all jvms and get the first one that matches our application name
        Optional<String> jvmProcessOpt = Optional.ofNullable(VirtualMachine.list()
                .stream()
                .filter(jvm -> {
                    System.out.println("jvm:" + jvm.displayName());
                    return jvm.displayName().contains(applicationName);
                })
                .findFirst().get().id());

        if(!jvmProcessOpt.isPresent()) {
            System.err.println("Target Application not found");
            return;
        }
        File agentFile = new File(agentFilePath);
        try {
            String jvmPid = jvmProcessOpt.get();
            System.out.println("Attaching to target JVM with PID: " + jvmPid);
            VirtualMachine jvm = VirtualMachine.attach(jvmPid);
            jvm.loadAgent(agentFile.getAbsolutePath());
            jvm.detach();
            System.out.println("Attached to target JVM and loaded Java agent successfully");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
