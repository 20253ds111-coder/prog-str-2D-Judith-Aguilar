import java.util.Scanner;

public class ValidarDatos {

    public int pedirEntero(Scanner sc, String texto, Usuario[] usuarios){
        int dato = 0;
        while (true){
            System.out.print(texto);
            if (sc.hasNextInt()){
                dato = sc.nextInt();
                if (dato >= 0 && dato < 20){
                    return dato;
                } else {
                    System.out.println("Error: El codigo debe ser entre 0 y 20");
                }
            } else {
                System.out.println("Error: Debes ingresar un numero valido");
                sc.next(); // Limpiar buffer
            }
        }
    }

    public String pedirTexto(Scanner sc, String texto){
        while (true){
            System.out.print(texto);
            String entrada = sc.next();
            if (!entrada.isEmpty()){
                return entrada;
            } else {
                System.out.print("Error: Debes escribir algo");
                sc.next();
            }
        }
    }
}