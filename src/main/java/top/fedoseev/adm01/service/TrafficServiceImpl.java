package top.fedoseev.adm01.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.fedoseev.adm01.model.Traffic;
import top.fedoseev.adm01.repository.TrafficRepository;

import java.util.List;

@Service
public class TrafficServiceImpl implements TrafficService {

    @Autowired
    private TrafficRepository repository;

    /*@CacheEvict(value = "traffic", allEntries = true)
    public Traffic save(Traffic traffic) {
        return repository.save(traffic);
    }

    @CacheEvict(value = "traffic", allEntries = true)
    public void delete(int id) {
        //ExceptionUtil.checkNotFoundWithId(repository.delete(id), id);
        repository.delete(id);
    }*/

    //public Traffic findByAccountNumberPart(int id) throws NotFoundException {
    /*@Override
    public Traffic findByAccountNumberPart(int id) {
        //return ExceptionUtil.checkNotFoundWithId(repository.findByAccountNumberPart(id), id);
        return repository.findByAccountNumberPart(id);
    }*/

    //    @Cacheable("traffic")
    @Override
    public List<Traffic> getAll() {
        return repository.getAll();
    }
    /*@CacheEvict(value = "traffic", allEntries = true)
    public void update(Traffic traffic) {
        repository.save(traffic);
    }*/

    /*@CacheEvict(value = "traffic", allEntries = true)
    @Override
    public void evictCache() {
    }*/
}
