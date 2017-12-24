package com.zuul;

import com.netflix.zuul.ZuulFilter;
import org.springframework.cloud.netflix.zuul.util.ZuulRuntimeException;
import org.springframework.stereotype.Component;

@Component
public class ThrowExceptionFilter extends ZuulFilter{

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
        try {
            doSomething();
        } catch (Exception e) {
            throw new ZuulRuntimeException(e);
        }
        return null;
    }

    private void doSomething(){
        throw new RuntimeException("Exit some errors");
    }
}
