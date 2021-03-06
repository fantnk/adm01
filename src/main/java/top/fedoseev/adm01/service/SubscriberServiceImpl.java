package top.fedoseev.adm01.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.fedoseev.adm01.model.Subscriber;
import top.fedoseev.adm01.repository.SubscriberRepository;

import java.util.List;

@Service
public class SubscriberServiceImpl implements SubscriberService {

    private final SubscriberRepository repository;

    @Autowired
    public SubscriberServiceImpl(SubscriberRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Subscriber> findByAccountNumberPart(long accountNumber) {
        return repository.findByAccountNumberPart(accountNumber);
    }
}
