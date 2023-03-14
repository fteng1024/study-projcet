package com.fly.propreties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author <a href="mailto:fteng1024@gmail.com"> tengfei
 * @since 2023/2/20
 */
@ConfigurationProperties("fly.mybatis")
@Getter
@Setter
public class FlyMyBatisProperties {
    private String url;
}
