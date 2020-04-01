package com.dbservice.controllers;

import com.dbservice.models.RequestUpdateDetailEntity;
import com.dbservice.models.ResponseUpdateDetailEntity;
import com.dbservice.models.db.ResponseInformApplicationFileId;
import com.dbservice.models.db.ResponseInformEvaluationFormId;
import com.dbservice.models.db.ResponseWillBeInformedStates;
import com.dbservice.service.DataRetrieveService;
import com.dbservice.service.TransactionalDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/rest/db-service")
public class DbRestController {

    @Autowired
    private DataRetrieveService dataRetrieveService;

    @Autowired
    private TransactionalDataService transactionalDataService;

    @GetMapping("/will-be-informed-entities")
    public List<ResponseWillBeInformedStates> getAllWillBeInformedEntities(){
        return dataRetrieveService.getAllWillBeInformedEntities();
    }

    @GetMapping("/inform-application-files")
    public List<ResponseInformApplicationFileId> getAllInformApplicationFiles(){
        return dataRetrieveService.getAllInformApplicationFiles();
    }

    @GetMapping("/inform-evaluation-forms")
    public List<ResponseInformEvaluationFormId> getAllInformEvaluationForm(){
        return dataRetrieveService.getAllInformEvaluationForm();
    }

    @PostMapping("/update-detail-entity-list")
    public ResponseUpdateDetailEntity updateDetailEntityList(@Valid @RequestBody List<RequestUpdateDetailEntity> requestList){
        return transactionalDataService.updateDetailEntity(requestList);
    }

    @PostMapping("/update-detail-entity")
    public ResponseUpdateDetailEntity updateDetailEntity(@Valid @RequestBody RequestUpdateDetailEntity request){
        return transactionalDataService.updateDetailEntity(new ArrayList<>(Arrays.asList(request)));
    }
}
