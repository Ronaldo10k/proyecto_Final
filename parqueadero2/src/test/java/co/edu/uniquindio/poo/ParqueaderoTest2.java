package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ParqueaderoTest2 {

    private Parqueadero parqueadero;
    private Carro carro;

    @BeforeEach
    public void setUp() {
        parqueadero = new Parqueadero("Central", 3, 3);
        carro = new Carro("XYZ789", "Honda", 10000, 1);
    }

    @Test
    public void testParquearVehiculo() {
        // Verificar si se puede parquear un vehículo
        boolean parqueado = parqueadero.parquearVehiculo(carro, 0, 0);
        assertTrue(parqueado, "El vehículo debería haberse parqueado correctamente");
    }

    @Test
    public void testRetirarVehiculo() {
        // Parquear y luego retirar un vehículo
        parqueadero.parquearVehiculo(carro, 0, 0);
        boolean retirado = parqueadero.retirarVehiculo(0, 0);
        assertTrue(retirado, "El vehículo debería haberse retirado correctamente");
    }

    @Test
    public void testEncontrarEspacioLibre() {
        // Verificar si se encuentra un espacio libre
        int[] espacioLibre = parqueadero.encontrarEspacioLibre();
        assertNotNull(espacioLibre, "Debería haber al menos un espacio libre en el parqueadero");
    }
}
