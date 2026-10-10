package com.krakedev.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.krakedev.entidades.Vehiculo;
import com.krakedev.jdbc.InsertVehiculo;

public class InsertVehiculoTest {
    private static final Logger Log = LogManager.getLogger(InsertVehiculoTest.class);

    public static void main(String[] args) {
        Vehiculo vehiculo = new Vehiculo("PDA-1235", "KIA", "Rio", 2022, 20000.99, "Gris", true, 20000);
        
        InsertVehiculo.insertar(vehiculo);
    }
}
