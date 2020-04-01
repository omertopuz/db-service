package com.dbservice.models.db.dbentity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Countries{
    @Id
    @Column
    private int CountryId;
    @Column
    private String CountryName;
    @Column
    private String CountryStandartCodeId;
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date CreationDate;
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date UpdateDate;

    public int getCountryId() {
        return CountryId;
    }

    public void setCountryId(int countryId) {
        CountryId = countryId;
    }

    public String getCountryName() {
        return CountryName;
    }

    public void setCountryName(String countryName) {
        CountryName = countryName;
    }

    public String getCountryStandartCodeId() {
        return CountryStandartCodeId;
    }

    public void setCountryStandartCodeId(String countryStandartCodeId) {
        CountryStandartCodeId = countryStandartCodeId;
    }

    public Date getCreationDate() {
        return CreationDate;
    }

    public void setCreationDate(Date creationDate) {
        CreationDate = creationDate;
    }

    public Date getUpdateDate() {
        return UpdateDate;
    }

    public void setUpdateDate(Date updateDate) {
        UpdateDate = updateDate;
    }

    @Override
    public String toString() {
        return "Countries{" +
                "CountryId=" + CountryId +
                ", CountryName='" + CountryName + '\'' +
                ", CountryStandartCodeId='" + CountryStandartCodeId + '\'' +
                ", CreationDate=" + CreationDate +
                ", UpdateDate=" + UpdateDate +
                '}';
    }
}
