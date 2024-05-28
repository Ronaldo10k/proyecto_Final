/**
 * Clase para probar el funcionamiento del código
 * @author Área de programación UQ
 * @since 2024
 * 
 * Licencia GNU/GPL V3.0 (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE) 
 */
package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class ColeccionTest {
    private static final Logger LOG = Logger.getLogger(ColeccionTest.class.getName());

    /**
     * Rigorous Test :-)
     */
    @Test
    public void testAgregarMoto() {
        LOG.info("Iniciado test testAgregarMoto");
        Parqueadero parqueadero = new Parqueadero("Nombre", 5, 5);
        Coleccion coleccion = new Coleccion(new TarifaHora(1000.0, 1500.0, 2000.0), parqueadero);
        Moto moto = new Moto("ABC123", "Modelo", 1000.0, 1, 200.0, "Clasica");
        coleccion.addMoto(moto, LocalDateTime.now());
        assertEquals(1, coleccion.getMotos().size());
        LOG.info("Finalizando test testAgregarMoto");
    }
    @Test
    public void testRetirarVehiculo() {
        LOG.info("Iniciando test testRetirarVehiculo");
        Parqueadero parqueadero = new Parqueadero("Nombre", 5, 5);
        Coleccion coleccion = new Coleccion(new TarifaHora(1000.0, 1500.0, 2000.0), parqueadero);
        Moto moto = new Moto("ABC123", "Modelo", 1000.0, 1, 200.0, "Clasica");
        coleccion.addMoto(moto, LocalDateTime.now());
        assertTrue(coleccion.retirarVehiculo(1, LocalDateTime.now()));
        LOG.info("Finalizando test testRetirarVehiculo");
    }
    @Test
    public void testObtenerIngresosDiarios() {
        LOG.info("Iniciando test testObtenerIngresosDiarios");
        Parqueadero parqueadero = new Parqueadero("Nombre", 5, 5);
        Coleccion coleccion = new Coleccion(new TarifaHora(1000.0, 1500.0, 2000.0), parqueadero);
        coleccion.addMoto(new Moto("ABC123", "Modelo", 1000.0, 1, 200.0, "Clasica"), LocalDateTime.now());
        assertEquals(1000.0, coleccion.obtenerIngresosDiarios(LocalDate.now()));
        LOG.info("Finalizando Test testObtenerIngresosDiarios");
    }

}