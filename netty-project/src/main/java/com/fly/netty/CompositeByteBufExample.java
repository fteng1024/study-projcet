package com.fly.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.CompositeByteBuf;
import io.netty.buffer.Unpooled;

/**
 * @author <a href="mailto:fteng1024@gmail.com"> tengfei
 * @since 1.0.0 2023/3/10
 */
public class CompositeByteBufExample extends BaseExample {
    
    public static void main(String[] args) {
        ByteBuf header = ByteBufAllocator.DEFAULT.buffer();
        header.writeBytes(new byte[] {1, 2, 3, 4, 5});
        ByteBuf body = ByteBufAllocator.DEFAULT.buffer();
        body.writeBytes(new byte[] {6, 7, 8, 9, 10});
        // example.1
        //        ByteBuf total = Unpooled.buffer(header.readableBytes() + body.readableBytes());
        
        //        total.writeBytes(header);
        //        total.writeBytes(body);
        // example.2
        /*CompositeByteBuf compositeByteBuf = Unpooled.compositeBuffer();
        compositeByteBuf.addComponents(true, header, body);
        log(compositeByteBuf);*/
        
        // example.3
        ByteBuf total = Unpooled.wrappedBuffer(header,body);
        log(total);
        header.setByte(2,9);
        log(total);
    }
    
}
