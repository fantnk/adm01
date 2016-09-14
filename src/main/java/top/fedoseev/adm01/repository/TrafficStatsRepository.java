package top.fedoseev.adm01.repository;

import top.fedoseev.adm01.model.TrafficStats;

import java.time.LocalDateTime;

public interface TrafficStatsRepository {

    TrafficStats getSubscriberUplinkStats(LocalDateTime fromDate, LocalDateTime toDate, long subscriber);

    TrafficStats getSubscriberDownlinkStats(LocalDateTime fromDate, LocalDateTime toDate, long subscriber);
}
