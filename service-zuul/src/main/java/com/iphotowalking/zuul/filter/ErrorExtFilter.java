package com.iphotowalking.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.post.SendErrorFilter;

/**
 * 全局异常处理(扩展）
 * @author jianglz
 * @since 2018/3/5.
 */
public class ErrorExtFilter extends SendErrorFilter{
    private final Logger log = LoggerFactory.getLogger(ErrorExtFilter.class);

    @Override
    public String filterType() {
        return "error";
    }

    @Override
    public int filterOrder() {
        return 30; // 大于ErrorFilter的值
    }

    @Override
    public boolean shouldFilter() {
        // TODO 判断：仅处理来自post过滤器引起的异常
        RequestContext ctx = RequestContext.getCurrentContext();
        ZuulFilter failedFilter = (ZuulFilter) ctx.get("failed.filter");
        return failedFilter != null && failedFilter.filterType().equals("post");
    }
}
