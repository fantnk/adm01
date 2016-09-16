package top.fedoseev.adm01.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import top.fedoseev.adm01.model.Traffic;

import java.util.List;

@Repository
public class TrafficRepositoryImpl implements TrafficRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private static final BeanPropertyRowMapper<Traffic> ROW_MAPPER = BeanPropertyRowMapper.newInstance(Traffic.class);

    @Override
    public List<Traffic> getAll() {
        return jdbcTemplate.query("SELECT * FROM Traffic ORDER BY date", ROW_MAPPER);
    }

}
