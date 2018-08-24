package stayblank;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Consumer Controller
 *
 * @author xionghui
 * @since 1.0.0
 */
@RestController
@RequestMapping("/")
public class ConsumerController {


    @Reference(timeout = 1000)
    private CityDubboService cityDubboService;

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    @ResponseBody
    public String hello() {
        String cityName="温岭";
        City city = cityDubboService.findCityByName(cityName);
        System.out.println(city.toString());
        return city.toString();
    }
}
