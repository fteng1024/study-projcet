package com.fly.redis.controller;

import org.redisson.api.RedissonClient;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author <a href="mailto:fteng1024@gmail.com"> tengfei
 * @since 1.0.0 2023/3/16
 */
@RestController
@RequestMapping("/product")
public class ProductController {


    @Resource
    private RedissonClient redissonClient;

    @Resource
    private RedisTemplate redisTemplate;




}
