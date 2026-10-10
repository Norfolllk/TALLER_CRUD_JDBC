package com.krakedev.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DeleteVehiculo {
    private static final Logger Log = LogManager.getLogger(DeleteVehiculo.class);

    public static void delete(String placa) {
        if (placa == null || placa.isBlank()) {
            Log.info("Placa es vacia o nula");
            return;
        }

        Connection con = null;
        PreparedStatement ps = null;

        String sql = """
                delete from vehiculos where placa = ?;
                """;

        try {
            con = Conexion.getConnection();
            ps = con.prepareStatement(sql);

            ps.setString(1, placa);

            int filas = ps.executeUpdate();
            Log.info("Filas eliminadas: " + filas);

        } catch (Exception e) {
            Log.error("Ocurrio un error al eliminar vehiculo: " + e.getMessage());
        } finally {
            try {
                con.close();
                ps.close();
                Log.info("Conexiones cerradas");
            } catch (Exception e) {
                Log.error("Ocurrio un error al cerrar conexiones: " + e.getMessage());
            }
        }
    }
}

