package com.dbservice.dao.impl;

import com.dbservice.dao.CustomDAO;
import com.dbservice.models.db.Countries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomDaoImpl implements CustomDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Value( "${data.query.queryTest}" )
    private String queryTest;

    @Override
    public List<Countries> getCountries() {
        List<Countries> result = jdbcTemplate.query(queryTest, new Object[] {  }, BeanPropertyRowMapper.newInstance(Countries.class));
        return result;
    }
}
