package com.dbservice.dao.impl;

import com.dbservice.config.DbServiceConfig;
import com.dbservice.dao.CustomDAO;
import com.dbservice.models.db.dbentity.Countries;
import com.dbservice.models.db.ResponseInformApplicationFiles;
import com.dbservice.models.db.ResponseInformEvaluationForms;
import com.dbservice.models.db.ResponseWillBeInformedStates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomDaoImpl implements CustomDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private DbServiceConfig dbServiceConfig;

    @Override
    public List<Countries> getCountries() {
        String query = dbServiceConfig.getSqlStatementByLabel("testQuery");
        List<Countries> result = jdbcTemplate.query(query, new Object[] {  }, BeanPropertyRowMapper.newInstance(Countries.class));
        return result;
    }

    @Override
    public List<ResponseWillBeInformedStates> getAllWillBeInformedEntities() {
        String query = dbServiceConfig.getSqlStatementByLabel("getAllWillBeInformedEntities");
        List<ResponseWillBeInformedStates> result = jdbcTemplate.query(query, new Object[] {  }, BeanPropertyRowMapper.newInstance(ResponseWillBeInformedStates.class));
        return result;
    }

    @Override
    public List<ResponseInformApplicationFiles> getAllInformApplicationFiles() {
        String query = dbServiceConfig.getSqlStatementByLabel("informApplicationFileId");
        List<ResponseInformApplicationFiles> result = jdbcTemplate.query(query, new Object[] {  }, BeanPropertyRowMapper.newInstance(ResponseInformApplicationFiles.class));
        return result;
    }

    @Override
    public List<ResponseInformEvaluationForms> getAllInformEvaluationForm() {
        String query = dbServiceConfig.getSqlStatementByLabel("informEvaluationFormId");
        List<ResponseInformEvaluationForms> result = jdbcTemplate.query(query, new Object[] {  }, BeanPropertyRowMapper.newInstance(ResponseInformEvaluationForms.class));
        return result;
    }
}
