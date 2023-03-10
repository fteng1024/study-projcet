package com.fly.zkconfig.processor.post;

import com.fly.zkconfig.annotation.FlyRefreshScope;
import com.fly.zkconfig.domain.FieldDetail;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @author <a href="mailto:tengfei-zj@zhaojiling.com"> tengfei
 * @since 2023/3/6
 */
@Component
@Slf4j
public class ParseFlyRefreshScopeBeanPostProcessor implements BeanPostProcessor {
    
    @Getter
    private Map<String, FieldDetail> fieldDetailMap = new HashMap<>();
    
    
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Class<?> clazz = bean.getClass();
        if (clazz.isAnnotationPresent(FlyRefreshScope.class)) {
            log.info("clazz:{}", clazz);
            for (Field field : clazz.getDeclaredFields()) {
                if (field.isAnnotationPresent(Value.class)) {
                    Value value = field.getAnnotation(Value.class);
                    String val = value.value();
                    val = val.substring(val.indexOf("{") + 1, val.indexOf("}"));
                    log.info("val:{}", val);
                    this.fieldDetailMap.put(val, new FieldDetail(field, bean));
                }
            }
        }
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
