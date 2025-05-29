package Modelo;

import java.util.ArrayList;

public class Estudiante extends Persona {
    protected String carrera;
    protected int creditos;
    protected double promedio;
    protected ArrayList<String> cursosInscritos;

    public Estudiante(String nombre, int edad, Genero genero, String carrera, int creditos, double promedio, ArrayList<String> cursosInscritos) {
        super(nombre, edad, genero);
        this.carrera = carrera;
        this.creditos = creditos;
        this.promedio = promedio;
        this.cursosInscritos = cursosInscritos;
    }

    @Override
    public void mostrarPerfil() {
        super.mostrarPerfil();
        System.out.println("Carrera: " + carrera);
        System.out.println("Créditos: " + creditos);
        System.out.println("Promedio: " + promedio);
        System.out.println("Cursos Inscritos: " + cursosInscritos);
    }
}

