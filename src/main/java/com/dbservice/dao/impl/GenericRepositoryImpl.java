package com.dbservice.dao.impl;

import javax.persistence.EntityManager;

import com.dbservice.dao.GenericRepository;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;



public class GenericRepositoryImpl<T, S> extends SimpleJpaRepository<T, S> implements GenericRepository<T,S> {

    public GenericRepositoryImpl(Class<T> domainClass, EntityManager em) {
        super(domainClass, em);
    }
}