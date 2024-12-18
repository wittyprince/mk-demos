package com.mk.demos.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * NettyNIOServer
 *
 * @author WangChen
 * Created on 2024/12/18
 * @since 1.0
 */
public class NettyNIOServer {

    public static void main(String[] args) throws InterruptedException {
        // 创建 BossGroup 和 WorkerGroup
        // 1. bossGroup 只处理连接请求
        // 2. 业务处理由 workerGroup 来完成
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup workerGroup = new NioEventLoopGroup(8);

        try {
            // 创建服务器端的启动对象
            ServerBootstrap bootstrap = new ServerBootstrap();

            // 配置参数
            bootstrap
                    // 设置线程组
                    .group(bossGroup, workerGroup)
                    // 说明服务器端通道的实现类（便于 Netty 做反射处理）
                    .channel(NioServerSocketChannel.class)
                    // 设置等待连接的队列的容量（当客户端连接请求速率大
                    // 于 NioServerSocketChannel 接收速率的时候，会使用
                    // 该队列做缓冲）
                    // option()方法用于给服务端的 ServerSocketChannel
                    // 添加配置
                    .option(ChannelOption.SO_BACKLOG, 128)
                    // 设置连接保活
                    // childOption()方法用于给服务端 ServerSocketChannel
                    // 接收到的 SocketChannel 添加配置
                    .childOption(ChannelOption.SO_KEEPALIVE, true)
                    // handler()方法用于给 BossGroup 设置业务处理器
                    // childHandler()方法用于给 WorkerGroup 设置业务处理器
                    .childHandler(
                            // 创建一个通道初始化对象
                            new ChannelInitializer<SocketChannel>() {
                                // 向 Pipeline 添加业务处理器
                                @Override
                                protected void initChannel(SocketChannel socketChannel) throws Exception {

                                    socketChannel.pipeline().addLast(new NettyServerHandler());

                                    // 可以继续调用 socketChannel.pipeline().addLast()
                                    // 添加更多 Handler
                                }
                            }
                    );

            System.out.println("server is ready...");

            // 绑定端口，启动服务器，生成一个 channelFuture 对象，
            // ChannelFuture 涉及到 Netty 的异步模型，后面展开讲
            ChannelFuture channelFuture = bootstrap.bind(7005).sync();
            // 对通道关闭进行监听
            channelFuture.channel().closeFuture().sync();
        } finally {
            // 关闭线程组
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }

    }
}
