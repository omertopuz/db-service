package com.dbservice.service;

import com.dbservice.dao.impl.GenericRepositoryImpl;
import com.dbservice.models.RequestUpdateDetailEntity;
import com.dbservice.models.ResponseUpdateDetailEntity;
import com.dbservice.models.db.dbentity.YDStratejikUrunProgramFirmDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TransactionalDataService {

    @Autowired
    private EntityManager em;
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
