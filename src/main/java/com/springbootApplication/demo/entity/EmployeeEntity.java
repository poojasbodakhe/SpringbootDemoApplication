package com.springbootApplication.demo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import javax.persistence.*;
import java.util.Date;


@Data
@Entity
@Table(name= "employee")
public class EmployeeEntity {
    @Id
    @JsonProperty
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer empId;

    @JsonProperty
    private String empFirstName;

    @JsonProperty
    private String empLastName;

    @JsonProperty
    private String emailId;

    @JsonProperty
    private String address;

    @JsonProperty
    private Integer contactNo;

    @JsonProperty
    private String companyId;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @JsonProperty
    private boolean activeStatus;


}
