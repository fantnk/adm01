package top.fedoseev.adm01.repository;

import top.fedoseev.adm01.model.Traffic;

import java.util.List;

public interface TrafficRepository {
    List<Traffic> getAll();
}