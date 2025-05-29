// src/Modelo/Estudiante_Graduado.java
package Modelo;

public class Estudiante_Graduado extends Estudiante { // Herencia Multinivel: Estudiante_Graduado -> Estudiante -> Persona
    private String temaTesis;
    private String universidadGradoAnterior;

    // Constructor
    public Estudiante_Graduado(String nombre, int edad, Genero genero, String carrera, int creditosAcumuladosIniciales,
                               double promedio, String temaTesis, String universidadGradoAnterior) {
        super(nombre, edad, genero, carrera, creditosAcumuladosIniciales, promedio); // Llama al constructor de Estudiante
        this.temaTesis = temaTesis;
        this.universidadGradoAnterior = universidadGradoAnterior;
    }

    // Getters
    public String getTemaTesis() {
        return temaTesis;
    }

    public String getUniversidadGradoAnterior() {
        return universidadGradoAnterior;
    }

    // Setters
    public void setTemaTesis(String temaTesis) {
        this.temaTesis = temaTesis;
    }

    public void setUniversidadGradoAnterior(String universidadGradoAnterior) {
        this.universidadGradoAnterior = universidadGradoAnterior;
    }

    // Sobreescritura del método mostrarPerfil()
    @Override
    public void mostrarPerfil() {
        super.mostrarPerfil(); // Muestra la información de Estudiante (que ya incluye la de Persona)
        System.out.println("--- Información de Estudiante Graduado ---");
        System.out.println("Tema de Tesis: " + this.temaTesis);
        System.out.println("Universidad de Grado Anterior: " + this.universidadGradoAnterior);
    }
}