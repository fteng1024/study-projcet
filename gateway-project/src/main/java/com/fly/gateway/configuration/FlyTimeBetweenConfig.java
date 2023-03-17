package com.fly.gateway.configuration;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;

/**
 * @author <a href="mailto:fteng1024@gmail.com"> tengfei
 * @since 1.0.0 2023/3/16
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FlyTimeBetweenConfig {
    /**
     * 开始时间
     */
    private LocalTime start;
    /**
     * 结束时间
     */
    private LocalTime end;
}
