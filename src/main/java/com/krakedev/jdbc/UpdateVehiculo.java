package com.krakedev.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.krakedev.entidades.Vehiculo;

public class UpdateVehiculo {
    private static final Logger Log = LogManager.getLogger(UpdateVehiculo.class);

    public static void update(Vehiculo vehiculo) {
        if (vehiculo == null || vehiculo.getPlaca() == null || vehiculo.getPlaca().isBlank()) {
            Log.info("Vehiculo vacio o nulo no se puede actualizar");
            return;
        }

        Connection con = null;
        PreparedStatement ps = null;

        String sql = """
                update vehiculos set
                marca = ?,
                modelo = ?,
                anio = ?,
                precio = ?,
                color = ?,
                disponible = ?,
                kilometraje = ?
                where placa = ?;
                """;

        try {
            con = Conexion.getConnection();
            ps = con.prepareStatement(sql);

            ps.setString(1, vehiculo.getMarca());
            ps.setString(2, vehiculo.getModelo());
            ps.setInt(3, vehiculo.getAnio());
            ps.setDouble(4, vehiculo.getPrecio());
            ps.setString(5, vehiculo.getColor());
            ps.setBoolean(6, vehiculo.isDisponible());
            ps.setInt(7, vehiculo.getKilometraje());
            
            // condicion where
            ps.setString(8, vehiculo.getPlaca());

            int filas = ps.executeUpdate();
            Log.info("Filas actualizadas: " + filas);

        } catch (Exception e) {
            Log.error("Ocurrio un error al actualizar vehiculo: " + e.getMessage());
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

