package com.iphotowalking.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * zuul安全过滤器
 *
 * @author jianglz
 * @since 2018/3/1.
 */
@Component
public class MyFilter extends ZuulFilter {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    //返回一个字符串代表过滤器的类型，在zuul中定义了四种不同生命周期的过滤器类型
    //pre：路由之前 routing：路由之时 post： 路由之后 error：发送错误调用
    @Override
    public String filterType() {
        return "pre";
    }

    //过滤的顺序
    @Override
    public int filterOrder() {
        return 0;
    }

    //shouldFilter：这里可以写逻辑判断，是否要过滤。true,永远过滤。
    @Override
    public boolean shouldFilter() {
        return true;
    }

    //过滤器的具体逻辑
    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        logger.info(String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString()));
        Object accessToken = request.getParameter("token");
        if (accessToken == null) {
            logger.error("token is empty");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            try {
                ctx.getResponse().getWriter().write("token is empty");
            } catch (Exception e) {
                e.printStackTrace();
            }

            return null;
        }
        logger.info("ok");
        return null;
    }
}
