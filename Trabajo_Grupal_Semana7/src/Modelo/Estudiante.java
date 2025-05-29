// src/Modelo/Estudiante.java
package Modelo;

import java.util.ArrayList;

public class Estudiante extends Persona {
    protected String carrera;
    protected int creditosAcumulados;
    protected double promedio;
    protected ArrayList<String> cursosInscritos; // Formato "NombreCurso (X créditos)"

    public Estudiante(String nombre, int edad, Genero genero, String carrera, double promedio) {
        super(nombre, edad, genero); // Llama al constructor de Persona
        this.carrera = carrera;
        this.promedio = promedio;
        this.creditosAcumulados = 0; // Se inicializa en 0, los créditos se suman al registrar cursos
        this.cursosInscritos = new ArrayList<>();
    }

    // Getters
    public String getCarrera() { return carrera; }
    public int getCreditosAcumulados() { return creditosAcumulados; }
    public double getPromedio() { return promedio; }
    public ArrayList<String> getCursosInscritos() { return cursosInscritos; }

    // Setters
    public void setCarrera(String carrera) { this.carrera = carrera; }
    public void setPromedio(double promedio) { this.promedio = promedio; }

    @Override
    public void mostrarPerfil() {
        super.mostrarPerfil();
        System.out.println("--- Información de Estudiante ---");
        System.out.println("Carrera: " + this.carrera);
        System.out.println("Promedio: " + this.promedio);
        System.out.println("Créditos Acumulados: " + this.creditosAcumulados);
        System.out.println("Cursos Inscritos:");
        if (cursosInscritos.isEmpty()) {
            System.out.println("  Ninguno");
        } else {
            for (String cursoInfo : cursosInscritos) {
                System.out.println("  - " + cursoInfo);
            }
        }
    }

    // Sobrecarga: registrarCurso(String nombre)
    public void registrarCurso(String nombreCurso) {
        int creditosPorDefecto = 3;
        String cursoFormateado = nombreCurso + " (" + creditosPorDefecto + " créditos)";
        this.cursosInscritos.add(cursoFormateado);
        this.creditosAcumulados += creditosPorDefecto;
        System.out.println("  -> " + this.getNombre() + " ha registrado el curso: " + nombreCurso + " (asignados " + creditosPorDefecto + " créditos).");
    }

    // Sobrecarga: registrarCurso(String nombre, int creditos)
    public void registrarCurso(String nombreCurso, int creditos) {
        if (creditos > 0) {
            String cursoFormateado = nombreCurso + " (" + creditos + " créditos)";
            this.cursosInscritos.add(cursoFormateado);
            this.creditosAcumulados += creditos;
            System.out.println("  -> " + this.getNombre() + " ha registrado el curso: " + nombreCurso + " con " + creditos + " créditos.");
        } else {
            System.out.println("  Error: Créditos inválidos para el curso " + nombreCurso + ".");
        }
    }
}