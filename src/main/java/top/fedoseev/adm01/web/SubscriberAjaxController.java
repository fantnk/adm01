package top.fedoseev.adm01.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.fedoseev.adm01.model.SubscriberTo;
import top.fedoseev.adm01.service.SubscriberService;

import java.util.List;

@RestController
@RequestMapping("/ajax/subscriber")
public class SubscriberAjaxController {

    @Autowired
    private SubscriberService service;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<SubscriberTo> get(@RequestParam("query") long accountNumber) {
        return service.get(accountNumber);
    }

    /*@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<SubscriberTo> get(@PathVariable("query") long accountNumber) {
        return service.get(accountNumber);
    }*/

}
