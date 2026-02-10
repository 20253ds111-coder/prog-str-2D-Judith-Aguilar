import java.util.Scanner;

public class Validaciones {

    public int pedirId(Scanner sc, String mensaje) {
        int valor;
        while (true) {
            System.out.print(mensaje);
            if (sc.hasNextInt()) {
                valor = sc.nextInt();
                if (valor > 0) {
                    return valor;
                } else {
                    System.out.println("Error: El ID debe ser mayor a 0.");
                }
            } else {
                System.out.println("Error: Ingresa un número válido.");
                sc.next();
            }
        }
    }

    public String pedirNombre(Scanner sc, String mensaje) {
        String texto;
        while (true) {
            System.out.print(mensaje);
            texto = sc.next();
            if (!texto.trim().isEmpty()) {
                return texto;
            } else {
                System.out.println("Error: El nombre no puede estar vacío.");
            }
        }
    }
}