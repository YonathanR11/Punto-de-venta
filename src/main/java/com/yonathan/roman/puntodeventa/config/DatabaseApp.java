package com.yonathan.roman.puntodeventa.config;

import io.ebean.Database;
import io.ebean.DatabaseFactory;
import io.ebean.config.DatabaseConfig;
import io.ebean.datasource.DataSourceConfig;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.apache.commons.lang3.ObjectUtils;
import org.reflections.Reflections;

/**
 *
 * @author Yonathan
 */
public class DatabaseApp {
    
    public static Database database;
    
    private static final String HOST = "localhost";
    private static final String PORT = "5432";
    private static final String DB = "punto_de_venta";
    private static final String USER = "postgres";
    private static final String PASS = "root";
    
    public static Database init() {
        try {
            if (ObjectUtils.isEmpty(database)) {
                System.out.println("Iniciando Database...");
                
                DataSourceConfig dataSourceConfig = new DataSourceConfig();
                dataSourceConfig.setUsername(USER);
                dataSourceConfig.setPassword(PASS);
                dataSourceConfig.setDriver("org.postgresql.Driver");
                dataSourceConfig.setUrl("jdbc:postgresql://" + HOST + ":" + PORT + "/" + DB + "?characterEncoding=UTF-8&useSSL=false");
                dataSourceConfig.setIsolationLevel(2);
                
                DatabaseConfig config = new DatabaseConfig();
                
                List<String> packages = new ArrayList<>();
                packages.add("com.yonathan.roman.puntodeventa.model");
                config.setPackages(packages);
                
                String pack = "com.yonathan.roman.puntodeventa.model";
                
                Reflections reflections = new Reflections(pack);
                Set<Class<?>> classes = reflections.getSubTypesOf(Object.class);
                
                config.setClasses(classes);
                config.addAll(classes);
                
                config.setDdlGenerate(true);
                config.setDdlRun(true); // Solo poner en TRUE si se decea iniciar de nuevo la DB
                config.setDdlSeedSql("data.sql");
                config.setDatabasePlatformName("postgres");
                
                config.setDataSourceConfig(dataSourceConfig);
                
                database = DatabaseFactory.create(config);
                System.out.println("Database iniciada.");
                return database;
            } else {
                return database;
            }
        } catch (Exception e) {
            System.out.println("Database NO iniciada.");
            throw new RuntimeException("Database: " + e.getMessage());
        }
    }

//    private List<Class<?>> getClases(){
//        
//    }
}
