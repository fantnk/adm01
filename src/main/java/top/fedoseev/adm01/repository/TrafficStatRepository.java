package top.fedoseev.adm01.repository;

import top.fedoseev.adm01.to.TrafficStat;

public interface TrafficStatRepository {

    TrafficStat getSubscriberTrafficStat(TrafficStat trafficStat);
}
