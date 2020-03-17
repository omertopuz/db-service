package com.dbservice.dao;

import com.dbservice.models.db.Countries;

import java.util.List;

public interface CustomDAO {
    List<Countries> getCountries();
}
