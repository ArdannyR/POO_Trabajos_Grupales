package Nivel_1;

public class Persona {

    // Atributos de la superclase 'Persona'
    private String nombre;
    private int edad;
    private boolean genero;

    // Metodo constructor
    public Persona(String nombre, int edad, boolean genero) {
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

    public boolean getGenero() {
        return genero;
    }

    public void setGenero(boolean genero) {
        this.genero = genero;
    }
}
