package com.krakedev.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Conexion {

    private static final Logger Log = LogManager.getLogger(Conexion.class);

    private static final String URL = "jdbc:postgresql://localhost:5432/tallerjdbc";
    private static final String USER = "postgres";
    private static final String PASSWORD = "archer22";

    public static Connection getConnection() {
        try {
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
            Log.info("Conexion existosa");
            return con;
        } catch (Exception e) {
            Log.error("Error en la conexion" + e.getMessage());
            throw new RuntimeException("No se pudo conectar", e);
        }
    }
}
