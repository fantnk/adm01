package top.fedoseev.adm01.repository;

import top.fedoseev.adm01.model.Subscriber;

import java.util.List;

public interface SubscriberRepository {
    List<Subscriber> get(long accountNumber);
}