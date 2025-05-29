// src/Modelo/Estudiante_Maestria.java
package Modelo;

public class Estudiante_Maestria extends Estudiante {
    private String areaEspecializacion;
    private String nombreSupervisor;

    public Estudiante_Maestria(String nombre, int edad, Genero genero, String carrera, double promedio, String areaEspecializacion, String nombreSupervisor) {
        super(nombre, edad, genero, carrera, promedio); // Llama al constructor de Estudiante
        this.areaEspecializacion = areaEspecializacion;
        this.nombreSupervisor = nombreSupervisor;
    }

    // Getters
    public String getAreaEspecializacion() { return areaEspecializacion; }
    public String getNombreSupervisor() { return nombreSupervisor; }

    // Setters
    public void setAreaEspecializacion(String areaEspecializacion) { this.areaEspecializacion = areaEspecializacion; }
    public void setNombreSupervisor(String nombreSupervisor) { this.nombreSupervisor = nombreSupervisor; }

    @Override
    public void mostrarPerfil() {
        super.mostrarPerfil(); // Muestra información de Estudiante y Persona
        System.out.println("--- Información de Estudiante de Maestría ---");
        System.out.println("Área de Especialización: " + this.areaEspecializacion);
        System.out.println("Nombre del Supervisor: " + this.nombreSupervisor);
    }
}