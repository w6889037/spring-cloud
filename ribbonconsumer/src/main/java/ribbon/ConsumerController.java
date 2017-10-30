package ribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author huxc
 */
@RestController
public class ConsumerController {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value="/ribbonConsumer",method = RequestMethod.GET)
    public String ribbonConsumer(){
        String retMsg = restTemplate.getForEntity("http://HELLO-SERVICE/hello",String.class).getBody();
        return retMsg;
    }
}
