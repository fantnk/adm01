package top.fedoseev.adm01.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import top.fedoseev.adm01.model.Subscriber;

import java.util.List;

@Repository
public class SubscriberRepositoryImpl implements SubscriberRepository {

    private final JdbcTemplate jdbcTemplate;
    private static final BeanPropertyRowMapper<Subscriber> ROW_MAPPER = BeanPropertyRowMapper.newInstance(Subscriber.class);

    @Autowired
    public SubscriberRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Subscriber> findByAccountNumberPart(long accountNumber) {
        String query = "SELECT id, account_number FROM Subscriber WHERE CAST(account_number AS CHAR(20)) LIKE '"
                + accountNumber + "%' ORDER BY account_number LIMIT 5";

        return jdbcTemplate.query(query, ROW_MAPPER);
    }
}
