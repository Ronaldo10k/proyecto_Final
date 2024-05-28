package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class VehiculoTest {

    private Vehiculo vehiculo;

    @BeforeEach
    public void setUp() {
        vehiculo = new Vehiculo("ABC123", "Toyota", 10000, 1);
    }

    @Test
    public void testGetPlaca() {
        // Verifica que la placa es la esperada
        assertEquals("ABC123", vehiculo.getPlaca(), "La placa del vehículo debería ser 'ABC123'");
    }

    @Test
    public void testGetModelo() {
        // Verifica que el modelo es el esperado
        assertEquals("Toyota", vehiculo.getModelo(), "El modelo del vehículo debería ser 'Toyota'");
    }

    @Test
    public void testGetTarifa() {
        // Verifica que la tarifa es la esperada
        assertEquals(10000, vehiculo.getTarifa(), "La tarifa del vehículo debería ser 10000");
    }

    @Test
    public void testGetId() {
        // Verifica que el ID es el esperado
        assertEquals(1, vehiculo.getId(), "El ID del vehículo debería ser 1");
    }
}
