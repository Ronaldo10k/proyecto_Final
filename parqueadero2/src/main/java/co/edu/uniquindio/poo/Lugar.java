package co.edu.uniquindio.poo;

// Clase que representa un lugar específico en un parqueadero
public class Lugar {
    
    // Coordenada i (fila) del lugar en la matriz del parqueadero
    private int i;
    
    // Coordenada j (columna) del lugar en la matriz del parqueadero
    private int j;
    
    // ID asociado al lugar
    private int id;

    // Constructor que inicializa las coordenadas y el ID del lugar
    public Lugar(int i, int j, int id) {
        this.i = i;
        this.j = j;
        this.id = id;
    }

    // Método getter para obtener la coordenada i (fila)
    public int getI() {
        return i;
    }

    // Método getter para obtener la coordenada j (columna)
    public int getJ() {
        return j;
    }

    // Método getter para obtener el ID del lugar
    public int getId() {
        return id;
    }
}
