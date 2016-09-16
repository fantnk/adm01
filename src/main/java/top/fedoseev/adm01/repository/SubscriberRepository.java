package top.fedoseev.adm01.repository;

import top.fedoseev.adm01.model.SubscriberTo;

import java.util.List;

public interface SubscriberRepository {
    List<SubscriberTo> get(long accountNumber);
}