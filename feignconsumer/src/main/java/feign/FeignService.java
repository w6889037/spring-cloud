package feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("hello-service")
public interface FeignService {

    @RequestMapping("/hello")
    String hello();

    @RequestMapping("/hello1")
    String hello1(@RequestParam("name") String name);

    @RequestMapping("/hello2")
    String hello2(@RequestHeader("name") String name, @RequestHeader("age") int age);

    @RequestMapping("/hello3")
    String hello3(@RequestBody User user);
}
