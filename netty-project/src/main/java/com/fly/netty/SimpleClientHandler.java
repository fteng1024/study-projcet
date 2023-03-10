package com.fly.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.nio.charset.StandardCharsets;
import java.util.UUID;

/**
 * @author <a href="mailto:fteng1024@gmail.com"> tengfei
 * @since 1.0.0 2023/3/10
 */
public class SimpleClientHandler extends ChannelInboundHandlerAdapter {
    
    private int count;
    
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("客户端连接建立成功");
        for (int i = 0; i < 10; i++) {
            ByteBuf buf = Unpooled.copiedBuffer(UUID.randomUUID().toString(), StandardCharsets.UTF_8);
            ctx.writeAndFlush(buf);
        }
        super.channelActive(ctx);
    }
    
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("收到服务端返回的消息");
        
        ByteBuf buf = (ByteBuf) msg;
        byte[] data = new byte[buf.readableBytes()];
        buf.readBytes(data);
        String message = new String(data, StandardCharsets.UTF_8);
        System.out.println("收到客户端的消息内容" + message);
        System.out.println("收到客户端的数量" + (++count));
        super.channelRead(ctx, msg);
    }
}
