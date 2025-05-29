// src/Main/Main.java
package Main;

import Controlador.SistemaAcademicoController;
import Modelo.Estudiante;
import Modelo.Estudiante_Graduado;
import Modelo.Estudiante_Maestria;
import Modelo.Genero; // Necesario para el enum Genero
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static SistemaAcademicoController controller = new SistemaAcademicoController();

    public static void main(String[] args) {
        int opcion;
        System.out.println("--- Bienvenido al Sistema Académico Simplificado ---");

        do {
            mostrarMenu();
            opcion = obtenerOpcion();

            switch (opcion) {
                case 1:
                    crearEstudianteCompleto(); // Incluye registro de curso
                    break;
                case 2:
                    crearEstudianteGraduadoCompleto(); // Incluye registro de curso por defecto
                    break;
                case 3:
                    crearEstudianteMaestriaCompleto(); // Incluye registro de curso por defecto
                    break;
                case 4:
                    controller.mostrarTodosLosPerfiles();
                    break;
                case 0:
                    System.out.println("Saliendo del sistema. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, intente de nuevo.");
            }
            System.out.println("\nPresione Enter para continuar...");
            scanner.nextLine(); // Consumir el salto de línea pendiente después de la pausa
        } while (opcion != 0);

        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("\n--- MENÚ PRINCIPAL ---");
        System.out.println("1. Crear Estudiante (Básico)");
        System.out.println("2. Crear Estudiante Graduado");
        System.out.println("3. Crear Estudiante de Maestría");
        System.out.println("4. Mostrar Todos los Perfiles");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static int obtenerOpcion() {
        try {
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea
            return opcion;
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Por favor, ingrese un número.");
            scanner.nextLine(); // Consumir la entrada incorrecta
            return -1;
        }
    }

    private static Genero obtenerGenero() {
        String generoStr;
        Genero genero = null;
        boolean valido = false;
        while (!valido) {
            System.out.print("Género (MASCULINO, FEMENINO, NO_BINARIO, OTRO): ");
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

    private static int obtenerIntValido(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                int valor = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea
                return valor;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número entero.");
                scanner.nextLine(); // Consumir la entrada incorrecta
            }
        }
    }

    private static double obtenerDoubleValido(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                double valor = scanner.nextDouble();
                scanner.nextLine(); // Consumir el salto de línea
                return valor;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número decimal.");
                scanner.nextLine(); // Consumir la entrada incorrecta
            }
        }
    }

    // Método general para solicitar datos básicos de Persona/Estudiante
    private static Estudiante solicitarDatosEstudianteBase() {
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        int edad = obtenerIntValido("Edad: ");
        Genero genero = obtenerGenero();
        System.out.print("Carrera: ");
        String carrera = scanner.nextLine();
        double promedio = obtenerDoubleValido("Promedio: ");
        return new Estudiante(nombre, edad, genero, carrera, promedio);
    }

    // 1. Crear Estudiante y registrar curso
    private static void crearEstudianteCompleto() {
        System.out.println("\n--- Crear Nuevo Estudiante ---");
        Estudiante nuevoEstudiante = solicitarDatosEstudianteBase();
        controller.agregarPersona(nuevoEstudiante);

        System.out.println("\n--- Registrar primer curso para " + nuevoEstudiante.getNombre() + " ---");
        System.out.print("Nombre del primer curso: ");
        String nombreCurso = scanner.nextLine();
        System.out.print("¿Desea especificar los créditos? (s/n): ");
        String opcionCreditos = scanner.nextLine().trim().toLowerCase();

        if (opcionCreditos.equals("s")) {
            int creditos = obtenerIntValido("Créditos del curso: ");
            nuevoEstudiante.registrarCurso(nombreCurso, creditos);
        } else {
            nuevoEstudiante.registrarCurso(nombreCurso); // Usa créditos por defecto
        }
    }

    // 2. Crear Estudiante Graduado (sin registrar curso inicial para simplificar)
    private static void crearEstudianteGraduadoCompleto() {
        System.out.println("\n--- Crear Nuevo Estudiante Graduado ---");
        Estudiante baseEstudiante = solicitarDatosEstudianteBase(); // Reutiliza la lógica
        System.out.print("Tema de Tesis: ");
        String temaTesis = scanner.nextLine();

        Estudiante_Graduado nuevoGraduado = new Estudiante_Graduado(
                baseEstudiante.getNombre(), baseEstudiante.getEdad(), baseEstudiante.getGenero(),
                baseEstudiante.getCarrera(), baseEstudiante.getPromedio(), temaTesis
        );
        controller.agregarPersona(nuevoGraduado);

        // Opcional: Registrar un curso por defecto para este tipo si se desea
        System.out.print("¿Desea registrar un curso para " + nuevoGraduado.getNombre() + " (por defecto)? (s/n): ");
        String regCurso = scanner.nextLine().trim().toLowerCase();
        if (regCurso.equals("s")) {
            nuevoGraduado.registrarCurso("Seminario de Postgrado");
        }
    }

    // 3. Crear Estudiante Maestría (sin registrar curso inicial para simplificar)
    private static void crearEstudianteMaestriaCompleto() {
        System.out.println("\n--- Crear Nuevo Estudiante de Maestría ---");
        Estudiante baseEstudiante = solicitarDatosEstudianteBase(); // Reutiliza la lógica
        System.out.print("Área de Especialización: ");
        String areaEspecializacion = scanner.nextLine();
        System.out.print("Nombre del Supervisor: ");
        String nombreSupervisor = scanner.nextLine();

        Estudiante_Maestria nuevoMaestria = new Estudiante_Maestria(
                baseEstudiante.getNombre(), baseEstudiante.getEdad(), baseEstudiante.getGenero(),
                baseEstudiante.getCarrera(), baseEstudiante.getPromedio(), areaEspecializacion, nombreSupervisor
        );
        controller.agregarPersona(nuevoMaestria);

        // Opcional: Registrar un curso por defecto para este tipo si se desea
        System.out.print("¿Desea registrar un curso para " + nuevoMaestria.getNombre() + " (por defecto)? (s/n): ");
        String regCurso = scanner.nextLine().trim().toLowerCase();
        if (regCurso.equals("s")) {
            nuevoMaestria.registrarCurso("Metodología de la Investigación");
        }
    }
}