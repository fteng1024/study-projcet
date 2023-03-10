package com.fly.zkconfig.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.lang.reflect.Field;

/**
 * @author <a href="mailto:tengfei-zj@zhaojiling.com"> tengfei
 * @since 2023/3/6
 */
@Getter
@Setter
@NoArgsConstructor
public class FieldDetail {
    
    private Field field;
    
    private Object instance;
    
    public FieldDetail(Field field, Object instance) {
        this.field = field;
        this.instance = instance;
    }
}
