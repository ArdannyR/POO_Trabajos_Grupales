package Nivel_1;

public class Persona {

    // Definición del enum
    enum Genero {
        MASCULINO, FEMENINO
    }

    // Atributos de la superclase 'Persona'
    private String nombre;
    private int edad;
    private Genero genero;

    // Metodo constructor
    public Persona(String nombre, int edad, Genero genero) {
        this.nombre = nombre;
        this.edad = edad;
        this.genero = genero;
    }

    // Metodo mostrarPerfil()
    public void mostrarPerfil() {
        System.out.println("\nInformación: ");
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Género: " + genero);
    }

    // Metodos get y set
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }
}
