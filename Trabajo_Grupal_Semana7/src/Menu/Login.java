package Menu;
import java.util.Scanner;

public class Login extends Menu {
    private Scanner sc = new Scanner(System.in);

    public void loginmostrar(){
        String usuario = "juan";
        String contraseña = "12345";
        String usuarioIngresado;
        String contraseñaIngresada;

        for (int i = 0; i < 5; i++) {
            System.out.println("Ingrese usuario: ");
            usuarioIngresado = sc.next();
            System.out.println("Ingrese su contraseña");
            contraseñaIngresada = sc.next();

            if (usuarioIngresado.equals(usuario) & contraseñaIngresada.equals(contraseña)){
                System.out.println("Bienvenido");
                mostrar();
            }
        }
    }
}
