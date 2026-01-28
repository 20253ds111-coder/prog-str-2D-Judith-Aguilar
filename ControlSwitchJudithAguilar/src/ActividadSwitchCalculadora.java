import java.util.Scanner;

public class ActividadSwitchCalculadora {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        double variableA = 0;
        double variableB = 0;
        double resultado = 0;

        System.out.println("Menu");
        System.out.println("1-Suma");
        System.out.println("2-Resta");
        System.out.println("3-Multiplicacion");
        System.out.println("4-Division");
        opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                variableA = recivirDato(scanner, "Ingresa el primer numero:");
                variableB = recivirDato(scanner, "Ingresa el segundo numero:");
                resultado = calcularSuma(variableA, variableB);
                break;
            case 2:
                variableA = recivirDato(scanner, "Ingresa el primer numero:");
                variableB = recivirDato(scanner, "Ingresa el segundo numero:");
                resultado = calcularResta(variableA, variableB);
                break;
            case 3:
                variableA = recivirDato(scanner, "Ingresa el primer numero:");
                variableB = recivirDato(scanner, "Ingresa el segundo numero:");
                resultado = calcularMultiplicacion(variableA, variableB);
                break;
            case 4:
                variableA = recivirDato(scanner, "Ingresa el primer numero:");
                variableB = recivirDato(scanner, "Ingresa el segundo numero:");

                if (variableB == 0) {
                    System.out.println("No se puede dividir entre 0");
                } else {
                    resultado = calcularDivision(variableA, variableB);
                }
                break;
            default:
                System.out.println("Opcion invalida");
                break;
        }

        if (opcion >= 1 && opcion <= 4){
            String opcionElegida = opcionSeleccionada(opcion);
            System.out.println("elegiste la opción de:"+ opcionElegida);
            System.out.println("Tus valores fueron: " + variableA+ "y"+ variableB);

            if (opcion == 4 && variableB == 0){
                return;
            }else {
                System.out.println("el resultado es:"+ resultado);
            }
        }


    }

    public static double recivirDato(Scanner sc, String mensaje) {
        System.out.println(mensaje); // Mensaje de otro lado
        return sc.nextDouble(); // regresamos lo ingresado
    }

    public static double calcularSuma(double variableA, double variableB) {
        return variableA + variableB;
    }

    public static double calcularResta(double variableA, double variableB) {
        return variableA - variableB;
    }

    public static double calcularMultiplicacion(double variableA, double variableB) {
        return variableA * variableB;
    }

    public static double calcularDivision(double variableA, double variableB) {
        return variableA / variableB;
    }
    public static String opcionSeleccionada(int opcion) {
        if (opcion == 1) {
            return "suma";
        } else if (opcion == 2) {
            return "resta";
        }else if (opcion == 3) {
            return "multiplicación";
        }else {
            return "división";
        }
    }

}