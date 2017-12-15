package com.zuul;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import javax.servlet.http.HttpServletRequest;

public class AccessFilter extends ZuulFilter {
    /**
     * 过滤器类型，决定过滤器在请求的哪个生命周期执行
     * pre：可以在请求被路由之前调用
     * route：在路由请求时候被调用
     * post：在route和error过滤器之后被调用
     * error：处理请求时发生错误时被调用
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 过滤器执行顺序
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 判断该过滤是否需要被执行 ture为需要，false为不需要
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器具体逻辑
     * @return
     */
    @Override
    public Object run() {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        Object token = request.getParameter("token");
        if(token == null){
            /**令zuul过滤该请求，不进行路由*/
            context.setSendZuulResponse(false);
            context.setResponseStatusCode(401);
            /**返回错误内容*/
            context.setResponseBody("{\"result\":\"token is not correct!\"}");
            return null;
        }
        return null;
    }
}
