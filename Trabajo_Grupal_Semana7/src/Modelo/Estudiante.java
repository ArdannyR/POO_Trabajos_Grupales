package Modelo;

public class Estudiante extends Persona {
    protected int creditos;
    protected String curso;

    public Estudiante(String nombre, int edad, Genero genero) {
        super(nombre, edad, genero);
        this.creditos = creditos;
        this.curso = curso;
    }
}

