package top.fedoseev.adm01.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import top.fedoseev.adm01.model.TrafficStats;

import java.time.LocalDateTime;

@Repository
public class TrafficStatsRepositoryImpl implements TrafficStatsRepository {

    @Autowired
    private ProxyTrafficStatsRepository proxy;

    @Override
    public TrafficStats getSubscriberUplinkStats(LocalDateTime fromDate, LocalDateTime toDate, long subscriber) {
        return proxy.getSubscriberUplinkStats(fromDate, toDate, subscriber);
    }

    @Override
    public TrafficStats getSubscriberDownlinkStats(LocalDateTime fromDate, LocalDateTime toDate, long subscriber) {
        TrafficStats trafficStats = proxy.getSubscriberDownlinkStats(fromDate, toDate, subscriber);
        return trafficStats;
    }
}
