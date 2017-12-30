package com.cloud.configclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class TestController {

    @Value("${from}")
    private String from;

    @Autowired
    private Environment env;

    @RequestMapping(value = "/from", method = RequestMethod.GET)
    public String from(){
        return from;
    }

    @RequestMapping(value = "/env", method = RequestMethod.GET)
    public String env(){
        return env.getProperty("from", "undefined");
    }
}
