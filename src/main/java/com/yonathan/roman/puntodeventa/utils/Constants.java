package com.yonathan.roman.puntodeventa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author Yonathan
 */
public class Constants {

    private final static Properties properties = new Properties();

    private static final String PROPERTIES_FILE = "data.properties";
    private static final String STATUS = "environment";
    private static final String NAME_APP = "PUNTO DE VENTA";
    private static final String HOST = "localhost";
    private static final String DATABASE = "pdv-app";
    private static final String USUARIO = "pdv";
    private static final String PASSWORD = "AVzFcW5iPH6w2q8TurMK45STL6M6pu";

    public static String getNAME_APP() {
        try {
            properties.load(new FileInputStream(new File(PROPERTIES_FILE)));
            if (properties.get(STATUS).equals("pro")) {
                return properties.get("NAME_APP").toString();
            } else {
                return NAME_APP;
            }
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
            return NAME_APP;
        }

    }

    public static String getHOST() {
        return HOST;
    }

    public static String getDATABASE() {
        return DATABASE;
    }

    public static String getUSUARIO() {
        return USUARIO;
    }

    public static String getPASSWORD() {
        return PASSWORD;
    }

}
