package top.fedoseev.adm01.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import top.fedoseev.adm01.model.Traffic;
import top.fedoseev.adm01.service.TrafficService;

import java.util.List;

public abstract class AbstractTrafficController {
    protected final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private TrafficService service;

    public List<Traffic> getAll() {
        log.info("getAll");
        return service.getAll();
    }

    public Traffic get(int id) {
        log.info("get " + id);
        return service.get(id);
    }

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
