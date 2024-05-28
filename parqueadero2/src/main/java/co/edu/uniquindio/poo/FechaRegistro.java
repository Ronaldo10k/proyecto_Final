package co.edu.uniquindio.poo;

import java.time.LocalDateTime;

// Clase que representa un registro de fecha asociado a un ID
public class FechaRegistro {
    
    // Atributo para almacenar la fecha y hora del registro
    private LocalDateTime fechaRegistrada;
    
    // Atributo para almacenar el ID asociado al registro
    private int id;

    // Constructor que inicializa la fecha registrada y el ID
    public FechaRegistro(LocalDateTime fechaRegistrada, int id) {
        this.fechaRegistrada = fechaRegistrada;
        this.id = id;
    }

    // Método getter para obtener la fecha registrada
    public LocalDateTime getFechaRegistrada() {
        return fechaRegistrada;
    }

    // Método getter para obtener el ID
    public int getId() {
        return id;
    }
}
