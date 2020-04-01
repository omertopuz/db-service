package com.dbservice.models.db;

public class ResponseInformApplicationFileId {
    private int applicationId;
    private int versionId;
    private int detailId;
    private int entityId;
    private String applicantTaxNumber;
    private Integer informedFileIdInAdvance;
    private int willBeInformedFileId;

    public int getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(int applicationId) {
        this.applicationId = applicationId;
    }

    public int getVersionId() {
        return versionId;
    }

    public void setVersionId(int versionId) {
        this.versionId = versionId;
    }

    public int getDetailId() {
        return detailId;
    }

    public void setDetailId(int detailId) {
        this.detailId = detailId;
    }

    public int getEntityId() {
        return entityId;
    }

    public void setEntityId(int entityId) {
        this.entityId = entityId;
    }

    public String getApplicantTaxNumber() {
        return applicantTaxNumber;
    }

    public void setApplicantTaxNumber(String applicantTaxNumber) {
        this.applicantTaxNumber = applicantTaxNumber;
    }

    public Integer getInformedFileIdInAdvance() {
        return informedFileIdInAdvance;
    }

    public void setInformedFileIdInAdvance(Integer informedFileIdInAdvance) {
        this.informedFileIdInAdvance = informedFileIdInAdvance;
    }

    public int getWillBeInformedFileId() {
        return willBeInformedFileId;
    }

    public void setWillBeInformedFileId(int willBeInformedFileId) {
        this.willBeInformedFileId = willBeInformedFileId;
    }
}
