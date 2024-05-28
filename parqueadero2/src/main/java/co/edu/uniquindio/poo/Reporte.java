package co.edu.uniquindio.poo;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

// Clase que gestiona los reportes de ingresos diarios y mensuales
public class Reporte {
    
    // Mapa para almacenar los ingresos diarios, donde la clave es la fecha y el valor es el monto total ingresado en ese día
    private Map<LocalDate, Double> ingresosDiarios;
    
    // Mapa para almacenar los ingresos mensuales, donde la clave es una combinación de año y mes (en formato YYYYMM) y el valor es el monto total ingresado en ese mes
    private Map<Integer, Double> ingresosMensuales;

    // Constructor que inicializa los mapas de ingresos diarios y mensuales
    public Reporte() {
        this.ingresosDiarios = new HashMap<>();
        this.ingresosMensuales = new HashMap<>();
    }

    /**
     * Método para registrar un ingreso en una fecha específica
     * 
     * @param fecha La fecha del ingreso
     * @param monto El monto del ingreso
     */
    public void registrarIngreso(LocalDate fecha, double monto) {
        // Registro de ingreso diario
        ingresosDiarios.put(fecha, ingresosDiarios.getOrDefault(fecha, 0.0) + monto);

        // Registro de ingreso mensual
        int mes = fecha.getYear() * 100 + fecha.getMonthValue(); // Combina el año y el mes en un solo entero
        ingresosMensuales.put(mes, ingresosMensuales.getOrDefault(mes, 0.0) + monto);
    }

    /**
     * Método para obtener los ingresos diarios de una fecha específica
     * 
     * @param fecha La fecha de los ingresos a consultar
     * @return El monto total de los ingresos en esa fecha
     */
    public double obtenerIngresosDiarios(LocalDate fecha) {
        return ingresosDiarios.getOrDefault(fecha, 0.0);
    }

    /**
     * Método para obtener los ingresos mensuales de un mes específico
     * 
     * @param year El año del mes a consultar
     * @param month El mes a consultar
     * @return El monto total de los ingresos en ese mes
     */
    public double obtenerIngresosMensuales(int year, int month) {
        int mes = year * 100 + month; // Combina el año y el mes en un solo entero
        return ingresosMensuales.getOrDefault(mes, 0.0);
    }
}
