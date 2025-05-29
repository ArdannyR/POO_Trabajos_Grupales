package Modelo;

import java.util.ArrayList;

public class Estudiante extends Persona {
    protected String carrera;
    protected double promedio;
    protected ArrayList<String> cursosInscritos;

    public Estudiante(String nombre, int edad, Genero genero, int creditos, String carrera) {
        super(nombre, edad, genero);
        this.carrera = carrera;
        this.promedio = promedio;
    }

    @Override
    public void mostrarPerfil() {
        super.mostrarPerfil();
        System.out.printf("\nCarrera: %s\nCreditos: %d\n",carrera ,creditos);
    }
}

