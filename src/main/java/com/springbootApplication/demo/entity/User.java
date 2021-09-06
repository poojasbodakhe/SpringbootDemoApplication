package com.springbootApplication.demo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.Data;
import javax.persistence.*;
import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;


@Data
@Entity
@Table(name= "users")
public class User {

    @Id
    @JsonProperty
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonProperty
    private String firstName;

    @JsonProperty
    private String lastName;

    @JsonProperty
    private String email;

    @JsonProperty
    private String password;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @JsonProperty
    private String collegeName;



}
