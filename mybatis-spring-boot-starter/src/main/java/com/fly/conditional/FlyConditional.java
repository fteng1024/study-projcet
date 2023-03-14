package com.fly.conditional;

import org.springframework.context.annotation.Conditional;

import java.lang.annotation.*;

/**
 * @author <a href="mailto:fteng1024@gmail.com"> tengfei
 * @since 2023/2/20
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Conditional(OnFlyConditional.class)
public @interface FlyConditional {
}
