import java.util.Scanner;

public class ActividadIfElseTarifa {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int edad = 0;
        int opcion = 0;
        int tarifa = 0;
        boolean esEstudiante = false;

        System.out.println("ingrese su edad:");
        edad = scanner.nextInt();

        System.out.println("¿eres estudiante?");
        System.out.println("1-SI, 2-NO");1
        opcion = scanner.nextInt();
        esEstudiante = comprobarSiEsEstudiante(opcion);

        if (edad < 0 || edad > 120){
            System.out.println("edad inválida");
            return;
        }

        tarifa = calcularTarifa(edad, esEstudiante);
        System.out.println("tu edad es:" + edad);

        if (esEstudiante == true){
            System.out.println("es un estudiante");
        }else {
            System.out.println("no es un estudiante");
        }
        System.out.println("Tarifa final: $" + tarifa);

    }
    public static int calcularTarifa(int edad, boolean esEstudiante){
        if (edad < 12){
            return 50;
        }else if (edad >= 12 && edad <= 17){
            if (esEstudiante == true){
                return 60;
            }else{
                return  80;
            }
        }else {
            if (esEstudiante == true){
                return 90;
            }else {
                return 120;
            }
        }
    }
    /**
     * comprobación de si es estudiante
     * @param opcion -> verdadero o falso
     * @return
     */
    public static boolean comprobarSiEsEstudiante(int opcion){
        if (opcion == 1){
            return true;
        }else {
            return false;
        }
    }
}
