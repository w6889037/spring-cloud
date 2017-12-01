package hello;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;


@RestController
public class HelloController {

    private Logger logger = Logger.getLogger(getClass());
    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        ServiceInstance instance = client.getLocalServiceInstance();
        logger.info("host:" + instance.getHost() + "," + "serviceId:" + instance.getServiceId());
        return "Hello World";
    }

    @RequestMapping(value = "/hello1", method = RequestMethod.GET)
    public String hello1(@RequestParam("name") String name){
        return name;
    }

    @RequestMapping(value = "/hello2", method = RequestMethod.GET)
    public String hello2(@RequestHeader("name") String name, @RequestHeader("age") int age){
        return name + "今年" + age;
    }

    @RequestMapping(value = "/hello3", method = RequestMethod.POST)
    public String hello3(@RequestBody User user){
        return "Hello " + user.getName() + "," + user.getAge();
    }
}
