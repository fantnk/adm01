package top.fedoseev.adm01.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import top.fedoseev.adm01.model.TrafficStats;

import java.time.LocalDateTime;

@Transactional(readOnly = true)
public interface ProxyTrafficStatsRepository extends JpaRepository<TrafficStats, Integer> {

    @Query("SELECT SUM(uplink) FROM Traffic WHERE date BETWEEN :fromDate AND :toDate AND subscriber=:subscriber\n" +
            "GROUP BY subscriber")
    TrafficStats getSubscriberUplinkStats(LocalDateTime fromDate, LocalDateTime toDate, long subscriber);

    /*@Query(value = "SELECT subscriber as subscriber, ':fromDate' as fromdate, ':toDate' as todate, SUM(downlink) as bytestransferred FROM Traffic WHERE date BETWEEN :fromDate AND :toDate AND subscriber=:subscriber GROUP BY subscriber", nativeQuery = true)
    TrafficStats getSubscriberDownlinkStats(@Param("fromDate") LocalDateTime fromDate,
                                            @Param("toDate") LocalDateTime toDate,
                                            @Param("subscriber") long subscriber);*/

    @Query(value = "SELECT new top.fedoseev.adm01.model.TrafficStats(:fromDate, " +
            ":toDate, :subscriber, SUM(downlink)) " +
            "FROM Traffic WHERE date BETWEEN :fromDate AND :toDate AND subscriber=:subscriber GROUP BY subscriber")
    TrafficStats getSubscriberDownlinkStats(@Param("fromDate") LocalDateTime fromDate,
                                            @Param("toDate") LocalDateTime toDate,
                                            @Param("subscriber") long subscriber);
}