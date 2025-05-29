// src/Modelo/Estudiante.java
package Modelo;

import java.util.ArrayList;

public class Estudiante extends Persona { // Herencia Simple
    protected String carrera;
    protected int creditosAcumulados; // Total de créditos acumulados por el estudiante
    protected double promedio;
    // ArrayList<String> para guardar los cursos (formato "NombreCurso (X créditos)")
    protected ArrayList<String> cursosInscritos;

    // Constructor
    public Estudiante(String nombre, int edad, Genero genero, String carrera, int creditosAcumuladosIniciales, double promedio) {
        super(nombre, edad, genero); // Llama al constructor de la superclase Persona
        this.carrera = carrera;
        this.creditosAcumulados = creditosAcumuladosIniciales;
        this.promedio = promedio;
        this.cursosInscritos = new ArrayList<>(); // Inicializa la lista de cursos
    }

    // Getters
    public String getCarrera() {
        return carrera;
    }

    public int getCreditosAcumulados() {
        return creditosAcumulados;
    }

    public double getPromedio() {
        return promedio;
    }

    public ArrayList<String> getCursosInscritos() {
        return cursosInscritos;
    }

    // Setters (puedes añadir más si son necesarios)
    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public void setCreditosAcumulados(int creditosAcumulados) {
        this.creditosAcumulados = creditosAcumulados;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }

    // Sobreescritura del método mostrarPerfil()
    @Override
    public void mostrarPerfil() {
        super.mostrarPerfil(); // Muestra la información de Persona
        System.out.println("--- Información de Estudiante ---");
        System.out.println("Carrera: " + this.carrera);
        System.out.println("Créditos Acumulados: " + this.creditosAcumulados);
        System.out.println("Promedio: " + this.promedio);
        System.out.println("Cursos Inscritos:");
        if (cursosInscritos.isEmpty()) {
            System.out.println("  Ninguno");
        } else {
            for (String cursoInfo : cursosInscritos) {
                System.out.println("  - " + cursoInfo); // La cadena ya tiene formato "Nombre (Créditos)"
            }
        }
    }

    // Sobrecarga del método registrarCurso() (Versión 1: solo nombre)
    public void registrarCurso(String nombreCurso) {
        if (nombreCurso != null && !nombreCurso.trim().isEmpty()) {
            int creditosPorDefecto = 3; // Créditos por defecto para cursos sin especificar
            String cursoFormateado = nombreCurso + " (" + creditosPorDefecto + " créditos)";
            this.cursosInscritos.add(cursoFormateado);
            this.creditosAcumulados += creditosPorDefecto; // Sumar al total de créditos
            System.out.println(this.getNombre() + " ha registrado el curso: " + nombreCurso + " (asignados " + creditosPorDefecto + " créditos).");
        } else {
            System.out.println("Error: El nombre del curso no puede estar vacío.");
        }
    }

    // Sobrecarga del método registrarCurso() (Versión 2: nombre y créditos)
    public void registrarCurso(String nombreCurso, int creditos) {
        if (nombreCurso != null && !nombreCurso.trim().isEmpty() && creditos > 0) {
            String cursoFormateado = nombreCurso + " (" + creditos + " créditos)";
            this.cursosInscritos.add(cursoFormateado);
            this.creditosAcumulados += creditos; // Sumar al total de créditos acumulados
            // ¡¡¡Línea Corregida AQUÍ!!!
            System.out.println(this.getNombre() + " ha registrado el curso: " + cursoFormateado + "."); // Usar cursoFormateado
        } else {
            System.out.println("Error: Nombre de curso inválido o créditos no válidos.");
        }
    }
}