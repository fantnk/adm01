package top.fedoseev.adm01.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.fedoseev.adm01.repository.TrafficStatsRepository;
import top.fedoseev.adm01.to.TrafficStats;
import top.fedoseev.adm01.util.exception.NotFoundException;

import java.time.temporal.ChronoUnit;

@Service
public class TrafficStatsServiceImpl implements TrafficStatsService {

    private final TrafficStatsRepository repository;

    @Autowired
    public TrafficStatsServiceImpl(TrafficStatsRepository repository) {
        this.repository = repository;
    }

    @Override
    public TrafficStats getSubscriberTrafficStat(TrafficStats trafficStat) {
        trafficStat = repository.getSubscriberTrafficStat(trafficStat);

        if (trafficStat.getBytesTransferred() != 0) {
            trafficStat.setSpeed(8f * (float) trafficStat.getBytesTransferred() /
                    (float) ChronoUnit.SECONDS.between(trafficStat.getStartDate(), trafficStat.getEndDate()));
        } else {
            throw new NotFoundException("Для абонента " + trafficStat.getSubscriber() + " статистика отсутствует.");
        }

        return trafficStat;
    }


}
