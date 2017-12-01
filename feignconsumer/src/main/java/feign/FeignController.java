package feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class FeignController {

    @Autowired
    private FeignService feignService;

    @RequestMapping(value="/helloFeign", method = RequestMethod.GET)
    public String helloFeign(){
        return feignService.hello();
    }

    @RequestMapping(value = "/hello1", method = RequestMethod.GET)
    public String hello1(@RequestParam("name") String name){
        return feignService.hello1(name);
    }

    @RequestMapping(value = "/hello2", method = RequestMethod.GET)
    public String hello2(@RequestParam("name") String name, @RequestParam("age") int age){
        return feignService.hello2(name, age);
    }

    @RequestMapping(value = "/hello3", method = RequestMethod.GET)
    public String hello3(){
        User user = new User();
        user.setName("张三");
        user.setAge(21);
        return feignService.hello3(user);
    }
}
