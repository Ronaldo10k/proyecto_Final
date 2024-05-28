package co.edu.uniquindio.poo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

// Clase Coleccion que maneja las operaciones relacionadas con el parqueadero
public class Coleccion {

    // Listas para almacenar personas, motos, carros, fechas de llegadas, fechas de salidas y cobros
    private List<Persona> personas;
    private List<Moto> motos;
    private List<Carro> carros;
    private List<FechaRegistro> fechasLlegadas;
    private List<FechaRegistro> fechasSalidas;
    private List<Cobro> cobros;
    
    // Tarifas por hora para diferentes tipos de vehículos
    private TarifaHora tarifa;
    
    // Instancia del parqueadero
    private Parqueadero parqueadero;
    
    // Reporte para gestionar ingresos
    private Reporte reporte;

    // Constructor que inicializa las listas y los atributos del parqueadero y tarifa
    public Coleccion(TarifaHora tarifa, Parqueadero parqueadero) {
        this.tarifa = tarifa;
        this.personas = new ArrayList<>();
        this.motos = new ArrayList<>();
        this.carros = new ArrayList<>();
        this.fechasLlegadas = new ArrayList<>();
        this.fechasSalidas = new ArrayList<>();
        this.cobros = new ArrayList<>();
        this.parqueadero = parqueadero;
        this.reporte = new Reporte();
    }
    
    // Método para buscar un vehículo por el ID del propietario
    public void buscarVehiculoPorIdPropietario(int idPropietario) {
        Vehiculo vehiculoEncontrado = null;
        int fila = -1;
        int columna = -1;

        // Buscar el vehículo por el ID del propietario en la matriz del parqueadero
        for (int i = 0; i < parqueadero.getHorizontal(); i++) {
            for (int j = 0; j < parqueadero.getVertical(); j++) {
                Vehiculo vehiculo = parqueadero.getMatrizPuestos()[i][j];
                if (vehiculo != null && vehiculo.getId() == idPropietario) {
                    vehiculoEncontrado = vehiculo;
                    fila = i;
                    columna = j;
                    break;
                }
            }
            if (vehiculoEncontrado != null) {
                break;
            }
        }

        // Mostrar la información del vehículo encontrado
        if (vehiculoEncontrado != null && fila != -1 && columna != -1) {
            Persona propietario = encontrarPersonaPorId(idPropietario);
            if (propietario != null) {
                System.out.println("El vehículo del propietario " + propietario.getNombre() + " " + propietario.getApellido() +
                    " está ubicado en la posición (" + (fila + 1) + "," + (columna + 1) + ") con placa " +
                    vehiculoEncontrado.getPlaca() + " y modelo " + vehiculoEncontrado.getModelo() + ".");
            } else {
                System.out.println("No se encontró el propietario con ID " + idPropietario + ".");
            }
        } else {
            System.out.println("No se encontró un vehículo con el ID del propietario proporcionado.");
        }
    }

    // Método para agregar una persona a la colección
    public void addPersona(Persona persona) {
        this.personas.add(persona);
    }

    // Método para agregar una moto al parqueadero
    public void addMoto(Moto moto, LocalDateTime fechaLlegada) {
        int[] espacioLibre = parqueadero.encontrarEspacioLibre();
        if (espacioLibre != null) {
            if (parqueadero.parquearVehiculo(moto, espacioLibre[0], espacioLibre[1])) {
                this.motos.add(moto);
                this.fechasLlegadas.add(new FechaRegistro(fechaLlegada, moto.getId()));
                long horas = 1;  // Asumimos una hora para este ejemplo
                double costo = horas * tarifa.getClasica();
                reporte.registrarIngreso(fechaLlegada.toLocalDate(), costo);
            }
        } else {
            System.out.println("No hay espacios disponibles en el parqueadero.");
        }
    }

    // Método para agregar un carro al parqueadero
    public void addCarro(Carro carro, LocalDateTime fechaLlegada) {
        int[] espacioLibre = parqueadero.encontrarEspacioLibre();
        if (espacioLibre != null) {
            if (parqueadero.parquearVehiculo(carro, espacioLibre[0], espacioLibre[1])) {
                this.carros.add(carro);
                this.fechasLlegadas.add(new FechaRegistro(fechaLlegada, carro.getId()));
            }
        } else {
            System.out.println("No hay espacios disponibles en el parqueadero.");
        }
    }

    // Método para retirar un vehículo del parqueadero
    public boolean retirarVehiculo(int idPropietario, LocalDateTime fechaSalida) {
        Vehiculo vehiculoARetirar = null;
        int fila = -1;
        int columna = -1;

        // Buscar el vehículo por el ID del propietario
        for (int i = 0; i < parqueadero.getHorizontal(); i++) {
            for (int j = 0; j < parqueadero.getVertical(); j++) {
                Vehiculo vehiculo = parqueadero.getMatrizPuestos()[i][j];
                if (vehiculo != null && vehiculo.getId() == idPropietario) {
                    vehiculoARetirar = vehiculo;
                    fila = i;
                    columna = j;
                    break;
                }
            }
            if (vehiculoARetirar != null) {
                break;
            }
        }

        // Retirar el vehículo y calcular el costo
        if (vehiculoARetirar != null && fila != -1 && columna != -1) {
            if (parqueadero.retirarVehiculo(fila, columna)) {
                this.fechasSalidas.add(new FechaRegistro(fechaSalida, vehiculoARetirar.getId()));
                double costo = calcularCosto(vehiculoARetirar, fechaSalida);
                System.out.println("Costo a pagar: $" + costo);
                this.cobros.add(new Cobro(costo, vehiculoARetirar.getId()));

                // Registrar ingreso en el reporte
                reporte.registrarIngreso(fechaSalida.toLocalDate(), costo);

                return true;
            }
        } else {
            System.out.println("No se encontró un vehículo con el ID del propietario proporcionado.");
        }
        return false;
    }

    // Método para obtener los ingresos diarios
    public double obtenerIngresosDiarios(LocalDate fecha) {
        return reporte.obtenerIngresosDiarios(fecha);
    }

    // Método para obtener los ingresos mensuales
    public double obtenerIngresosMensuales(int year, int month) {
        return reporte.obtenerIngresosMensuales(year, month);
    }

    // Método para calcular el costo del estacionamiento de un vehículo
    private double calcularCosto(Vehiculo vehiculo, LocalDateTime fechaSalida) {
        LocalDateTime fechaLlegada = fechasLlegadas.stream()
                .filter(fr -> fr.getId() == vehiculo.getId())
                .findFirst().get().getFechaRegistrada();
        long horas = java.time.Duration.between(fechaLlegada, fechaSalida).toHours();
    
        if (vehiculo instanceof Carro) {
            return horas * tarifa.getCarro();
        } else if (vehiculo instanceof Moto) {
            Moto moto = (Moto) vehiculo;
            if (moto.getTipo().equals("Clasica")) {
                return horas * tarifa.getClasica();
            } else if (moto.getTipo().equals("Hibrida")) {
                return horas * tarifa.getHibrida();
            }
        }
        return 0;
    }

    // Método para encontrar una persona por su ID
    public Persona encontrarPersonaPorId(int id) {
        for (Persona persona : personas) {
            if (persona.getId() == id) {
                return persona;
            }
        }
        return null;
    }

    // Getters para las listas y atributos de la colección
    public List<Persona> getPersonas() {
        return personas;
    }

    public List<Moto> getMotos() {
        return motos;
    }

    public List<Carro> getCarros() {
        return carros;
    }

    public List<FechaRegistro> getFechasLlegadas() {
        return fechasLlegadas;
    }

    public List<FechaRegistro> getFechasSalidas() {
        return fechasSalidas;
    }

    public List<Cobro> getCobros() {
        return cobros;
    }

    public TarifaHora getTarifa() {
        return tarifa;
    }
}
