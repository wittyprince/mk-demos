package com.mk.demos.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

/**
 * NettyServerHandler
 *
 * @author WangChen
 * Created on 2024/12/18
 * @since 1.0
 */
/**
 * 自定义一个 Handler，需要继承 Netty 规定好的某个 HandlerAdapter（规范）
 * InboundHandler 用于处理数据流入本端（服务端）的 IO 事件
 * OutboundHandler 用于处理数据流出本端（服务端）的 IO 事件
 */
public class NettyServerHandler extends ChannelInboundHandlerAdapter {


    /**
     * 当通道有数据可读时执行
     *
     * @param ctx 上下文对象，可以从中取得相关联的 Pipeline、Channel、客户端地址等
     * @param msg 客户端发送的数据
     * @throws Exception 异常
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//        super.channelRead(ctx, msg);

        // 接收客户端发来的数据
        System.out.println("client address: " + ctx.channel().remoteAddress());

        // ByteBuf 是 Netty 提供的类，比 NIO 的 ByteBuffer 性能更高
        ByteBuf byteBuf = (ByteBuf) msg;
        System.out.println("data from client: " + byteBuf.toString(CharsetUtil.UTF_8));
    }

    /**
     * 数据读取完毕后执行
     *
     * @param ctx 上下文对象
     * @throws Exception 异常
     */
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
//        super.channelReadComplete(ctx);

        // 发送响应给客户端
        ctx.writeAndFlush(
                // Unpooled 类是 Netty 提供的专门操作缓冲区的工具 类，
                // copiedBuffer 方法返回的 ByteBuf 对象类似于
                // NIO 中的 ByteBuffer，但性能更高
                Unpooled.copiedBuffer("hello client! i have got your data.", CharsetUtil.UTF_8)
        );
    }

    /**
     * 发生异常时执行
     *
     * @param ctx   上下文对象
     * @param cause 异常对象
     * @throws Exception 异常
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
//        super.exceptionCaught(ctx, cause);

        // 关闭与客户端的 Socket 连接
        ctx.channel().close();
    }
}
