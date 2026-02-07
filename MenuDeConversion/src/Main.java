import java.util.Scanner;

public class Main {
    // Variables para el resumen final
    public static int celciusFahrenheit = 0, fahrenheitCelcius = 0, kmMillas = 0, millasKm = 0;

    public static void main(String[] arg) {
        int opcion = 0;
        double dato = 0;
        double resultado = 0;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Menú de Conversiones");
            System.out.println("  1) °C a °F");
            System.out.println("  2) °F a °C");
            System.out.println("  3) Km a Millas");
            System.out.println("  4) Millas a Km");
            System.out.println("  5) Salir");

            // Usamos tu método de validación para la opción
            opcion = obtenerNumeroValido(sc, "Seleccione una opción:");

            switch (opcion) {
                case 1:
                    System.out.println("Ingresaste a la opcion uno");
                    dato = recivirDato(sc, "Ingrese los °C:");
                    resultado = conversionC(dato);
                    System.out.println("Resultado: " + resultado + " °F");
                    celciusFahrenheit++;
                    break;
                case 2:
                    System.out.println("Ingresaste a la opcion dos");
                    dato = recivirDato(sc, "Ingrese los °F:");
                    resultado = conversionF(dato);
                    System.out.println("Resultado: " + resultado + " °C");
                    fahrenheitCelcius++;
                    break;
                case 3:
                    System.out.println("Ingresaste a la opcion tres");
                    dato = recivirDato(sc, "Ingrese los Kilometros:");
                    resultado = conversionKilometros(dato);
                    System.out.println("Resultado: " + resultado + " Millas");
                    kmMillas++;
                    break;
                case 4:
                    System.out.println("Ingresaste a la opcion cuatro");
                    dato = recivirDato(sc, "Ingrese las Millas:");
                    resultado = conversionMillas(dato);
                    System.out.println("Resultado: " + resultado + " Km");
                    millasKm++;
                    break;
                case 5:
                    System.out.println("Seleccionó salir...");
                    break;
            }

        } while (opcion != 5);

        // resumen al salir
        imprimirResumen();
        sc.close();
    }

    public static int obtenerNumeroValido(Scanner sc, String mensaje) {
        int opcion;
        while (true) {
            System.out.print(mensaje + " ");
            if (sc.hasNextInt()) {
                opcion = sc.nextInt();
                if (opcion >= 1 && opcion <= 5) {
                    return opcion;
                } else {
                    System.out.println("Error: El dato ingresado no está dentro del rango (1-5)");
                }
            } else {
                System.out.println("Error: El dato ingresado no es numerico");
                sc.next(); // para limpiar lo que ingrese el usuario
            }
        }
    }

    public static double recivirDato(Scanner sc, String mensaje) {
        while (true) {
            System.out.print(mensaje + " ");
            if (sc.hasNextDouble()) {
                return sc.nextDouble(); // regresamos lo ingresado
            } else {
                System.out.println("Error: Ingrese un valor numérico válido.");
                sc.next(); // Limpiar de nuevo
            }
        }
    }

    public static double conversionC(double dato) {
        return (dato * (9.0 / 5.0) + 32);
    }

    public static double conversionF(double dato) {
        return (dato - 32) * 5 / 9;
    }

    public static double conversionKilometros(double dato) {
        return dato * 0.621371;
    }

    public static double conversionMillas(double dato) {
        return dato * 1.60934;
    }

    public static void imprimirResumen() {
        System.out.println("sus conversiones fueron las siguientes:");
        System.out.println("Conversiones °C a °F: " + celciusFahrenheit);
        System.out.println("Conversiones °F a °C: " + fahrenheitCelcius);
        System.out.println("Conversiones Km a Millas: " + kmMillas);
        System.out.println("Conversiones Millas a Km: " + millasKm);
        System.out.println("Total realizado: " + (celciusFahrenheit + fahrenheitCelcius + kmMillas + millasKm));
    }
}