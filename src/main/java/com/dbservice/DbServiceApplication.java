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
}
