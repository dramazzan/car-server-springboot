package org.java.springfinal.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "request_logger")
public class MyLogger {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name= "id" , nullable = false)
    private Long id;

    private String request;
    private String response;
    private LocalDateTime createdAt;




}
