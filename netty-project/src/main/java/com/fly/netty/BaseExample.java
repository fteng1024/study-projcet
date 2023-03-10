package com.fly.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;

/**
 * @author <a href="mailto:fteng1024@gmail.com"> tengfei
 * @since 1.0.0 2023/3/10
 */
public class BaseExample {
    
    protected static void log(ByteBuf buf){
        StringBuilder stringBuilder = new StringBuilder();
        // 读索引
        stringBuilder.append("read index:").append(buf.readerIndex());
        // 写索引
        stringBuilder.append("write index:").append(buf.writerIndex());
        // 容量
        stringBuilder.append("capacity :").append(buf.capacity());
        ByteBufUtil.appendPrettyHexDump(stringBuilder, buf);
        System.out.println(stringBuilder);
    }
    
}
