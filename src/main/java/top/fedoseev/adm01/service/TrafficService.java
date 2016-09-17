package top.fedoseev.adm01.service;

import top.fedoseev.adm01.model.Traffic;

import java.util.List;

public interface TrafficService {

    /*Traffic save(Traffic traffic);

    void delete(int id);
    //void delete(int id) throws NotFoundException;*/

//    Traffic findByAccountNumberPart(int id);
    //Traffic findByAccountNumberPart(int id) throws NotFoundException;

    List<Traffic> getAll();

//    void update(Traffic traffic);

//    void evictCache();
}
