package com.fly.zkconfig.controller;

import com.fly.zkconfig.annotation.FlyRefreshScope;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.boot.env.OriginTrackedMapPropertySource;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;

import javax.annotation.Resource;

/**
 * @author <a href="mailto:tengfei-zj@zhaojiling.com"> tengfei
 * @since 2023/3/6
 */
@RestController
@RequestMapping("/user")
@FlyRefreshScope
public class UserController {
    
    /**
     * @value 实现原理
     * <ol>
     *     <li>使用 BeanPostProcessor 解析类上的 @value 字段 {@link  AutowiredAnnotationBeanPostProcessor#postProcessProperties}</li>
     *     <li>获取到属性上有 @value 注解的属性</li>
     *     <li>解析 @value 字段的 value 属性值 {@link Value#value()}</li>
     *     <li>从 environment 中的属性配置源 {@link OriginTrackedMapPropertySource }
     *     中寻找 {@link Value#value()} 的 key</li>
     *     <li>根据 key 获取到对应的 value 值</li>
     *     <li>通过 field 反射的方式设置 value 值</li>
     *
     * </ol>
     */
    @Value("${age}")
    private Integer age;
    
    @Value("${hobby}")
    private String hobby;
    
    
    @GetMapping("/config-value")
    public String config() {
        return "age:" + this.age + ", hobby:" + this.hobby;
    }
    
    @Resource
    private Environment environment;
    
    @GetMapping("/config-env")
    public String configEnv() {
        return "age:" + environment.getProperty("age") + ", hobby:" + environment.getProperty("hobby");
    }
    
}
