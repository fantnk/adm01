package top.fedoseev.adm01.service;

import top.fedoseev.adm01.model.Subscriber;

import java.util.List;

public interface SubscriberService {
    List<Subscriber> get(long accountNumber);
}
