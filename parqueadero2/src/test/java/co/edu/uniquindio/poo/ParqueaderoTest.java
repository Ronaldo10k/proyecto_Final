/**
 * Clase para probar el funcionamiento del código
 * @author Área de programación UQ
 * @since 2024
 * 
 * Licencia GNU/GPL V3.0 (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE) 
 */
package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;


public class ParqueaderoTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void testParquearVehiculo() {
        Parqueadero parqueadero = new Parqueadero("Nombre", 5, 5);
        Vehiculo vehiculo = new Vehiculo("ABC123", "Modelo", 1000.0, 1);
        assertTrue(parqueadero.parquearVehiculo(vehiculo, 0, 0));
    }
    @Test
    public void testRetirarVehiculo() {
        Parqueadero parqueadero = new Parqueadero("Nombre", 5, 5);
        Vehiculo vehiculo = new Vehiculo("ABC123", "Modelo", 1000.0, 1);
        parqueadero.parquearVehiculo(vehiculo, 0, 0);
        assertTrue(parqueadero.retirarVehiculo(0, 0));
    }
    @Test
    public void testEncontrarEspacioLibre() {
        Parqueadero parqueadero = new Parqueadero("Nombre", 5, 5);
        int[] espacioLibre = parqueadero.encontrarEspacioLibre();
        assertNotNull(espacioLibre);
    }
}
