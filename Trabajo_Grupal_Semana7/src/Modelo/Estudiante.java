package Modelo;

import java.util.ArrayList;

public class Estudiante extends Persona {
    protected String carrera;
    protected int creditosAcumulados;
    protected double promedio;
    protected ArrayList<String> cursosInscritos;

    public Estudiante(String nombre, int edad, Genero genero, String carrera, int creditosAcumulados, double promedio, ArrayList<String> cursosInscritos) {
        super(nombre, edad, genero);
        this.carrera = carrera;
        this.creditosAcumulados = creditosAcumulados;
        this.promedio = promedio;
        this.cursosInscritos = cursosInscritos;
    }

    @Override
    public void mostrarPerfil() {
        super.mostrarPerfil(); // Llama al metodo mostrarPerfil() de la clase Persona
        System.out.println("--- Información de Estudiante ---");
        System.out.println("Carrera: " + carrera);
        System.out.println("Créditos Acumulados: " + creditosAcumulados); // Muestra el total
        System.out.println("Promedio: " + promedio);
        System.out.println("Cursos Inscritos: ");
        if (cursosInscritos.isEmpty()) {
            System.out.println("  Ninguno");
        } else {
            for (String cursoInfo : cursosInscritos) { // Itera sobre cadenas (String)
                System.out.println("  - " + cursoInfo); // La cadena ya contiene nombre y créditos
            }
        }
        System.out.println("---------------------------------");
    }

    // Sobrecarga del metodo registrarCurso() (Versión 1: solo nombre)
    public void registrarCurso(String nombreCurso) {
        if (nombreCurso != null && !nombreCurso.trim().isEmpty()) {
            int creditosPorDefecto = 3; // O cualquier valor por defecto que consideres
            String cursoFormateado = nombreCurso + " (" + creditosPorDefecto + " créditos)";
            this.cursosInscritos.add(cursoFormateado);
            this.creditosAcumulados += creditosPorDefecto; // Sumar al total de créditos acumulados
            System.out.println(this.getNombre() + " ha registrado el curso: " + nombreCurso + " (asignados " + creditosPorDefecto + " créditos).");
        } else {
            System.out.println("Error: El nombre del curso no puede estar vacío.");
        }
    }

    // Sobrecarga del metodo registrarCurso() (Versión 2: nombre y créditos)
    public void registrarCurso(String nombreCurso, int creditos) {
        if (nombreCurso != null && !nombreCurso.trim().isEmpty() && creditos > 0) {
            String cursoFormateado = nombreCurso + " (" + creditos + " créditos)";
            this.cursosInscritos.add(cursoFormateado);
            this.creditosAcumulados += creditos; // Sumar al total de créditos acumulados
            System.out.println(this.getNombre() + " ha registrado el curso: " + nombreCurso + " con " + creditos + " créditos.");
        } else {
            System.out.println("Error: Nombre de curso inválido o créditos no válidos.");
        }
    }
}

