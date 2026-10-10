package com.krakedev.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.krakedev.entidades.Vehiculo;
import com.krakedev.jdbc.UpdateVehiculo;

public class UpdateVehiculoTest {
    private static final Logger Log = LogManager.getLogger(UpdateVehiculoTest.class);

    public static void main(String[] args) {
        Vehiculo vehiculo = new Vehiculo("PDA-1236", "Chery", "Tigo 7 pro max", 2020, 15000, "naranja", true, 20000);
        Vehiculo vehiculo2 = null;

        UpdateVehiculo.update(vehiculo);
    }
}
