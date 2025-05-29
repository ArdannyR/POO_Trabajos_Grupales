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

    // Sobrecarga del metodo registrarCurso() (Versión 1: solo nombre)
    public void registrarCurso(String nombreCurso) {
        if (nombreCurso != null && !nombreCurso.trim().isEmpty()) {
            this.cursosInscritos.add(nombreCurso);
            System.out.println(this.getNombre() + " ha registrado el curso: " + nombreCurso);
        } else {
            System.out.println("Error: El nombre del curso no puede estar vacío.");
        }
    }

    // Sobrecarga del metodo registrarCurso() (Versión 2: nombre y créditos)
    public void registrarCurso(String nombreCurso, int creditos) {
        if (nombreCurso != null && !nombreCurso.trim().isEmpty() && creditos > 0) {
            // Guardar el nombre con los créditos para mostrarlo, o solo el nombre
            this.cursosInscritos.add(nombreCurso + " (" + creditos + " créditos)");
            System.out.println(this.getNombre() + " ha registrado el curso: " + nombreCurso + " con " + creditos + " créditos.");
        } else {
            System.out.println("Error: Nombre de curso inválido o créditos no válidos.");
        }

}

