package com.dbservice.dao.impl;

import com.dbservice.config.DbServiceConfig;
import com.dbservice.dao.CustomDAO;
import com.dbservice.models.db.dbentity.Countries;
import com.dbservice.models.db.ResponseInformApplicationFileId;
import com.dbservice.models.db.ResponseInformEvaluationFormId;
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
    public List<ResponseInformApplicationFileId> getAllInformApplicationFiles() {
        String query = dbServiceConfig.getSqlStatementByLabel("informApplicationFileId");
        List<ResponseInformApplicationFileId> result = jdbcTemplate.query(query, new Object[] {  }, BeanPropertyRowMapper.newInstance(ResponseInformApplicationFileId.class));
        return result;
    }

    @Override
    public List<ResponseInformEvaluationFormId> getAllInformEvaluationForm() {
        String query = dbServiceConfig.getSqlStatementByLabel("informEvaluationFormId");
        List<ResponseInformEvaluationFormId> result = jdbcTemplate.query(query, new Object[] {  }, BeanPropertyRowMapper.newInstance(ResponseInformEvaluationFormId.class));
        return result;
    }
}
