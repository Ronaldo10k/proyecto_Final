package co.edu.uniquindio.poo;

/**
 * Clase que representa un vehículo genérico.
 */
public class Vehiculo {
    // Atributos del vehículo
    private String placa;   // Placa del vehículo
    private String modelo;  // Modelo del vehículo
    private double tarifa;  // Tarifa por hora para el vehículo
    private int id;         // ID único del propietario del vehículo

    /**
     * Constructor para inicializar un vehículo.
     *
     * @param placa  Placa del vehículo.
     * @param modelo Modelo del vehículo.
     * @param tarifa Tarifa por hora para el vehículo.
     * @param id     ID único del propietario del vehículo.
     */
    public Vehiculo(String placa, String modelo, double tarifa, int id) {
        this.placa = placa;
        this.modelo = modelo;
        this.tarifa = tarifa;
        this.id = id;
    }

    /**
     * Obtiene la placa del vehículo.
     *
     * @return La placa del vehículo.
     */
    public String getPlaca() {
        return placa;
    }

    /**
     * Obtiene el modelo del vehículo.
     *
     * @return El modelo del vehículo.
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Obtiene la tarifa por hora del vehículo.
     *
     * @return La tarifa por hora del vehículo.
     */
    public double getTarifa() {
        return tarifa;
    }

    /**
     * Obtiene el ID del propietario del vehículo.
     *
     * @return El ID del propietario del vehículo.
     */
    public int getId() {
        return id;
    }
}