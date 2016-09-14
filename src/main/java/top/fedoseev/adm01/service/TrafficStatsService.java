package top.fedoseev.adm01.service;

import top.fedoseev.adm01.model.TrafficStats;

import java.time.LocalDateTime;

public interface TrafficStatsService {

    TrafficStats getSubscriberTrafficStats(LocalDateTime fromDate, LocalDateTime toDate,
                                           long subscriber, TrafficStats.LinkType linkType);
}
