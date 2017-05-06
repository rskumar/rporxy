package com.xav.filters;

import javax.servlet.http.HttpServletRequest;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.ZuulFilter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class SimplePreFilter extends ZuulFilter {

    private static Logger log = LoggerFactory.getLogger(SimplePreFilter.class);

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.info("=================================================================");
        log.info(String.format("Zuul/Filter/SimplePreFilter: [Request] %s -> %s", request.getMethod(), request.getRequestURL().toString()));
        ctx.addZuulRequestHeader("X-ZRequest-Header", "Zuul/SimplePreFilter");
        ctx.addOriginResponseHeader("X-OResponse-Header", "Zuul/SimplePreFilter");
        return null;
    }

}