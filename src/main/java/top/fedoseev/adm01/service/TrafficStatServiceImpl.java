package top.fedoseev.adm01.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.fedoseev.adm01.repository.TrafficStatRepository;
import top.fedoseev.adm01.to.TrafficStat;

import java.time.temporal.ChronoUnit;

@Service
public class TrafficStatServiceImpl implements TrafficStatService {

    @Autowired
    private TrafficStatRepository repository;

    @Override
    public TrafficStat getSubscriberTrafficStat(TrafficStat trafficStat) {
        trafficStat = repository.getSubscriberTrafficStat(trafficStat);

        if (trafficStat.getBytesTransferred() != 0) {
            trafficStat.setSpeed(8f * (float) trafficStat.getBytesTransferred() /
                    (float) ChronoUnit.SECONDS.between(trafficStat.getStartDate(), trafficStat.getEndDate()));
        }

        return trafficStat;
    }


}
