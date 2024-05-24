package org.java.springfinal.service;


import lombok.RequiredArgsConstructor;
import org.java.springfinal.model.MyLogger;
import org.java.springfinal.repository.LoggerRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MyLoggerService {
    private final LoggerRepository repository;

    public MyLogger saveLog(MyLogger log){
        return repository.save(log);

    }

}
