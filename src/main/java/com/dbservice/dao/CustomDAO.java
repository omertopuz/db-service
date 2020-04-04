package com.dbservice.dao;

import com.dbservice.models.db.dbentity.Countries;
import com.dbservice.models.db.ResponseInformApplicationFiles;
import com.dbservice.models.db.ResponseInformEvaluationForms;
import com.dbservice.models.db.ResponseWillBeInformedStates;

import java.util.List;

public interface CustomDAO {
    List<Countries> getCountries();
    List<ResponseWillBeInformedStates> getAllWillBeInformedEntities();
    List<ResponseInformApplicationFiles> getAllInformApplicationFiles();
    List<ResponseInformEvaluationForms> getAllInformEvaluationForm();
}
