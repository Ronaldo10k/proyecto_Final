package co.edu.uniquindio.poo;

// Clase que representa un parqueadero
public class Parqueadero {
    
    // Nombre del parqueadero
    private String nombre;
    
    // Número de filas en la matriz del parqueadero
    private int horizontal;
    
    // Número de columnas en la matriz del parqueadero
    private int vertical;
    
    // Matriz que representa los puestos del parqueadero
    private Vehiculo[][] matrizPuestos;

    // Constructor que inicializa el parqueadero con su nombre, número de filas y columnas
    public Parqueadero(String nombre, int horizontal, int vertical) {
        this.nombre = nombre;
        this.horizontal = horizontal;
        this.vertical = vertical;
        this.matrizPuestos = new Vehiculo[horizontal][vertical];
    }

    // Método getter para obtener el número de filas
    public int getHorizontal() {
        return horizontal;
    }

    // Método getter para obtener el número de columnas
    public int getVertical() {
        return vertical;
    }

    // Método getter para obtener la matriz de puestos del parqueadero
    public Vehiculo[][] getMatrizPuestos() {
        return matrizPuestos;
    }

    // Método para mostrar el estado detallado del parqueadero
    public void mostrarParqueaderoDetallado(Coleccion coleccion) {
        for (int i = 0; i < horizontal; i++) {
            for (int j = 0; j < vertical; j++) {
                Vehiculo vehiculo = matrizPuestos[i][j];
                if (vehiculo == null) {
                    System.out.println("La posición (" + (i + 1) + "," + (j + 1) + ") está libre.");
                } else {
                    Persona propietario = coleccion.encontrarPersonaPorId(vehiculo.getId());
                    System.out.println("En la posición (" + (i + 1) + "," + (j + 1) + ") está " +
                        propietario.getNombre() + " " + propietario.getApellido() + " ID " +
                        propietario.getId() + " con el vehículo placa " + vehiculo.getPlaca() +
                        ", modelo " + vehiculo.getModelo() + ".");
                }
            }
        }
    }

    // Método para parquear un vehículo en una posición específica
    public boolean parquearVehiculo(Vehiculo vehiculo, int fila, int columna) {
        if (fila >= 0 && fila < horizontal && columna >= 0 && columna < vertical && matrizPuestos[fila][columna] == null) {
            matrizPuestos[fila][columna] = vehiculo;
            return true;
        }
        return false;
    }

    // Método para retirar un vehículo de una posición específica
    public boolean retirarVehiculo(int fila, int columna) {
        if (fila >= 0 && fila < horizontal && columna >= 0 && columna < vertical && matrizPuestos[fila][columna] != null) {
            matrizPuestos[fila][columna] = null;
            return true;
        }
        return false;
    }

    // Método para encontrar un espacio libre en el parqueadero
    public int[] encontrarEspacioLibre() {
        for (int i = 0; i < horizontal; i++) {
            for (int j = 0; j < vertical; j++) {
                if (matrizPuestos[i][j] == null) {
                    return new int[]{i, j};
                }
            }
        }
        return null; // No hay espacios libres
    }

    // Método para mostrar el estado del parqueadero
    public void mostrarParqueadero() {
        for (int i = 0; i < horizontal; i++) {
            for (int j = 0; j < vertical; j++) {
                if (matrizPuestos[i][j] == null) {
                    System.out.print("[ ]");
                } else {
                    System.out.print("[X]");
                }
            }
            System.out.println();
        }
    }

    // Método getter para obtener el nombre del parqueadero
    public String getNombre() {
        return nombre;
    }
}
