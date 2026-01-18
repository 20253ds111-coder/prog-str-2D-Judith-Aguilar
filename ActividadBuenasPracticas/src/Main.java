import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Declaración de variables y llamadas a métodos
        int numeroIngresado = pedirNumero();
        int sumaFinal = sumarHastaN(numeroIngresado);

        // Mostrar resultado
        System.out.println("La suma de 1 hasta " + numeroIngresado + " es: " + sumaFinal);
    }

    // En este método se pide al usuario un número y se valida
    public static int pedirNumero() {
        Scanner sc = new Scanner(System.in);
        int numeroIngresado;

        do {
            System.out.print("Introduce un número entero positivo: ");
            // Verificamos si se ingresó un entero (opcional, pero buena práctica básica)
            while (!sc.hasNextInt()) {
                System.out.println("Eso no es un número válido.");
                sc.next(); // limpiar entrada incorrecta
                System.out.print("Introduce un número entero positivo: ");
            }
            numeroIngresado = sc.nextInt();

            if (numeroIngresado < 1) {
                System.out.println("El número ingresado no es válido, intenta otro");
            }

        } while (numeroIngresado < 1); // Repite si es menor a 1

        // No cerramos el scanner aquí si lo usamos en main, pero en este diseño simple está bien dejarlo así o cerrarlo en main.
        // Para este ejercicio puntual, retornamos el valor.
        return numeroIngresado;
    }

    // Aquí se suman los números de 1 hasta el número ingresado
    public static int sumarHastaN(int numero) {
        int suma = 0;
        for (int i = 1; i <= numero; i++) {
            suma += i;
        }
        return suma;
    }
}