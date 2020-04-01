package com.dbservice.models.db.dbentity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class YDStratejikUrunProgramFirmDetail {
    @Id
    private int YDStratejikUrunProgramFirmDetailId;
    private Integer InformedProgramStateIdByUs;
    private Integer SentApplicationFileAttachmentId;
    private Integer SentPreEvaluationFormId;

    public int getYDStratejikUrunProgramFirmDetailId() {
        return YDStratejikUrunProgramFirmDetailId;
    }

    public void setYDStratejikUrunProgramFirmDetailId(int YDStratejikUrunProgramFirmDetailId) {
        this.YDStratejikUrunProgramFirmDetailId = YDStratejikUrunProgramFirmDetailId;
    }

    public Integer getInformedProgramStateIdByUs() {
        return InformedProgramStateIdByUs;
    }

    public void setInformedProgramStateIdByUs(Integer informedProgramStateIdByUs) {
        InformedProgramStateIdByUs = informedProgramStateIdByUs;
    }

    public Integer getSentApplicationFileAttachmentId() {
        return SentApplicationFileAttachmentId;
    }

    public void setSentApplicationFileAttachmentId(Integer sentApplicationFileAttachmentId) {
        SentApplicationFileAttachmentId = sentApplicationFileAttachmentId;
    }

    public Integer getSentPreEvaluationFormId() {
        return SentPreEvaluationFormId;
    }

    public void setSentPreEvaluationFormId(Integer sentPreEvaluationFormId) {
        SentPreEvaluationFormId = sentPreEvaluationFormId;
    }
}
