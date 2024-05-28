package co.edu.uniquindio.poo;

// Clase que representa una persona
public class Persona {
    
    // Nombre de la persona
    private String nombre;
    
    // Apellido de la persona
    private String apellido;
    
    // Cédula de la persona
    private String cedula;
    
    // Tipo de persona (puede representar distintos roles o categorías)
    private int tipo;
    
    // ID único de la persona
    private int id;

    // Constructor que inicializa los atributos de la persona
    public Persona(String nombre, String apellido, String cedula, int tipo, int id) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.tipo = tipo;
        this.id = id;
    }

    // Método getter para obtener el nombre de la persona
    public String getNombre() {
        return nombre;
    }

    // Método getter para obtener el apellido de la persona
    public String getApellido() {
        return apellido;
    }

    // Método getter para obtener la cédula de la persona
    public String getCedula() {
        return cedula;
    }

    // Método getter para obtener el tipo de persona
    public int getTipo() {
        return tipo;
    }

    // Método getter para obtener el ID de la persona
    public int getId() {
        return id;
    }
}
