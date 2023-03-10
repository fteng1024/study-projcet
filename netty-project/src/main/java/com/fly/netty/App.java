package com.fly.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.util.UUID;

/**
 * Hello world!
 */
public class App {
    
    public static void main(String[] args) {
        String uuid = UUID.randomUUID().toString();
        System.out.println(uuid.length());
    }
    
    /*public static void main(String[] args) {
        // 主线程
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        // 表示工作线程数
        EventLoopGroup workGroup = new NioEventLoopGroup(4);
        // BootStrap
        ServerBootstrap bootstrap = new ServerBootstrap();
        bootstrap.group(bossGroup, workGroup).channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        socketChannel.pipeline().addLast(new NormalMessageHandler()); // 处理IO事件
                    }
                });
        try {
            ChannelFuture future = bootstrap.bind(8080).sync();
            System.out.println("Netty Server Started Success: listener port:8080");
            future.channel().closeFuture().sync(); // 同步等待服务端监听端口关闭
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            workGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }
    }*/
}
