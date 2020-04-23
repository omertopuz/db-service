package com.dbservice.models;

import java.util.Map;

public class RequestUpdateEntityById {
    private Object entityId;
    private String entityName;
    private Map<String,Object> propertyValues;

    public RequestUpdateEntityById() {
    }

    public RequestUpdateEntityById(Object entityId, String entityName, Map<String, Object> propertyValues) {
        this.entityId = entityId;
        this.entityName = entityName;
        this.propertyValues = propertyValues;
    }

    public Object getEntityId() {
        return entityId;
    }

    public void setEntityId(Object entityId) {
        this.entityId = entityId;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public Map<String, Object> getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(Map<String, Object> propertyValues) {
        this.propertyValues = propertyValues;
    }
}

