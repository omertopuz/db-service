package com.dbservice.util;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.UUID;

public class Utilities {
    private static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    public static String DB_ENTITY_PACKAGE_NAME = "com.dbservice.models.db.dbentity.";

    public static String getFullEntityName(String entityName){
        return DB_ENTITY_PACKAGE_NAME + entityName;
    }

    public static void invokeSetter(Object obj, Map<String,Object> propertyValues)
    {
        propertyValues.forEach((propertyName,variableValue)->{
            invokeSetter(obj,propertyName,variableValue);
        });
    }

    public static  <T> T createNewEntity(Class<T> entityClass){
        try {
            Constructor<T> ctor = entityClass.getConstructor();
            return (T) ctor.newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Error when creating entity "+entityClass.getSimpleName());
        }
    }

    public static void invokeSetter(Object obj, String propertyName, Object variableValue){
        try {
            PropertyDescriptor pd = new PropertyDescriptor(propertyName, obj.getClass());
            Method setter = pd.getWriteMethod();
            Object customValue = null;
            if(variableValue!=null) {
                switch (setter.getParameterTypes()[0].getSimpleName()) {
                    case "Date":
                        customValue = DATE_FORMAT.parse(variableValue.toString());
                        break;
                    case "UUID":
                        customValue= UUID.fromString(variableValue.toString());
                        break;
                    default:
                        customValue = variableValue;
                        break;
                }
            }
            setter.invoke(obj,customValue);
        } catch (Exception e) {
            throw new RuntimeException("Error setting value of entity; propertyName : + "+propertyName + ", variableValue : "+variableValue);
        }
    }
}
