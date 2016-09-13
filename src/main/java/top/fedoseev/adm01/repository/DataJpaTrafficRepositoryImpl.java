package top.fedoseev.adm01.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import top.fedoseev.adm01.model.Traffic;

import java.util.List;

@Repository
public class DataJpaTrafficRepositoryImpl implements TrafficRepository {

    @Autowired
    private ProxyTrafficRepository proxy;

   /* @Override
    public Traffic save(Traffic traffic) {
        return proxy.save(traffic);
    }

    @Override
    public boolean delete(int id) {
        return proxy.delete(id) != 0;
    }*/

    @Override
    public Traffic get(int id) {
        return proxy.findOne(id);
    }

    @Override
    public List<Traffic> getAll() {
        return proxy.findAll();
    }

}
