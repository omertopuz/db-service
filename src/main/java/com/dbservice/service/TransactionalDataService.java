package com.dbservice.service;

import com.dbservice.dao.impl.GenericRepositoryImpl;
import com.dbservice.models.RequestGetEntityById;
import com.dbservice.models.RequestUpdateDetailEntity;
import com.dbservice.models.RequestUpdateEntityById;
import com.dbservice.models.ResponseUpdateDetailEntity;
import com.dbservice.models.db.dbentity.YDStratejikUrunProgramFirmDetail;
import com.dbservice.util.Utilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@Transactional
public class TransactionalDataService {

    @Autowired
    private EntityManager em;

    public Object updateGivenEntity(RequestUpdateEntityById request) throws ClassNotFoundException {
        Class entityClass = Class.forName(Utilities.getFullEntityName(request.getEntityName()));
        Class idClass = em.getEntityManagerFactory().getMetamodel().entity(entityClass).getIdType().getJavaType();
        return updateGivenEntity(entityClass,idClass,request.getEntityId(),request.getPropertyValues());
    }

    public <T,S> T updateGivenEntity(Class<T> entityClass, Class<S> idPropertyClass, Object entityId, Map<String,Object> propertyValues) {
        GenericRepositoryImpl<T,S> repo = getGenericRepo(entityClass);
        T willBeUpdateEntity = null;
        if (entityId!=null){
            Optional<?> entity = repo.findById((S)entityId);
            if (entity.isPresent())
                willBeUpdateEntity = (T) repo.findById((S)entityId).get();
            else {
                throw new RuntimeException("Entity not found : entity : " + entityClass.getSimpleName()
                        + ", id : "+entityId.toString());
            }
        }else {
            willBeUpdateEntity = Utilities.createNewEntity(entityClass);
        }

        Utilities.invokeSetter(willBeUpdateEntity,propertyValues);
        T savedEntity = repo.save(willBeUpdateEntity);
        return savedEntity;
    }

    public void deleteGivenEntity(RequestGetEntityById request) throws ClassNotFoundException {
        Class entityClass = Class.forName(Utilities.getFullEntityName(request.getEntityName()));
        Class idClass = em.getEntityManagerFactory().getMetamodel().entity(entityClass).getIdType().getJavaType();
        deleteGivenEntity(entityClass,idClass,request.getEntityId());
    }

    public <T,S> void deleteGivenEntity(Class<T> entityClass, Class<S> idPropertyClass,Object entityId){
        GenericRepositoryImpl<T,S> repo = getGenericRepo(entityClass);
        repo.deleteById((S)entityId);
    }


    private <T,S> GenericRepositoryImpl<T,S> getGenericRepo(Class<T> clazz){
        GenericRepositoryImpl<T,S> repo = new GenericRepositoryImpl<T,S>(clazz, em);
        return repo;
    }

    public ResponseUpdateDetailEntity updateDetailEntity(List<RequestUpdateDetailEntity> requestList) {
        ResponseUpdateDetailEntity response = new ResponseUpdateDetailEntity();
        int entityId = 0;
        try {
            GenericRepositoryImpl<YDStratejikUrunProgramFirmDetail,Integer> repo = getGenericRepo(YDStratejikUrunProgramFirmDetail.class);
            for (RequestUpdateDetailEntity request:requestList) {
                entityId = request.getDetailId();
                Optional<YDStratejikUrunProgramFirmDetail> detail = repo.findById(request.getDetailId());
                if (detail.isPresent()){
                    boolean isUpdate = false;
                    YDStratejikUrunProgramFirmDetail detailEntity = detail.get();

                    //    SentApplicationFileAttachmentId ,InformedProgramStateIdByUs, SentPreEvaluationFormId
                    if (request.getUpdateParts().containsKey("SentApplicationFileAttachmentId")){
                        isUpdate = true;
                        detailEntity.setSentApplicationFileAttachmentId(Integer.parseInt(request.getUpdateParts().get("SentApplicationFileAttachmentId")));
                    }

                    if (request.getUpdateParts().containsKey("InformedProgramStateIdByUs")){
                        isUpdate = true;
                        detailEntity.setInformedProgramStateIdByUs(Integer.parseInt(request.getUpdateParts().get("InformedProgramStateIdByUs")));
                    }

                    if (request.getUpdateParts().containsKey("SentPreEvaluationFormId")){
                        isUpdate = true;
                        detailEntity.setSentPreEvaluationFormId(Integer.parseInt(request.getUpdateParts().get("SentPreEvaluationFormId")));
                    }

                    if (isUpdate)
                        repo.saveAndFlush(detailEntity);
                }
            }
        }catch (Exception ex){
            response.setSucceded(false);
            response.setMessage("Unexpected error while updating entity. Entity id :  " + entityId);
        }
        return response;
    }
}
