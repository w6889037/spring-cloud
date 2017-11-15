package ribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huxc
 */
@RestController
public class ConsumerController {

    @Autowired
    HelloService helloService;

    @RequestMapping(value = "/ribbonConsumer", method = RequestMethod.GET)
    public String ribbonConsumer() {
        String retMsg = helloService.helloService();
        return retMsg;
    }
}
