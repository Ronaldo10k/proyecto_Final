package co.edu.uniquindio.poo;

// Clase que representa una moto, hereda de Vehiculo
public class Moto extends Vehiculo {

    // Atributo que almacena la velocidad máxima de la moto
    private double velocidadMaxima;

    // Atributo que almacena el tipo de moto ("Clasica", "Hibrida")
    private String tipo;

    // Constructor que inicializa los atributos de la moto
    public Moto(String placa, String modelo, double tarifa, int id, double velocidadMaxima, String tipo) {
        super(placa, modelo, tarifa, id); // Llama al constructor de la clase base Vehiculo
        this.velocidadMaxima = velocidadMaxima;
        this.tipo = tipo;
    }

    // Método getter para obtener la velocidad máxima de la moto
    public double getVelocidadMaxima() {
        return velocidadMaxima;
    }

    // Método getter para obtener el tipo de moto
    public String getTipo() {
        return tipo;
    }
}
