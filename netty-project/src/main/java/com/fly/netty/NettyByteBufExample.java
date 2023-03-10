package com.fly.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.ByteBufUtil;

/**
 * @author <a href="mailto:fteng1024@gmail.com"> tengfei
 * @since 1.0.0 2023/3/10
 */
public class NettyByteBufExample extends BaseExample {
    
    public static void main(String[] args) {
        ByteBuf buf = ByteBufAllocator.DEFAULT.buffer();
        System.out.println("=========== before ===========");
        log(buf);
        StringBuilder stringBuilder = new StringBuilder();
        
        for (int i = 0; i < 40; i++) {
            stringBuilder.append("-" + i);
        }
        buf.writeBytes(stringBuilder.toString().getBytes());
        System.out.println("=========== after  ===========");
        // 读取2个字节
        buf.readShort();
        // 读取1个字节
        buf.readByte();
        // byte short long int double floor boolean char
        log(buf);
    }
    
    
}
