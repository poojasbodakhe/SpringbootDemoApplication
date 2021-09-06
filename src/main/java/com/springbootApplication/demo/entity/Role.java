package com.springbootApplication.demo.entity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name= "role")
public class Role {

    @Id
    @JsonProperty
    private Integer roleId;

    @JsonProperty
    private String role;
}
