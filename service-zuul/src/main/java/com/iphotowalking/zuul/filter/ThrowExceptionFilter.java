package com.iphotowalking.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletResponse;

/**
 * @author jianglz
 * @since 2018/3/5.
 */
public class ThrowExceptionFilter extends ZuulFilter{
    private final static Logger log = LoggerFactory.getLogger(ThrowExceptionFilter.class);

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        log.info("This is a pre filter, it will throw a RuntimeException");
        RequestContext ctx = RequestContext.getCurrentContext();
        try{
            doSomething();
        }catch (Exception e){
           ctx.set("error.status_code", HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
           ctx.set("error.exception",e);
        }
        return null;
    }

    private void doSomething() {
        throw new RuntimeException("Exist some errors...");
    }
}
