package com.xav.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by ravi on 5/6/2017.
 */
@Service
public class HeadersRouteFilter extends ZuulFilter {
    private static Logger log = LoggerFactory.getLogger(SimplePreFilter.class);

    @Override
    public String filterType() {
        return "post";
    }

    @Override
    public int filterOrder() {
        return 100;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        ctx.addZuulRequestHeader("X-ZRequest-Header1", "Zuul/SimplePreFilter");
        ctx.addOriginResponseHeader("X-OResponse-Header1", "Zuul/SimplePreFilter");
        return null;
    }
}
