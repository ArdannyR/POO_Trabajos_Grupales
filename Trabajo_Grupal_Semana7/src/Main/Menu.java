package Main;

import Modelo.Estudiante_Graduado;

import java.util.Scanner;

public class Menu {
    private Scanner sc = new Scanner (System.in);

    public void mostrar(){
        int opcion;

        do {
            System.out.println("=========Menu principal========");
            System.out.println("1. Registrarse como estudiante");
            System.out.println("2. Ver estudiantes registrados");
            System.out.println("3. Observar estudiantes graduados");
            System.out.println("4. Observar estudiantes en maestria");
            System.out.println("5. Salir");
            System.out.println("==============================");
            System.out.print("Ingrese una opcion: ");
            opcion = sc.nextInt();

            switch (opcion){
                case 1:
                    /*Funcion registrarse*/;
                    break;
                case 2:
                    /*Funcion ver estudiantes*/
                    break;
                case 3:
                    /*Funcion estudiantes graduados*/
                    break;
                case 4:
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida.");

            }
        } while(opcion != 5);
    }
}
