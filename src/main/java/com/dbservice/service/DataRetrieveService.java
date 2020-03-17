package com.dbservice.service;

import com.dbservice.dao.CustomDAO;
import com.dbservice.dao.impl.GenericRepositoryImpl;
import com.dbservice.models.db.Countries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Service
public class DataRetrieveService {
    @Autowired
    private CustomDAO customDao;

    @Autowired
    private EntityManager em;

    public List<Countries> getCountries() {
        return customDao.getCountries();
    }

    public Countries getCountryByIdWithRepo(Integer id) {
        GenericRepositoryImpl<Countries,Integer> repo = getGenericRepo(Countries.class);
        Optional<Countries> testEntity = repo.findById(id);

        return testEntity.orElse(new Countries());
    }

    private <T,S> GenericRepositoryImpl<T,S> getGenericRepo(Class<T> clazz){
        GenericRepositoryImpl<T,S> repo = new GenericRepositoryImpl<T,S>(clazz, em);
        return repo;
    }
}
