package com.krakedev.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConexionTest {

    private static final Logger Log = LogManager.getLogger(ConexionTest.class);

    public static void main(String[] args) {
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/tallerjdbc", "postgres", "archer22");
            Log.info("Conexion exitosa");
        } catch (SQLException e) {
            Log.error("Error de conexion: " + e.getMessage());
        } finally {
            try {
                con.close();
                Log.info("Conexion cerrada");
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                Log.info("Error al cerrar la conexion");
            }
        }
    }
}
