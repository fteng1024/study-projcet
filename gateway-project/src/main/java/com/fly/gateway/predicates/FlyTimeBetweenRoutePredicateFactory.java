package com.fly.gateway.predicates;

import com.fly.gateway.configuration.FlyTimeBetweenConfig;
import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author <a href="mailto:fteng1024@gmail.com"> tengfei
 * @since 1.0.0 2023/3/16
 */
@Component
public class FlyTimeBetweenRoutePredicateFactory extends AbstractRoutePredicateFactory<FlyTimeBetweenConfig> {
    public FlyTimeBetweenRoutePredicateFactory() {
        super(FlyTimeBetweenConfig.class);
    }

    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList("start", "end");
    }

    @Override
    public Predicate<ServerWebExchange> apply(FlyTimeBetweenConfig config) {
        LocalTime start = config.getStart();
        LocalTime end = config.getEnd();

        return (serverWebExchange) -> {
            LocalTime now = LocalTime.now();
            return now.isAfter(start) && now.isBefore(end);
        };
    }

    public static void main(String[] args) {
        System.out.println(DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT).format(LocalTime.now()));
    }
}
