package Modelo;

public class Persona {

    // Atributos privados (Encapsulamiento)
    private String nombre;
    private int edad;
    private Genero genero; // Usamos el enum Genero

    // Constructor
    public Persona(String nombre, int edad, Genero genero) {
        this.nombre = nombre;
        this.edad = edad;
        this.genero = genero;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public Genero getGenero() {
        return genero;
    }

    // Setters (algunos ejemplos, puedes añadir más si son necesarios)
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    // Metodo mostrarPerfil()
    public void mostrarPerfil() {
        System.out.println("\n--- Perfil de Persona ---");
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Edad: " + this.edad + " años");
        System.out.println("Género: " + this.genero);
    }
}