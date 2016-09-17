package top.fedoseev.adm01.service;

import top.fedoseev.adm01.to.TrafficStats;

public interface TrafficStatsService {

    TrafficStats getSubscriberTrafficStat(TrafficStats trafficStat);
}
