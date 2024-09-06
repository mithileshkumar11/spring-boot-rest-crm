package com.crm.model;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "roles")
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String name;
    
    //@Column(columnDefinition = "integer default 1")
    private Integer status;
    
    @CreationTimestamp
    //@Column(columnDefinition = "varchar(100) default 'ADMIN'")
    private Date createdAt;
    
    @UpdateTimestamp
    private Date updatedAt;
       
    @CreatedBy
    private String createdBy;
    
    //@Column(columnDefinition = "varchar(100) default 'ADMIN'")
    private String updatedBy;
}

