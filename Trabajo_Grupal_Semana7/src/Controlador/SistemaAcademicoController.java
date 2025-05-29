// src/Controlador/SistemaAcademicoController.java
package Controlador;

import Modelo.*; // Importa todas las clases del paquete Modelo
import java.util.ArrayList; // Para usar ArrayList

public class SistemaAcademicoController {
    private ArrayList<Persona> listaPersonas; // Colección de tipo base para el polimorfismo

    public SistemaAcademicoController() {
        this.listaPersonas = new ArrayList<>();
    }

    // Añade cualquier objeto de tipo Persona (o sus subclases) a la lista
    public void agregarPersona(Persona p) {
        this.listaPersonas.add(p);
        System.out.println("-> " + p.getNombre() + " ha sido agregado al sistema.");
    }

    // Muestra todos los perfiles registrados usando polimorfismo
    public void mostrarTodosLosPerfiles() {
        if (listaPersonas.isEmpty()) {
            System.out.println("\n--- No hay perfiles registrados para mostrar. ---");
            return;
        }
        System.out.println("\n--- Mostrando todos los perfiles registrados ---");
        for (Persona p : listaPersonas) { // Itera sobre la lista de tipo Persona
            p.mostrarPerfil(); // El polimorfismo asegura que se llama al método correcto
            System.out.println("------------------------------------------"); // Separador
        }
    }

    // Busca un estudiante por nombre y lo retorna (para registrarle cursos)
    public Estudiante buscarEstudiantePorNombre(String nombre) {
        for (Persona p : listaPersonas) {
            // Verifica si es una instancia de Estudiante o sus subclases
            if (p instanceof Estudiante && p.getNombre().equalsIgnoreCase(nombre)) {
                return (Estudiante) p; // Casteo seguro
            }
        }
        return null; // No encontrado
    }
}