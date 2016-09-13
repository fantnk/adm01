package top.fedoseev.adm01.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import top.fedoseev.adm01.service.TrafficService;

@Controller
public class RootController {
    @Autowired
    private TrafficService service;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String root() {
        return "index";
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String trafficList(Model model) {
        model.addAttribute("trafficList", service.getAll());
        return "trafficList";
    }

}
