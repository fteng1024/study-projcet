package com.fly.order;

import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingFactory;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.listener.Event;
import com.alibaba.nacos.api.naming.listener.EventListener;
import com.alibaba.nacos.api.naming.listener.NamingEvent;
import org.springframework.boot.SpringApplicationRunListener;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

/**
 * @author <a href="mailto:tengfei-zj@zhaojiling.com"> tengfei
 * @since 2023/2/27
 */
public class TestRegister {
    /*public static void main(String[] args) throws NacosException {
        
        Properties properties = new Properties();
        properties.setProperty("serverAddr", System.getProperty("serverAddr"));
        properties.setProperty("namespace", System.getProperty("namespace"));
        
        NamingService naming = NamingFactory.createNamingService(properties);
        
        naming.registerInstance("nacos.naming.serviceName", "11.11.11.11", 8888, "TEST1");
        
        naming.registerInstance("nacos.naming.serviceName", "2.2.2.2", 9999, "DEFAULT");
        
        System.out.println(naming.getAllInstances("nacos.naming.serviceName"));
        
        naming.deregisterInstance("nacos.naming.serviceName", "2.2.2.2", 9999, "DEFAULT");
        
        System.out.println(naming.getAllInstances("nacos.naming.serviceName"));
        
        naming.subscribe("nacos.naming.serviceName", new EventListener() {
            @Override
            public void onEvent(Event event) {
                System.out.println(((NamingEvent)event).getServiceName());
                System.out.println(((NamingEvent)event).getInstances());
            }
        });
    }*/
    
    public static void main(String[] args) {
        // 在堆中创建字符串对象”ab“
        // 将字符串对象”ab“的引用保存在字符串常量池中
        String aa = "ab";
        // 直接返回字符串常量池中字符串对象”ab“的引用
        String bb = "ab";
        System.out.println(aa.equals(bb));// true
    }
    
    private static int getMonthByStrDate(String date){
        return LocalDateTime.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")).getMonth().getValue();
    }
}
