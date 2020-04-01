package com.dbservice;

import com.dbservice.models.RequestUpdateDetailEntity;
import com.dbservice.models.db.ResponseInformApplicationFileId;
import com.dbservice.models.db.ResponseInformEvaluationFormId;
import com.dbservice.models.db.ResponseWillBeInformedStates;
import com.dbservice.service.DataRetrieveService;
import com.dbservice.service.TransactionalDataService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.*;

@SpringBootApplication
public class DbServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DbServiceApplication.class, args);
	}


//	@Bean
//	CommandLineRunner lookup(DataRetrieveService daoService, TransactionalDataService transactionalDataService){
//		return args->{
////			List<ResponseWillBeInformedStates> countries = daoService.getAllWillBeInformedEntities();
////			List<ResponseInformApplicationFileId> appForms = daoService.getAllInformApplicationFiles();
////			List<ResponseInformEvaluationFormId> evaluationForms = daoService.getAllInformEvaluationForm();
////			System.out.println("countries.size->"+countries.size());
////			System.out.println("appForms.size->"+appForms.size());
////			System.out.println("evaluationForms.size->"+evaluationForms.size());
//
//			//    SentApplicationFileAttachmentId,InformedProgramStateIdByUs,SentPreEvaluationFormId
//			List<RequestUpdateDetailEntity> reqList = new ArrayList<>(Arrays.asList(
//					new RequestUpdateDetailEntity(1,new HashMap<String, String>() {{
//						put("SentApplicationFileAttachmentId", "1235");
//						put("InformedProgramStateIdByUs", "2");
//					}}),
//					new RequestUpdateDetailEntity(2,new HashMap<String, String>() {{
//						put("SentApplicationFileAttachmentId", "85674");
//						put("InformedProgramStateIdByUs", "1");
//					}}),
//					new RequestUpdateDetailEntity(3,new HashMap<String, String>() {{
//						put("SentApplicationFileAttachmentId", "345346");
//						put("InformedProgramStateIdByUs", "3");
//					}}),
//					new RequestUpdateDetailEntity(4,new HashMap<String, String>() {{
//						put("SentApplicationFileAttachmentId", "98765");
//						put("InformedProgramStateIdByUs", "2");
//					}})
//			));
//
//			transactionalDataService.updateDetailEntity(reqList);
//		};
//	}
}
