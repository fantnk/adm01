package top.fedoseev.adm01.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import top.fedoseev.adm01.to.TrafficStat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@Transactional(readOnly = true)
public class TrafficStatRepositoryImpl implements TrafficStatRepository {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public TrafficStat getSubscriberTrafficStat(TrafficStat trafficStat) {
        Map<String, Object> map = new HashMap<>();

        map.put("startDate", trafficStat.getStartDate());
        map.put("endDate", trafficStat.getEndDate());
        map.put("subscriber", trafficStat.getSubscriber());

        String query = "SELECT SUM(" + trafficStat.getLinkType().name().toLowerCase() + ") FROM traffic t " +
                "LEFT JOIN subscriber s ON t.subscriber_id = s.id " +
                "WHERE date BETWEEN :startDate AND :endDate AND s.account_number=:subscriber GROUP BY subscriber_id";

        List<Long> list = namedParameterJdbcTemplate.query(query, map, (rs, rowNum) -> rs.getLong(1));

        if (list.size() == 1) {
            trafficStat.setBytesTransferred(list.get(0));
        }

        return trafficStat;
    }
}
