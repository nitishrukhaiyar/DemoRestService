package com.rest.cruddemo.config;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import javax.sql.DataSource;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

@Configuration
public class JPAConfig {
    @Bean
    public DataSource getDataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("oracle.jdbc.driver.OracleDriver");
        //parsing database source credentials from json file
        JSONParser jsonParser = new JSONParser();
        String url;String username;String password;
        try (FileReader reader = new FileReader("resources/datasource.json")) {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
            JSONArray dataSourceList = (JSONArray) obj;
            // dataSourceList.forEach( dataSource -> parseDatasourceObject( (JSONObject) dataSource ) );
            for (Object object : dataSourceList) {
                JSONObject jsonObject=(JSONObject)object;
                JSONObject dataSource = (JSONObject) jsonObject.get("dataSource");
                //Get dataSource url
                dataSourceBuilder.url((String) dataSource.get("url"));
                //Get dataSource username
                dataSourceBuilder.username((String) dataSource.get("username"));
                //Get datasource password
                dataSourceBuilder.password((String) dataSource.get("password"));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dataSourceBuilder.build();

    }

}

