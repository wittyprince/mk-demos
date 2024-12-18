package com.mk.demos.netty;


import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

/**
 * NettyClientHandler
 *
 * @author WangChen
 * Created on 2024/12/18
 * @since 1.0
 */
/**
 * 自定义一个 Handler，需要继承 Netty 规定好的某个 HandlerAdapter（规范）
 * InboundHandler 用于处理数据流入本端（客户端）的 IO 事件
 * OutboundHandler 用于处理数据流出本端（客户端）的 IO 事件
 */
public class NettyClientHandler extends ChannelInboundHandlerAdapter {

    /**
     * 通道就绪时执行
     *
     * @param ctx 上下文对象
     * @throws Exception 异常
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
//        super.channelActive(ctx);

        // 向服务器发送数据
        ctx.writeAndFlush(
                // Unpooled 类是 Netty 提供的专门操作缓冲区的工具类，
                // copiedBuffer 方法返回的 ByteBuf 对象类似于
                // NIO 中的 ByteBuffer，但性能更高
                Unpooled.copiedBuffer(
                        "hello server!",
                        CharsetUtil.UTF_8
                )
        );
    }

    /**
     * 当通道有数据可读时执行
     *
     * @param ctx 上下文对象
     * @param msg 服务器端发送的数据
     * @throws Exception 异常
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//        super.channelRead(ctx, msg);

        // 接收服务器端发来的数据
        System.out.println("server address: " + ctx.channel().remoteAddress());

        // ByteBuf 是 Netty 提供的类，比 NIO 的 ByteBuffer 性能更高
        ByteBuf byteBuf = (ByteBuf) msg;
        System.out.println("data from server: " + byteBuf.toString(CharsetUtil.UTF_8));
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

        // 关闭与服务器端的 Socket 连接
        ctx.channel().close();
    }
}
