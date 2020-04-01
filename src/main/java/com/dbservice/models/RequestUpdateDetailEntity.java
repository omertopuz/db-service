package com.dbservice.models;

import javax.validation.constraints.Min;
import java.util.List;
import java.util.Map;

public class RequestUpdateDetailEntity {
    @Min(value = 1,message = "detailId must be greater than 0")
    private int detailId;
    private Map<String,String> updateParts;
//    SentApplicationFileAttachmentId,InformedProgramStateIdByUs,SentPreEvaluationFormId


    public RequestUpdateDetailEntity(int detailId, Map<String, String> updateParts) {
        this.detailId = detailId;
        this.updateParts = updateParts;
    }

    public int getDetailId() {
        return detailId;
    }

    public void setDetailId(int detailId) {
        this.detailId = detailId;
    }

    public Map<String, String> getUpdateParts() {
        return updateParts;
    }

    public void setUpdateParts(Map<String, String> updateParts) {
        this.updateParts = updateParts;
    }
}
