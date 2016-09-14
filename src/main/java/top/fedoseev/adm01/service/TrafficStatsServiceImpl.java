package top.fedoseev.adm01.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.fedoseev.adm01.repository.TrafficStatsRepository;
import top.fedoseev.adm01.model.TrafficStats;

import java.time.LocalDateTime;

import static top.fedoseev.adm01.model.TrafficStats.LinkType.UPLINK;

@Service
public class TrafficStatsServiceImpl implements TrafficStatsService {

    @Autowired
    private TrafficStatsRepository repository;

    @Override
    public TrafficStats getSubscriberTrafficStats(LocalDateTime fromDate, LocalDateTime toDate, long subscriber,
                                                  TrafficStats.LinkType linkType) {
        return linkType == UPLINK ? repository.getSubscriberUplinkStats(fromDate, toDate, subscriber) :
                repository.getSubscriberDownlinkStats(fromDate, toDate, subscriber);
    }


}
