package top.fedoseev.adm01.web;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.fedoseev.adm01.model.Traffic;
import top.fedoseev.adm01.to.TrafficStat;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/ajax/traffic")
public class TrafficAjaxController extends AbstractTrafficController {

    @Override
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Traffic> getAll() {
        return super.getAll();
    }

    /*@RequestMapping(value = "/between", method = RequestMethod.GET)
    public List<UserMealWithExceed> getBetween(
            @RequestParam(value = "startDateTime") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDateTime,
            @RequestParam(value = "endDateTime") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDateTime) {
        return super.getBetween(startDateTime.toLocalDate(), startDateTime.toLocalTime(), endDateTime.toLocalDate(), endDateTime.toLocalTime());
    }*/

    @Override
    @RequestMapping(value = "/stat", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public TrafficStat getSubscriberTrafficStat(
            @RequestParam(value = "startDate") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm") LocalDateTime startDate,
            @RequestParam(value = "endDate") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm") LocalDateTime endDate,
            @RequestParam(value = "accountNumber") long accountNumber,
            @RequestParam(value = "linkType") TrafficStat.LinkType linkType) {
        return super.getSubscriberTrafficStat(startDate, endDate, accountNumber, linkType);
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
