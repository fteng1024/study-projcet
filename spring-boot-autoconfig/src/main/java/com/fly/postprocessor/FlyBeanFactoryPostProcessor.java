package com.fly.postprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * @author <a href="mailto:fteng1024@gmail.com"> tengfei
 * @since 2023/2/20
 */
@Component
public class FlyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        System.out.println("FlyBeanFactoryPostProcessor.postProcessBeanFactory");
    }
}
