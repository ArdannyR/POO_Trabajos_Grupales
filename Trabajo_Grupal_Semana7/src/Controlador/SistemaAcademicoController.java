// src/Controlador/SistemaAcademicoController.java
package Controlador;

import Modelo.*; // Importa todas las clases del paquete Modelo
import java.util.ArrayList; // Para usar ArrayList
import java.util.Scanner; // Para entrada de usuario en el controlador (si se usa directamente aquí)

public class SistemaAcademicoController {
    // Colección de tipo base para el polimorfismo
    private ArrayList<Persona> listaPersonas;
    private Scanner scanner; // Para leer entradas si el controlador necesita interactuar directamente

    public SistemaAcademicoController() {
        this.listaPersonas = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    // Método para agregar cualquier tipo de Persona a la lista (Polimorfismo)
    public void agregarPersona(Persona p) {
        this.listaPersonas.add(p);
        System.out.println("\n--- Objeto agregado correctamente ---");
    }

    // Método para mostrar todos los perfiles (Polimorfismo en acción)
    public void mostrarTodosLosPerfiles() {
        if (listaPersonas.isEmpty()) {
            System.out.println("\nNo hay perfiles registrados para mostrar.");
            return;
        }
        System.out.println("\n--- Mostrando todos los perfiles registrados ---");
        for (Persona p : listaPersonas) { // Itera sobre la lista de tipo Persona
            p.mostrarPerfil(); // El polimorfismo asegura que se llama al mostrarPerfil() correcto
            System.out.println("------------------------------------------"); // Separador
        }
    }

    // Métodos para crear y añadir objetos desde el controlador (ejemplos)
    // Estos métodos podrían recibir los datos como parámetros desde Main
    public void crearYAgregarEstudiante(String nombre, int edad, Genero genero, String carrera, int creditosAcumuladosIniciales, double promedio) {
        Estudiante nuevoEstudiante = new Estudiante(nombre, edad, genero, carrera, creditosAcumuladosIniciales, promedio);
        agregarPersona(nuevoEstudiante);
    }

    public void crearYAgregarEstudianteGraduado(String nombre, int edad, Genero genero, String carrera, int creditosAcumuladosIniciales, double promedio, String temaTesis, String universidadGradoAnterior) {
        Estudiante_Graduado nuevoGraduado = new Estudiante_Graduado(nombre, edad, genero, carrera, creditosAcumuladosIniciales, promedio, temaTesis, universidadGradoAnterior);
        agregarPersona(nuevoGraduado);
    }

    public void crearYAgregarEstudianteMaestria(String nombre, int edad, Genero genero, String carrera, int creditosAcumuladosIniciales, double promedio, String areaEspecializacion, String nombreSupervisor) {
        Estudiante_Maestria nuevoMaestria = new Estudiante_Maestria(nombre, edad, genero, carrera, creditosAcumuladosIniciales, promedio, areaEspecializacion, nombreSupervisor);
        agregarPersona(nuevoMaestria);
    }

    // Método para registrar un curso a un estudiante específico por su nombre
    // NOTA: Esto es un ejemplo, buscar por nombre no es lo más robusto. 
    // Usar IDs o índices sería mejor en un sistema real.
    public void registrarCursoAEstudiante(String nombreEstudiante, String nombreCurso, int creditos) {
        Estudiante estudianteEncontrado = null;
        for (Persona p : listaPersonas) {
            // Se usa 'instanceof' para verificar si el objeto es un Estudiante o subclase de Estudiante
            if (p instanceof Estudiante && p.getNombre().equalsIgnoreCase(nombreEstudiante)) {
                estudianteEncontrado = (Estudiante) p; // Casteo a Estudiante
                break;
            }
        }

        if (estudianteEncontrado != null) {
            if (creditos > 0) {
                estudianteEncontrado.registrarCurso(nombreCurso, creditos); // Llama a la sobrecarga de 2 parámetros
            } else {
                estudianteEncontrado.registrarCurso(nombreCurso); // Llama a la sobrecarga de 1 parámetro
            }
        } else {
            System.out.println("Estudiante con nombre '" + nombreEstudiante + "' no encontrado para registrar curso.");
        }
    }
}