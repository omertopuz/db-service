package com.dbservice;

import com.dbservice.dao.impl.CustomDaoImpl;
import com.dbservice.models.db.Countries;
import com.dbservice.service.DataRetrieveService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class DbServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DbServiceApplication.class, args);
	}


//	@Bean
//	CommandLineRunner lookup(DataRetrieveService daoService){
//		return args->{
//			List<Countries> countries = daoService.getCountries();
//			System.out.println("countries.size->"+countries.size());
//
//			Countries countryByIdWithRepo = daoService.getCountryByIdWithRepo(5);
//			System.out.println(countryByIdWithRepo.toString());
//		};
//	}
}
