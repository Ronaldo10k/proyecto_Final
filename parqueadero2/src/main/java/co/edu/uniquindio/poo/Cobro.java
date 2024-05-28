package co.edu.uniquindio.poo;

public class Cobro {
    // Atributo que almacena el cálculo del cobro
    private double calculo;
    
    // Atributo que almacena el ID del cobro
    private int id;
    
    // Constructor de la clase Cobro
    // Inicializa los atributos 'calculo' e 'id' con los valores proporcionados
    public Cobro(double calculo, int id) {
        this.calculo = calculo;
        this.id = id;
    }
    
    // Método getter para obtener el valor del cálculo del cobro
    public double getCalculo() {
        return calculo;
    }
    
    // Método getter para obtener el ID del cobro
    public int getId() {
        return id;
    }
}