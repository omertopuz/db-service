package com.dbservice.models.db;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

public class ResponseWillBeInformedStates {
    private int detailId;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;
    private int willBeInformedState;
    private int informedProgramStateInAdvance;

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
