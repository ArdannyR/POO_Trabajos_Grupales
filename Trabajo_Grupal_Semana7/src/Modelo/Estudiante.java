package Modelo;

public class Estudiante extends Persona {
    protected int creditos;
    protected String curso;

    public Estudiante(String nombre, int edad, Genero genero, int creditos, String curso) {
        super(nombre, edad, genero);
        this.creditos = creditos;
        this.curso = curso;
    }

    @Override
    public void mostrarPerfil() {
        super.mostrarPerfil();
        System.out.printf("\nCurso: %s\nCreditos: %d\n",curso ,creditos);
    }
}

