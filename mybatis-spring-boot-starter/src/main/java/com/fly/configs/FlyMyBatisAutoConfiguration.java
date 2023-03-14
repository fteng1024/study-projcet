package com.fly.configs;

import com.fly.propreties.FlyMyBatisProperties;
import com.fly.temp.FlyMyBatisTemplate;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author <a href="mailto:fteng1024@gmail.com"> tengfei
 * @since 2023/2/20
 */
@Configuration
@EnableConfigurationProperties(FlyMyBatisProperties.class)
public class FlyMyBatisAutoConfiguration {

    @Bean
    public FlyMyBatisTemplate flyMyBatisTemplate() {
        return new FlyMyBatisTemplate();
    }

}
