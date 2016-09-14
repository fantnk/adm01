package top.fedoseev.adm01.repository;

import top.fedoseev.adm01.model.Traffic;

import java.util.List;

public interface TrafficRepository {
    /*Traffic save(Traffic traffic);

    // false if not found
    boolean delete(int id);*/

    // null if not found
    Traffic get(int id);

    List<Traffic> getAll();
}