package com.mk.demos.design.pattern.proxy.dynamic;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Arrays;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileManager;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

import com.mk.demos.design.pattern.proxy.Car;
import com.mk.demos.design.pattern.proxy.Movable;

/**
 * 动态代理类-模拟JDK的动态代理类Proxy
 *
 * 需求：
 * 对Car生成一个动态代理类，在Car#move方法前后增加自己的业务逻辑
 *
 * @author WangChen
 * Created on 2021/1/11 20:43
 * @since 1.0
 */
public class Proxy {

    public static Object newProxyInstance(Class<?> interfaces, InvocationHandler handler) throws Exception{
        StringBuilder methodStr = new StringBuilder();
        Method[] methods = interfaces.getMethods();
        /*for (Method method : methods){
            methodStr.append(   "    @Override\n" +
                                "    public void " + method.getName() + "() {\n" +
                                        // 现在想把代理逻辑也动态生成 System.out.println("TimeProxy start...")
                                        // 思路动态生成代理逻辑，定义方法调用处理器InvocationHandler
                                        // 所有想要增加的代理逻辑都有InvocationHandler来增加
                                "        System.out.println(\"TimeProxy start...\");\n" +
                                "        movable." + method.getName() + "();\n" +
                                "        System.out.println(\"TimeProxy end...\");\n" +
                                "    }\n"
            );
        }*/
        for (Method method : methods){
            methodStr.append(   "    @Override\n" +
                    "    public void " + method.getName() + "() {\n" +
                    // 现在想把代理逻辑也动态生成 System.out.println("TimeProxy start...")
                    // 思路动态生成代理逻辑，定义方法调用处理器InvocationHandler
                    // 所有想要增加的代理逻辑都有InvocationHandler来增加
//                    "        System.out.println(\"TimeProxy start...\");\n" +
//                    "        movable." + method.getName() + "();\n" +
//                    "        System.out.println(\"TimeProxy end...\");\n" +
                    "        try{\n" +
                    "        Method md = " + interfaces.getName() + ".class.getMethod(\""+ method.getName() +"\");\n" +
                    "        handler.invoke(this, md, null);\n" +
                    "        }catch(Throwable t){t.printStackTrace();}\n" +
                    "    }\n"
            );
        }

        // 假设已经获得了Car的动态代理类代码
        String proxyStr = // 下面的字符串是直接从com.mk.demos.design.pattern.proxy.jstatic.CarTimeProxy类中copy过来的
                "package com.mk.demos.design.pattern.proxy.dynamic;\n" +
                        "\n" +
                        "import java.lang.reflect.Method;\n" +
                        "import com.mk.demos.design.pattern.proxy.Movable;\n" +
                        "\n" +
                        "public class CarTimeProxy implements " + interfaces.getName() +" {\n" +
                        "    public CarTimeProxy() {\n" +
                        "    }\n" +
                        "\n" +
                        "    private InvocationHandler handler;\n" +
                        "\n" +
                        "    public CarTimeProxy(InvocationHandler handler) {\n" +
                        "        this.handler = handler;\n" +
                        "    }\n" +
                        "\n" +
//                        "    @Override\n" +
//                        "    public void move() {\n" +
//                        "        System.out.println(\"TimeProxy start...\");\n" +
//                        "        movable.move();\n" +
//                        "        System.out.println(\"TimeProxy end...\");\n" +
//                        "    }\n" +
                        methodStr.toString() +
                        "}\n";
        // System.getProperty("user.dir") = D:\Gitspace\mk\mk-demos\design-pattern
        String pathname = System.getProperty("user.dir") + "/src/main/resources/com/mk/demos/design/pattern/proxy/dynamic/CarTimeProxy.java";
        File file = new File(pathname);
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(proxyStr);
        fileWriter.flush();
        fileWriter.close();
        // 至此，已经在 System.getProperty("user.dir") 目录下生成了代理类的.java源文件
        // 现在把.class源文件编译成.class二进制文件，使用Java Compiler API
        // 获取JavaCompiler
        JavaCompiler javaCompiler = ToolProvider.getSystemJavaCompiler();
        // 获取Java FileManager
        StandardJavaFileManager standardFileManager = javaCompiler.getStandardFileManager(null, null, null);
        // 从.java源文件获取Java FileObject
        Iterable<? extends JavaFileObject> javaFileObjects = standardFileManager.getJavaFileObjects(file);
        // 获取task编译任务
        JavaCompiler.CompilationTask task = javaCompiler.getTask(null, standardFileManager, null, null, null, javaFileObjects);
        task.call();// 编译
        standardFileManager.close();// 关闭文件管理器
        // 至此，已经在 System.getProperty("user.dir") 目录下生成了代理类的.class二进制文件

        // 现在需要把.class二进制文件load到内存中
        // 使用URLClassLoader
        // 注意这里需要使用 "file:/"
        String classToLoadPath = "file:/" + System.getProperty("user.dir").replaceAll("\\\\", "/") + "/src/main/resources/";
        System.out.println("classToLoadPath: " + classToLoadPath);
        URL[] urls = new URL[]{new URL(classToLoadPath)};
        URLClassLoader urlClassLoader = new URLClassLoader(urls);
        Class<?> loadClass = urlClassLoader.loadClass("com.mk.demos.design.pattern.proxy.dynamic.CarTimeProxy");
        System.out.println(loadClass.getName());
        // 至此，已将代理类加载到内存
        // 下面生产代理类实例instance
        Constructor<?> constructor = loadClass.getConstructor(InvocationHandler.class);
        Object o = constructor.newInstance(handler);
        return o;
    }

    public static void main(String [] args) throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        // 注意：如果这里拿到的compiler为null，则可能与配置有关，这里需要配置工程的运行环境为jdk，而不是jre
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        System.out.println(compiler.getClass().getName());
        StandardJavaFileManager javaFileManager = compiler.getStandardFileManager(null, null, null);
        String absolutePath = "D:\\Gitspace\\mk\\mk-demos\\design-pattern\\src\\main\\java\\com\\mk\\demos\\design\\pattern\\proxy\\jstatic\\CarTimeProxy.java";
        Iterable<? extends JavaFileObject> javaFileObjects = javaFileManager.getJavaFileObjects(absolutePath);
        JavaCompiler.CompilationTask task = compiler.getTask(null, javaFileManager, null, null, null, javaFileObjects);
        task.call();// 编译
        javaFileManager.close();

        // load到内存，
        URL[] urls = new URL[]{new URL("file:/" + System.getProperty("user.dir") + "/src")};
        // 通过URLClassLoader可以加载定义在任何地方的.class二进制文件，如来自网络等
        URLClassLoader urlClassLoader = new URLClassLoader(urls);
        String className = "com.mk.demos.design.pattern.proxy.jstatic.CarTimeProxy";
        Class<?> loadClass = urlClassLoader.loadClass(className);
        System.out.println(loadClass);

        // 生成实例 create an instance
        Constructor<?>[] constructors = loadClass.getConstructors();
        Arrays.stream(constructors).forEach(System.out::println);
        Constructor<?> constructor = loadClass.getConstructor(null);
        System.out.println("null parameter: " + constructor);
        // 获取loadClass的构造方法
        Constructor<?> movableConstructor = loadClass.getConstructor(Movable.class);
        // 生成实例
        Movable o = (Movable) movableConstructor.newInstance(new Car());
        // 调用方法
        o.move();
    }
}
