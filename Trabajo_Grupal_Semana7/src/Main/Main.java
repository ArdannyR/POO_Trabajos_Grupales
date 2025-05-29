// src/Main/Main.java
package Main;

import Controlador.SistemaAcademicoController;
import Modelo.Genero; // Necesario para el enum Genero
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SistemaAcademicoController controller = new SistemaAcademicoController(); // Instancia del controlador
        int opcion;

        System.out.println("--- Bienvenido al Sistema Académico ---");

        do {
            mostrarMenu();
            opcion = obtenerOpcion(scanner);

            switch (opcion) {
                case 1:
                    crearEstudiante(scanner, controller);
                    break;
                case 2:
                    crearEstudianteGraduado(scanner, controller);
                    break;
                case 3:
                    crearEstudianteMaestria(scanner, controller);
                    break;
                case 4:
                    registrarCurso(scanner, controller);
                    break;
                case 5:
                    controller.mostrarTodosLosPerfiles(); // Polimorfismo en acción
                    break;
                case 0:
                    System.out.println("Saliendo del sistema. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, intente de nuevo.");
            }
            System.out.println("\nPresione Enter para continuar...");
            scanner.nextLine(); // Consumir el salto de línea pendiente
        } while (opcion != 0);

        scanner.close(); // Cierra el scanner al salir del programa
    }

    // Métodos auxiliares para el menú
    private static void mostrarMenu() {
        System.out.println("\n--- MENÚ PRINCIPAL ---");
        System.out.println("1. Crear Estudiante");
        System.out.println("2. Crear Estudiante Graduado");
        System.out.println("3. Crear Estudiante de Maestría");
        System.out.println("4. Registrar Curso a Estudiante");
        System.out.println("5. Mostrar Todos los Perfiles");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static int obtenerOpcion(Scanner scanner) {
        try {
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea pendiente
            return opcion;
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Por favor, ingrese un número.");
            scanner.nextLine(); // Consumir la entrada incorrecta
            return -1; // Retorna un valor inválido para que el switch lo maneje
        }
    }

    private static Genero obtenerGenero(Scanner scanner) {
        String generoStr;
        Genero genero = null;
        boolean valido = false;
        while (!valido) {
            System.out.print("Género (MASCULINO, FEMENINO): ");
            generoStr = scanner.nextLine().trim().toUpperCase();
            try {
                genero = Genero.valueOf(generoStr);
                valido = true;
            } catch (IllegalArgumentException e) {
                System.out.println("Género inválido. Intente de nuevo.");
            }
        }
        return genero;
    }

    // Métodos para crear cada tipo de estudiante y pasarlo al controlador
    private static void crearEstudiante(Scanner scanner, SistemaAcademicoController controller) {
        System.out.println("\n--- Crear Nuevo Estudiante ---");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Edad: ");
        int edad = obtenerIntValido(scanner);
        Genero genero = obtenerGenero(scanner);
        System.out.print("Carrera: ");
        String carrera = scanner.nextLine();
        System.out.print("Créditos Acumulados Iniciales: ");
        int creditosIniciales = obtenerIntValido(scanner);
        System.out.print("Promedio: ");
        double promedio = obtenerDoubleValido(scanner);

        controller.crearYAgregarEstudiante(nombre, edad, genero, carrera, creditosIniciales, promedio);
    }

    private static void crearEstudianteGraduado(Scanner scanner, SistemaAcademicoController controller) {
        System.out.println("\n--- Crear Nuevo Estudiante Graduado ---");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Edad: ");
        int edad = obtenerIntValido(scanner);
        Genero genero = obtenerGenero(scanner);
        System.out.print("Carrera: ");
        String carrera = scanner.nextLine();
        System.out.print("Créditos Acumulados Iniciales: ");
        int creditosIniciales = obtenerIntValido(scanner);
        System.out.print("Promedio: ");
        double promedio = obtenerDoubleValido(scanner);
        System.out.print("Tema de Tesis: ");
        String temaTesis = scanner.nextLine();
        System.out.print("Universidad de Grado Anterior: ");
        String universidadAnterior = scanner.nextLine();

        controller.crearYAgregarEstudianteGraduado(nombre, edad, genero, carrera, creditosIniciales, promedio, temaTesis, universidadAnterior);
    }

    private static void crearEstudianteMaestria(Scanner scanner, SistemaAcademicoController controller) {
        System.out.println("\n--- Crear Nuevo Estudiante de Maestría ---");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Edad: ");
        int edad = obtenerIntValido(scanner);
        Genero genero = obtenerGenero(scanner);
        System.out.print("Carrera: ");
        String carrera = scanner.nextLine();
        System.out.print("Créditos Acumulados Iniciales: ");
        int creditosIniciales = obtenerIntValido(scanner);
        System.out.print("Promedio: ");
        double promedio = obtenerDoubleValido(scanner);
        System.out.print("Área de Especialización: ");
        String areaEspecializacion = scanner.nextLine();
        System.out.print("Nombre del Supervisor: ");
        String nombreSupervisor = scanner.nextLine();

        controller.crearYAgregarEstudianteMaestria(nombre, edad, genero, carrera, creditosIniciales, promedio, areaEspecializacion, nombreSupervisor);
    }

    private static void registrarCurso(Scanner scanner, SistemaAcademicoController controller) {
        System.out.println("\n--- Registrar Curso a Estudiante ---");
        System.out.print("Nombre del estudiante a quien registrar el curso: ");
        String nombreEstudiante = scanner.nextLine();
        System.out.print("Nombre del curso: ");
        String nombreCurso = scanner.nextLine();
        System.out.print("¿Desea especificar los créditos del curso? (s/n): ");
        String opcionCreditos = scanner.nextLine().trim().toLowerCase();

        if (opcionCreditos.equals("s")) {
            System.out.print("Créditos del curso: ");
            int creditos = obtenerIntValido(scanner);
            controller.registrarCursoAEstudiante(nombreEstudiante, nombreCurso, creditos);
        } else {
            controller.registrarCursoAEstudiante(nombreEstudiante, nombreCurso, 0); // 0 indica que no se especificaron créditos, se usará por defecto
        }
    }


    // Métodos para obtener entradas válidas y manejar errores
    private static int obtenerIntValido(Scanner scanner) {
        while (true) {
            try {
                int valor = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea pendiente
                return valor;
            } catch (InputMismatchException e) {
                System.out.print("Entrada inválida. Por favor, ingrese un número entero: ");
                scanner.nextLine(); // Consumir la entrada incorrecta
            }
        }
    }

    private static double obtenerDoubleValido(Scanner scanner) {
        while (true) {
            try {
                double valor = scanner.nextDouble();
                scanner.nextLine(); // Consumir el salto de línea pendiente
                return valor;
            } catch (InputMismatchException e) {
                System.out.print("Entrada inválida. Por favor, ingrese un número decimal: ");
                scanner.nextLine(); // Consumir la entrada incorrecta
            }
        }
    }
}