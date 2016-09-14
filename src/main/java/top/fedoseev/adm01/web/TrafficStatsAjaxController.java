package top.fedoseev.adm01.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import top.fedoseev.adm01.model.TrafficStats;
import top.fedoseev.adm01.service.TrafficStatsService;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/ajax/trafficstats")
public class TrafficStatsAjaxController {

    @Autowired
    private TrafficStatsService service;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public TrafficStats getAll() {
        return service.getSubscriberTrafficStats(LocalDateTime.MIN, LocalDateTime.MAX, 9000000006L,
                TrafficStats.LinkType.DOWNLINK);
    }
    /*@Override
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Traffic> getStat() {
        return super.getStat();
    }*/

    /*@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") int id) {
        super.delete(id);
    }*/

}
