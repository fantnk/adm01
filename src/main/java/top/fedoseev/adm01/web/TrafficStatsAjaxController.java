package top.fedoseev.adm01.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.fedoseev.adm01.service.TrafficStatsService;
import top.fedoseev.adm01.to.TrafficStats;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/ajax/trafficstats")
public class TrafficStatsAjaxController {

    @Autowired
    private TrafficStatsService trafficStatService;

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public TrafficStats getSubscriberTrafficStat(
            @RequestParam(value = "startDate") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm") LocalDateTime startDate,
            @RequestParam(value = "endDate") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm") LocalDateTime endDate,
            @RequestParam(value = "accountNumber") long accountNumber,
            @RequestParam(value = "linkType") TrafficStats.LinkType linkType) {

        return trafficStatService.getSubscriberTrafficStat(new TrafficStats(startDate, endDate, accountNumber, linkType));
    }
}
