package top.fedoseev.adm01.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import top.fedoseev.adm01.model.Traffic;
import top.fedoseev.adm01.service.TrafficService;
import top.fedoseev.adm01.service.TrafficStatService;
import top.fedoseev.adm01.to.TrafficStat;

import java.time.LocalDateTime;
import java.util.List;

public abstract class AbstractTrafficController {
    protected final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private TrafficService trafficService;

    @Autowired
    private TrafficStatService trafficStatService;

    public List<Traffic> getAll() {
        log.info("getAll");
        return trafficService.getAll();
    }

    public TrafficStat getSubscriberTrafficStat(LocalDateTime startDate, LocalDateTime endDate, long accountNumber,
                                                TrafficStat.LinkType linkType) {
        /*TrafficStat trafficStat = new TrafficStat(LocalDateTime.of(2016, 9, 8, 0, 0),
                LocalDateTime.of(2016, 9, 8, 14, 0), 30502L, TrafficStat.LinkType.DOWNLINK);*/

        TrafficStat trafficStat = new TrafficStat(startDate, endDate, accountNumber, linkType);

        log.info("getSubscriberTrafficStat");

        return trafficStatService.getSubscriberTrafficStat(trafficStat);
    }

    /*public Traffic findByAccountNumberPart(int id) {
        log.info("findByAccountNumberPart " + id);
        return service.findByAccountNumberPart(id);
    }*/

    /*public Traffic create(Traffic traffic) {
        traffic.setId(null);
        log.info("create " + traffic);
        return service.save(traffic);
    }

    public void delete(int id) {
        log.info("delete " + id);
        service.delete(id);
    }

    public void update(Traffic traffic, int id) {
        traffic.setId(id);
        log.info("update " + traffic);
        service.update(traffic);
    }*/
}
