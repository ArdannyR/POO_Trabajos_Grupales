// src/Modelo/Estudiante_Graduado.java
package Modelo;

public class Estudiante_Graduado extends Estudiante {
    private String temaTesis;

    public Estudiante_Graduado(String nombre, int edad, Genero genero, String carrera, double promedio, String temaTesis) {
        super(nombre, edad, genero, carrera, promedio); // Llama al constructor de Estudiante
        this.temaTesis = temaTesis;
    }

    // Getter
    public String getTemaTesis() { return temaTesis; }

    // Setter
    public void setTemaTesis(String temaTesis) { this.temaTesis = temaTesis; }

    @Override
    public void mostrarPerfil() {
        super.mostrarPerfil(); // Muestra información de Estudiante y Persona
        System.out.println("--- Información de Estudiante Graduado ---");
        System.out.println("Tema de Tesis: " + this.temaTesis);
    }
}