package com.fly.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.ByteBufUtil;

/**
 * @author <a href="mailto:fteng1024@gmail.com"> tengfei
 * @since 1.0.0 2023/3/10
 */
public class ByteBufCreateExample extends BaseExample{
        
        public static void main(String[] args) {
        // 由 JVM 来管理内存
        ByteBuf buf = ByteBufAllocator.DEFAULT.heapBuffer();
        System.out.println(buf);
        // 堆外内存
        //        ByteBufAllocator.DEFAULT.directBuffer();
        buf.writeBytes(new byte[]{1,2,3,4});
        log(buf);
        buf.writeInt(5);
        log(buf);
    }
    
}
