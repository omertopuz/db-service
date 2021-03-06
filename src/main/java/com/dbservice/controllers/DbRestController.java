package com.dbservice.controllers;

import com.dbservice.models.RequestGetEntityById;
import com.dbservice.models.RequestUpdateDetailEntity;
import com.dbservice.models.RequestUpdateEntityById;
import com.dbservice.models.ResponseUpdateDetailEntity;
import com.dbservice.models.db.ResponseInformApplicationFiles;
import com.dbservice.models.db.ResponseInformEvaluationForms;
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

    @GetMapping("/getAll/{entityName}")
    public List getAll(@PathVariable(value = "entityName") String entityName) throws ClassNotFoundException {
        return dataRetrieveService.getAll(entityName);
    }

    @GetMapping("/getEntityById")
    public Object getEntityById(@RequestBody RequestGetEntityById request) throws ClassNotFoundException {
        return dataRetrieveService.getEntityById(request);
    }

    @PostMapping("/updateEntityById")
    public Object updateEntityById(@RequestBody RequestUpdateEntityById request) throws ClassNotFoundException {
        Object result = transactionalDataService.updateGivenEntity(request);
        return result;
    }

    @GetMapping("/deleteEntityById")
    public void deleteEntityById(@RequestBody RequestGetEntityById request) throws ClassNotFoundException {
        transactionalDataService.deleteGivenEntity(request);
        return ;
    }

    @GetMapping("/will-be-informed-entities")
    public List<ResponseWillBeInformedStates> getAllWillBeInformedEntities(){
        return dataRetrieveService.getAllWillBeInformedEntities();
    }

    @GetMapping("/inform-application-files")
    public List<ResponseInformApplicationFiles> getAllInformApplicationFiles(){
        return dataRetrieveService.getAllInformApplicationFiles();
    }

    @GetMapping("/inform-evaluation-forms")
    public List<ResponseInformEvaluationForms> getAllInformEvaluationForm(){
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
