package com.dbservice.models.db;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

public class ResponseWillBeInformedStates {
    private int detailId;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;
    private int willBeInformedState;
    private String willBeInformedStateString;
    private int informedProgramStateInAdvance;
    private String remoteEntityId;

    public String getWillBeInformedStateString() {
        return willBeInformedStateString;
    }

    public void setWillBeInformedStateString(String willBeInformedStateString) {
        this.willBeInformedStateString = willBeInformedStateString;
    }

    public String getRemoteEntityId() {
        return remoteEntityId;
    }

    public void setRemoteEntityId(String remoteEntityId) {
        this.remoteEntityId = remoteEntityId;
    }

    public int getDetailId() {
        return detailId;
    }

    public void setDetailId(int detailId) {
        this.detailId = detailId;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public int getWillBeInformedState() {
        return willBeInformedState;
    }

    public void setWillBeInformedState(int willBeInformedState) {
        this.willBeInformedState = willBeInformedState;
    }

    public int getInformedProgramStateInAdvance() {
        return informedProgramStateInAdvance;
    }

    public void setInformedProgramStateInAdvance(int informedProgramStateInAdvance) {
        this.informedProgramStateInAdvance = informedProgramStateInAdvance;
    }
}
