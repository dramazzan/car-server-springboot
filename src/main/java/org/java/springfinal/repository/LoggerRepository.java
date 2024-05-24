package org.java.springfinal.repository;


import org.java.springfinal.model.MyLogger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoggerRepository extends JpaRepository<MyLogger, Long> {
}
