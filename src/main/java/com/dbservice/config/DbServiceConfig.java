package com.dbservice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.util.FileCopyUtils;

import javax.annotation.PostConstruct;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DbServiceConfig {
    private Map<String,String> sqlBundle;

    @PostConstruct
    private void readSqlBundleFile() throws Exception{
        Resource resource = new ClassPathResource("sqlStatements.sql");
        InputStream inputStream = resource.getInputStream();
        byte[] bdata = FileCopyUtils.copyToByteArray(inputStream);
        String data = new String(bdata, StandardCharsets.UTF_8);
        String[] allSqlStatements = data.split(";");
        sqlBundle = new HashMap<>();
        String sqlLabel = "";
        String sqlStatement = "";
        for (String s:allSqlStatements) {
            sqlLabel = s.substring(s.indexOf('[')+1,s.indexOf(']')).replace("sqlname : ","");
            sqlStatement = s.substring(s.indexOf(']')+1);
            sqlBundle.put(sqlLabel,sqlStatement);
        }
    }

    public String getSqlStatementByLabel(String sqlLabel) {
        return sqlBundle.get(sqlLabel);
    }
}
