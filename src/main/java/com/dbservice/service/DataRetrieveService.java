package com.dbservice.service;

import com.dbservice.dao.CustomDAO;
import com.dbservice.dao.impl.GenericRepositoryImpl;
import com.dbservice.models.RequestGetEntityById;
import com.dbservice.models.db.dbentity.Countries;
import com.dbservice.models.db.ResponseInformApplicationFiles;
import com.dbservice.models.db.ResponseInformEvaluationForms;
import com.dbservice.models.db.ResponseWillBeInformedStates;
import com.dbservice.util.Utilities;
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

    public List<ResponseWillBeInformedStates> getAllWillBeInformedEntities() {
        return customDao.getAllWillBeInformedEntities();
    }
    public List<ResponseInformApplicationFiles> getAllInformApplicationFiles() {
        return customDao.getAllInformApplicationFiles();
    }

    public List<ResponseInformEvaluationForms> getAllInformEvaluationForm() {
        return customDao.getAllInformEvaluationForm();
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

    public List getAll(String entityName) throws ClassNotFoundException {
        Class entityClass = Class.forName(Utilities.getFullEntityName(entityName));
        Class idClass = em.getEntityManagerFactory().getMetamodel().entity(entityClass).getIdType().getJavaType();
        return getAll(entityClass,idClass);
    }

    public <T,S> List getAll(Class<T> entityClass, Class<S> idPropertyClass) {
        GenericRepositoryImpl<T,S> repo = getGenericRepo(entityClass);
        return repo.findAll();
    }

    public Object getEntityById(RequestGetEntityById request) throws ClassNotFoundException {
        Class entityClass = Class.forName(Utilities.getFullEntityName(request.getEntityName()));
        Class idClass = em.getEntityManagerFactory().getMetamodel().entity(entityClass).getIdType().getJavaType();
        return getEntityById(entityClass,idClass,request.getEntityId());
    }

    public <T,S> T getEntityById(Class<T> entityClass, Class<S> idPropertyClass, Object entityId) {
        GenericRepositoryImpl<T,S> repo = getGenericRepo(entityClass);

        return (T)repo.findById((S)entityId).get();
    }

}
