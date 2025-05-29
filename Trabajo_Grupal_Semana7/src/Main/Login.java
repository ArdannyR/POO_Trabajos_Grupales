package Main;
import java.util.Scanner;

import Main.Menu;

public class Login extends Menu {
    String usuario = "estudiante";
    String contraseña = "12345";
    String usuarioIngresado;
    String contraseñaIngresada;
    int contador = 0;

    public void loginmostrar(){
        while (contador < 3){
            Scanner sc = new Scanner (System.in);
            System.out.print("Ingrese usuario (estudiante): ");
            usuarioIngresado = sc.nextLine();
            System.out.print("Ingrese su contraseña (12345): ");
            contraseñaIngresada = sc.nextLine();

            if (usuarioIngresado.equals(usuario) & contraseñaIngresada.equals(contraseña)){
                contador = 3;
                System.out.println("Bienvenido al sistema...");
                mostrar();
            }else {
                System.out.println("Usuario o contraseña incorrectos.");
                contador++;
            }
        }
        System.out.print("Demasiados intentos, se bloqueara el sistema.");
    }
}
