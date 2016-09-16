package top.fedoseev.adm01.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.fedoseev.adm01.model.SubscriberTo;
import top.fedoseev.adm01.repository.SubscriberRepository;

import java.util.List;

@Service
public class SubscriberServiceImpl implements SubscriberService {

    @Autowired
    private SubscriberRepository repository;

    @Override
    public List<SubscriberTo> get(long accountNumber) {
        return repository.get(accountNumber);
    }
}
