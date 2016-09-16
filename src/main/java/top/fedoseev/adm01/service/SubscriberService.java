package top.fedoseev.adm01.service;

import top.fedoseev.adm01.model.SubscriberTo;

import java.util.List;

public interface SubscriberService {
    List<SubscriberTo> get(long accountNumber);
}
