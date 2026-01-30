import java.util.Scanner;

public class Main {
    public static int fueraDelRango = 0;
    public static int datoNoNumerico = 0;
    public static void main(String[]arg) {
        int opcion = 0;
        double dato = 0;
        double resultado = 0;
        Scanner sc = new Scanner(System.in);
        do {

            System.out.println("menú");
            System.out.println("  1) °C a °F");
            System.out.println("  2) °F a °C");
            System.out.println("  3) Km a Millas");
            System.out.println("  4) Millas a Km");
            System.out.println("  5) Salir");
        }while(opcion >= 1 && opcion <= 5);

        switch (opcion){
            case 1:
                System.out.println("ingresaste a la opcion uno");
                dato = recivirDato(sc,"ingrese los °C");
                resultado = conversionC(dato);
            case 2:
                System.out.println("ingresaste a la opcion dos");
                dato = recivirDato(sc,"ingrese los °F");
                resultado = conversionF(dato);
            case 3:
                System.out.println("ingresaste a la opcion tre");
                dato = recivirDato(sc,"ingrese los Kilometros");
                resultado = conversionKilometros(dato);
            case 4:
                System.out.println("ingresaste a la opcion cuatro");
                System.out.println("ingrese las millas");
            case 5:
                System.out.println("selecciono salir");
                break;
            default:
                System.out.println("opcion invalida");
                break;
        }
    }

    public static int obtenerNumeroValido(Scanner sc, String mensaje) {
        int opcion;
        while (true) {
            System.out.println(mensaje);
            if (sc.hasNextInt()) {
                //Es un dato numerico025
                opcion = sc.nextInt();
                if (opcion >= 1 && opcion <= 5) {
                    return opcion;
                } else {
                    System.out.println("el dato ingresado no está dentro del rango");
                    fueraDelRango++;
                }
            } else {
                System.out.println("El dato ingresado no es numerico");
                sc.next(); //para limpiar lo que ingrese el usuario
                datoNoNumerico++;
            }
        }
    }
    public static double recivirDato(Scanner sc, String mensaje) {
        System.out.println(mensaje); // Mensaje de otro lado
        return sc.nextDouble(); // regresamos lo ingresado
    }
    public static double conversionC(double dato) {
        return (dato*(9/5) + 32);
    }
    public static double conversionF(double dato) {
        return (dato - 32) * 5 / 9;
    }
    public static double conversionKilometros(double dato) {
        return (dato*(9/5) + 32);
    }
    public static double conversionMillas(double dato) {
        return (dato*(9/5) + 32);
    }

}