package controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/example")
public class ExampleController {

    @RequestMapping(method = RequestMethod.GET,value = "/hello")
    public String example() {
        return "hello";
    }

}
