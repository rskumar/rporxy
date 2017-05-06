package com.xav;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.xav.filters.SimplePreFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

@SpringBootApplication
//@EnableAutoConfiguration
@ComponentScan("com.xav")
@EnableZuulProxy
public class RporxyApplication {

    public static void main(String[] args) {
        SpringApplication.run(RporxyApplication.class, args);
    }

        @Bean
        public SimplePreFilter simpleFilter() {
            return new SimplePreFilter();
        }

    @Bean
    public ZuulFilter zuulFilter(){
        return new ZuulFilter() {
            @Override
            public String filterType() {
                return "post";
            }

            @Override
            public int filterOrder() {
                return 999999;
            }

            @Override
            public boolean shouldFilter() {
                return true;
            }

            @Override
            public Object run() {
                final List<String> routingDebug = (List<String>) RequestContext.getCurrentContext().get("routingDebug");
                routingDebug.forEach(System.out::println);
                return null;
            }
        };
    }
}
