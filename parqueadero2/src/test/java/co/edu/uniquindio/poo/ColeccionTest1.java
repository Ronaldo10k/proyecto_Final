package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;

public class ColeccionTest1 {

    private Coleccion coleccion;
    private Parqueadero parqueadero;
    private TarifaHora tarifa;
    private Persona persona;
    private Carro carro;
    private Moto moto;

    @BeforeEach
    public void setUp() {
        tarifa = new TarifaHora(5000, 7000, 10000);
        parqueadero = new Parqueadero("Central", 3, 3);
        coleccion = new Coleccion(tarifa, parqueadero);

        persona = new Persona("John", "Doe", "123456789", 1, 1);
        carro = new Carro("XYZ789", "Honda", 10000, 1);
        moto = new Moto("DEF456", "Yamaha", 7000, 2, 200, "Clasica");

        coleccion.addPersona(persona);
    }

    @Test
    public void testAddCarro() {
        // Añadir un carro y verificar si se añadió correctamente
        coleccion.addCarro(carro, LocalDateTime.now());
        assertEquals(1, coleccion.getCarros().size(), "Debería haber un carro en la colección");
    }

    @Test
    public void testAddMoto() {
        // Añadir una moto y verificar si se añadió correctamente
        coleccion.addMoto(moto, LocalDateTime.now());
        assertEquals(1, coleccion.getMotos().size(), "Debería haber una moto en la colección");
    }

    @Test
    public void testRetirarVehiculo() {
        // Añadir y luego retirar un carro
        coleccion.addCarro(carro, LocalDateTime.now());
        boolean retirado = coleccion.retirarVehiculo(1, LocalDateTime.now().plusHours(2));
        assertTrue(retirado, "El carro debería haberse retirado correctamente");
    }

    @Test
    public void testBuscarVehiculoPorIdPropietario() {
        // Añadir un carro y buscarlo por el ID del propietario
        coleccion.addCarro(carro, LocalDateTime.now());
        coleccion.buscarVehiculoPorIdPropietario(1);
    }
}
