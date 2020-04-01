package com.dbservice.dao;

import com.dbservice.models.db.dbentity.Countries;
import com.dbservice.models.db.ResponseInformApplicationFileId;
import com.dbservice.models.db.ResponseInformEvaluationFormId;
import com.dbservice.models.db.ResponseWillBeInformedStates;

import java.util.List;

public interface CustomDAO {
    List<Countries> getCountries();
    List<ResponseWillBeInformedStates> getAllWillBeInformedEntities();
    List<ResponseInformApplicationFileId> getAllInformApplicationFiles();
    List<ResponseInformEvaluationFormId> getAllInformEvaluationForm();
}
