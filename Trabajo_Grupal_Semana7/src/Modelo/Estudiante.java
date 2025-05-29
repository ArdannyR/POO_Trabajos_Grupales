package Modelo;

public class Estudiante extends Persona {
    protected int creditos;
    protected String carrera;

    public Estudiante(String nombre, int edad, Genero genero, int creditos, String carrera) {
        super(nombre, edad, genero);
        this.creditos = creditos;
        this.carrera = carrera;
    }

    @Override
    public void mostrarPerfil() {
        super.mostrarPerfil();
        System.out.printf("\nCarrera: %s\nCreditos: %d\n",carrera ,creditos);
    }
}

