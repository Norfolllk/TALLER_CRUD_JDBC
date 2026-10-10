package com.krakedev.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.krakedev.entidades.Vehiculo;

public class SelectVehiculo {
    private static final Logger Log = LogManager.getLogger(SelectVehiculo.class);

    public static void select() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = """
                select placa, marca, modelo, anio, precio, color, disponible from vehiculos;
                """;

        try {
            con = Conexion.getConnection();
            ps = con.prepareStatement(sql);

            rs = ps.executeQuery();

            while (rs.next()) {
                Vehiculo vehiculo = new Vehiculo();
                vehiculo.setPlaca(rs.getString("placa"));
                vehiculo.setMarca(rs.getString("marca"));
                vehiculo.setModelo(rs.getString("modelo"));
                vehiculo.setAnio(rs.getInt("anio"));
                vehiculo.setPrecio(rs.getDouble("precio"));
                vehiculo.setColor(rs.getString("color"));
                vehiculo.setDisponible(rs.getBoolean("disponible"));

                Log.info(vehiculo);
            }
        } catch (Exception e) {
            Log.error("Ocurrio un error al mostrar datos de vehiculos: ", e.getMessage());
        } finally {
            try {
                con.close();
                ps.close();
                rs.close();
                Log.info("Se cerraron las conexiones de forma correcta");
            } catch (SQLException e) {
                Log.error("Ocurrio un error al cerrar las conexiones: ", e.getMessage());
            }
        }
    }
}
