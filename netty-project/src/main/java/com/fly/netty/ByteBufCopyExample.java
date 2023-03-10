package com.fly.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;

/**
 * @author <a href="mailto:fteng1024@gmail.com"> tengfei
 * @since 1.0.0 2023/3/10
 */
public class ByteBufCopyExample extends BaseExample {
    
    public static void main(String[] args) {
        // 零拷贝机制，拆包 粘包
        ByteBuf buf = ByteBufAllocator.DEFAULT.buffer();
        buf.writeBytes(new byte[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        log(buf);
        ByteBuf buf1 = buf.slice(0, 5);
        ByteBuf buf2 = buf.slice(5, 5);
        log(buf1);
        log(buf2);
        System.out.println("修改原始数据");
        buf.setByte(2, 8);
        log(buf1);
    }
    
}
