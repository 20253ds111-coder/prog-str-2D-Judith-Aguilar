import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;

public class App {
    public static int fueraDelRango = 0;
    public static int datoNoNumerico = 0;
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int max = 100;
        int min = 1;
        int secreto = random.nextInt(100) + 1; // genera un int entre 1 y 100
        int intentos = 0;
        int limiteIntentos = 7;
        boolean gano = false;

        System.out.println("Adivina el numero secreto (1-100)");

        while(intentos < limiteIntentos) {
            int numero = obtenerNumeroValido(sc, "intento:"+(intentos+1), min,max);
            intentos++;
            if (numero == secreto) {
                System.out.println("ganaste!!! adivinaste el número en el intento:"+intentos);
                gano = true; //para saber si gano
                System.out.println("Las veces que te saliste del rango fueron:"+ fueraDelRango);
                System.out.println("las veces que ingresaste un dato no numerico fueron:"+ datoNoNumerico);
                break;
            }else if (numero >secreto){
                System.out.println("El numero que buscas es menor a"+ numero);
            }else {
                System.out.println("el numero que buscas es mayor a"+ numero);
            }
        }
        if (!gano){
            System.out.println("perdiste, el numero secreto es "+ secreto);
            System.out.println("Las veces que te saliste del rango fueron:"+ fueraDelRango);
            System.out.println("las veces que ingresaste un dato no numerico fueron:"+ datoNoNumerico);
        }
    }
    public static int obtenerNumeroValido(Scanner sc, String mensaje, int min, int max){
        int valor;
        while (true) {
            System.out.println(mensaje);
            if (sc.hasNextInt()){
                //Es un dato numerico
                valor = sc.nextInt();
                if (valor >= min && valor <= max){
                    return valor;
                }else {
                    System.out.println("el dato ingresado no está dentro del rango");
                    fueraDelRango ++;
                }
            }else {
                System.out.println("El dato ingresado no es numerico");
                sc.next(); //para limpiar lo que ingrese el usuario
                datoNoNumerico ++;
            }
        }
    }
}