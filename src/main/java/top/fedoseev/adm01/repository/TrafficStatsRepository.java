package top.fedoseev.adm01.repository;

import top.fedoseev.adm01.to.TrafficStats;

public interface TrafficStatsRepository {

    TrafficStats getSubscriberTrafficStat(TrafficStats trafficStat);
}
