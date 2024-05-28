package co.edu.uniquindio.poo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        // Crear un objeto Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        // Solicitar el nombre del parqueadero
        System.out.print("Ingrese el nombre del parqueadero: ");
        String nombreParqueadero = scanner.nextLine();

        // Solicitar el número de filas y columnas del parqueadero
        System.out.print("Ingrese el número de filas del parqueadero: ");
        int filas = scanner.nextInt();

        System.out.print("Ingrese el número de columnas del parqueadero: ");
        int columnas = scanner.nextInt();

        // Crear una instancia de Parqueadero con el nombre y dimensiones proporcionadas
        Parqueadero parqueadero = new Parqueadero(nombreParqueadero, filas, columnas);

        // Solicitar las tarifas para distintos tipos de vehículos
        System.out.print("Ingrese la tarifa para motos clásicas: ");
        double tarifaClasica = scanner.nextDouble();

        System.out.print("Ingrese la tarifa para motos híbridas: ");
        double tarifaHibrida = scanner.nextDouble();

        System.out.print("Ingrese la tarifa para carros: ");
        double tarifaCarro = scanner.nextDouble();

        // Crear una instancia de TarifaHora con las tarifas proporcionadas
        TarifaHora tarifa = new TarifaHora(tarifaClasica, tarifaHibrida, tarifaCarro);
        // Crear una instancia de Coleccion con las tarifas y el parqueadero
        Coleccion coleccion = new Coleccion(tarifa, parqueadero);

        // Bucle principal del menú de opciones
        while (true) {
            try {
                // Mostrar el menú de opciones
                System.out.println("\nMenú:");
                System.out.println("1. Parquear vehículo");
                System.out.println("2. Retirar vehículo");
                System.out.println("3. Mostrar parqueadero");
                System.out.println("4. Modificar tarifas");
                System.out.println("5. Mostrar estado detallado del parqueadero");
                System.out.println("6. Mostrar ingresos diarios");
                System.out.println("7. Mostrar ingresos mensuales");
                System.out.println("8. Buscar vehículo por ID del propietario");
                System.out.println("9. Salir");
                System.out.print("Seleccione una opción: ");
                int opcion = scanner.nextInt();

                // Ejecutar la acción correspondiente a la opción seleccionada
                switch (opcion) {
                    case 1:
                        parquearVehiculo(scanner, coleccion);
                        break;
                    case 2:
                        retirarVehiculo(scanner, coleccion);
                        break;
                    case 3:
                        parqueadero.mostrarParqueadero();
                        break;
                    case 4:
                        modificarTarifas(scanner, tarifa);
                        break;
                    case 5:
                        parqueadero.mostrarParqueaderoDetallado(coleccion);
                        break;
                    case 6:
                        mostrarIngresosDiarios(scanner, coleccion);
                        break;
                    case 7:
                        mostrarIngresosMensuales(scanner, coleccion);
                        break;
                    case 8:
                        buscarVehiculoPorIdPropietario(scanner, coleccion);
                        break;
                    case 9:
                        // Salir del programa
                        System.out.println("Saliendo...");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Opción no válida.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Por favor, ingrese un número válido.");
                scanner.nextLine(); // Limpiar el buffer del scanner
            }
        }
    }

    // Método para buscar un vehículo por el ID del propietario
    private static void buscarVehiculoPorIdPropietario(Scanner scanner, Coleccion coleccion) {
        System.out.print("Ingrese el ID del propietario: ");
        int idPropietario = scanner.nextInt();
        coleccion.buscarVehiculoPorIdPropietario(idPropietario);
    }

    // Método para parquear un vehículo
    private static void parquearVehiculo(Scanner scanner, Coleccion coleccion) {
        // Solicitar y leer los datos del propietario
        System.out.print("Ingrese el nombre del propietario: ");
        scanner.nextLine(); // Consumir nueva línea
        String nombre = scanner.nextLine();

        System.out.print("Ingrese el apellido del propietario: ");
        String apellido = scanner.nextLine();

        System.out.print("Ingrese la cédula del propietario: ");
        String cedula = scanner.nextLine();

        System.out.print("Ingrese el tipo del propietario (1. Normal, 2. Comprador): ");
        int tipo = scanner.nextInt();

        System.out.print("Ingrese el ID del propietario: ");
        int idPropietario = scanner.nextInt();

        // Crear una instancia de Persona para el propietario
        Persona propietario = new Persona(nombre, apellido, cedula, tipo, idPropietario);
        coleccion.addPersona(propietario);

        // Solicitar y leer los datos del vehículo
        System.out.print("Ingrese tipo de vehículo (1. Carro, 2. Moto): ");
        int tipoVehiculo = scanner.nextInt();
        scanner.nextLine(); // Consumir nueva línea

        // Procesar según el tipo de vehículo
        if (tipoVehiculo == 1) {
            // Leer y crear una instancia de Carro
            System.out.print("Ingrese la placa del carro: ");
            String placa = scanner.nextLine();

            System.out.print("Ingrese el modelo del carro: ");
            String modelo = scanner.nextLine();

            LocalDateTime fechaLlegada = LocalDateTime.now();

            Carro carro = new Carro(placa, modelo, coleccion.getTarifa().getCarro(), idPropietario);
            coleccion.addCarro(carro, fechaLlegada);

        } else if (tipoVehiculo == 2) {
            // Leer y crear una instancia de Moto
            System.out.print("Ingrese el tipo de moto (1. Clásica, 2. Híbrida): ");
            int tipoMoto = scanner.nextInt();
            scanner.nextLine(); // Consumir nueva línea

            System.out.print("Ingrese la placa de la moto: ");
            String placa = scanner.nextLine();

            System.out.print("Ingrese el modelo de la moto: ");
            String modelo = scanner.nextLine();

            System.out.print("Ingrese la velocidad máxima de la moto: ");
            double velocidadMaxima = scanner.nextDouble();

            LocalDateTime fechaLlegada = LocalDateTime.now();

            Moto moto;
            if (tipoMoto == 1) {
                moto = new Moto(placa, modelo, coleccion.getTarifa().getClasica(), idPropietario, velocidadMaxima, "Clasica");
            } else if (tipoMoto == 2) {
                moto = new Moto(placa, modelo, coleccion.getTarifa().getHibrida(), idPropietario, velocidadMaxima, "Hibrida");
            } else {
                System.out.println("Tipo de moto no válido.");
                return;
            }
            coleccion.addMoto(moto, fechaLlegada);
        }
    }

    // Método para retirar un vehículo del parqueadero
    private static void retirarVehiculo(Scanner scanner, Coleccion coleccion) {
        System.out.print("Ingrese el ID del propietario: ");
        int idRetiro = scanner.nextInt();

        System.out.print("Ingrese la fecha de salida (formato: yyyy-MM-dd HH:mm:ss): ");
        scanner.nextLine(); // Consumir nueva línea
        String fechaSalidaStr = scanner.nextLine();
        LocalDateTime fechaSalida = LocalDateTime.parse(fechaSalidaStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        if (coleccion.retirarVehiculo(idRetiro, fechaSalida)) {
            System.out.println("Vehículo retirado exitosamente.");
        } else {
            System.out.println("No se pudo retirar el vehículo.");
        }
    }

    // Método para modificar las tarifas del parqueadero
    private static void modificarTarifas(Scanner scanner, TarifaHora tarifa) {
        System.out.print("Ingrese la nueva tarifa para motos clásicas: ");
        double tarifaClasica = scanner.nextDouble();

        System.out.print("Ingrese la nueva tarifa para motos híbridas: ");
        double tarifaHibrida = scanner.nextDouble();

        System.out.print("Ingrese la nueva tarifa para carros: ");
        double tarifaCarro = scanner.nextDouble();

        tarifa.setClasica(tarifaClasica);
        tarifa.setHibrida(tarifaHibrida);
        tarifa.setCarro(tarifaCarro);

        System.out.println("Tarifas actualizadas.");
    }

    // Método para mostrar los ingresos diarios
    private static void mostrarIngresosDiarios(Scanner scanner, Coleccion coleccion) {
        System.out.print("Ingrese la fecha (formato: yyyy-MM-dd): ");
        scanner.nextLine(); // Consumir nueva línea
        String fechaStr = scanner.nextLine();
        LocalDate fecha = LocalDate.parse(fechaStr);

        double ingresosDiarios = coleccion.obtenerIngresosDiarios(fecha);
        System.out.println("Ingresos del día " + fecha + ": $" + ingresosDiarios);
    }

    // Método para mostrar los ingresos mensuales
    private static void mostrarIngresosMensuales(Scanner scanner, Coleccion coleccion) {
        System.out.print("Ingrese el año (formato: yyyy): ");
        int year = scanner.nextInt();

        System.out.print("Ingrese el mes (formato: MM): ");
        int month = scanner.nextInt();



        double ingresosMensuales = coleccion.obtenerIngresosMensuales(year, month);
        System.out.println("Ingresos del mes " + year + "-" + String.format("%02d", month) + ": $" + ingresosMensuales);
    }

}
