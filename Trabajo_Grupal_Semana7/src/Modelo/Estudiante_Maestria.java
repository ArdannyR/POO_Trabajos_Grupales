// src/Modelo/Estudiante_Maestria.java
package Modelo;

public class Estudiante_Maestria extends Estudiante { // Herencia Jerárquica: Estudiante_Maestria -> Estudiante -> Persona
    private String areaEspecializacion;
    private String nombreSupervisor;

    // Constructor
    public Estudiante_Maestria(String nombre, int edad, Genero genero, String carrera, int creditosAcumuladosIniciales,
                               double promedio, String areaEspecializacion, String nombreSupervisor) {
        super(nombre, edad, genero, carrera, creditosAcumuladosIniciales, promedio); // Llama al constructor de Estudiante
        this.areaEspecializacion = areaEspecializacion;
        this.nombreSupervisor = nombreSupervisor;
    }

    // Getters
    public String getAreaEspecializacion() {
        return areaEspecializacion;
    }

    public String getNombreSupervisor() {
        return nombreSupervisor;
    }

    // Setters
    public void setAreaEspecializacion(String areaEspecializacion) {
        this.areaEspecializacion = areaEspecializacion;
    }

    public void setNombreSupervisor(String nombreSupervisor) {
        this.nombreSupervisor = nombreSupervisor;
    }

    // Sobreescritura del método mostrarPerfil()
    @Override
    public void mostrarPerfil() {
        super.mostrarPerfil(); // Muestra la información de Estudiante (que ya incluye la de Persona)
        System.out.println("--- Información de Estudiante de Maestría ---");
        System.out.println("Área de Especialización: " + this.areaEspecializacion);
        System.out.println("Nombre del Supervisor: " + this.nombreSupervisor);
    }
}