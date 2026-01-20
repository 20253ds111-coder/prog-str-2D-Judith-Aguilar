import java.util.Scanner;

public class Main {
    //creamos una variable para el valor de pi(para no. imaginarios)
    public static double VALOR_DE_PI = 3.1416;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("Menu:");
            System.out.println("1- calcular IMC");
            System.out.println("2- Calcular al area de un rectangulo");
            System.out.println("3- convertir c a f");
            System.out.println("4- calcular el area de un circulo");
            System.out.println("5- Salir");
            System.out.println("ingresa una opción del menú:");
            opcion = scanner.nextInt();

            if (opcion == 1){
                double pesoKG = calcular(scanner, "ingresa el peso en Kg");
                double alturaM = calcular(scanner, "ingresa la altura en m.");
                double calcularimc = IMC(pesoKG, alturaM);
                System.out.println("tu IMC es de:"+calcularimc);

            }else if (opcion == 2){
                double base = calcular(scanner, "ingresa la base del rectángulo");
                double altura = calcular(scanner, "ingresa la altura del rectángulo");
                double areaRectangulo = AREA(base, altura);
                System.out.println("el area del rectángulo es de"+areaRectangulo);

            }else if (opcion == 3){
                double centigrados = calcular(scanner, "ingresa los grados centigrados");
                double fahrenheit = conversion(centigrados);
                System.out.println("los grados fahrenheit son:"+fahrenheit);

            }else if (opcion == 4){
                double radio =calcular(scanner, "ingresa el radio del circulo");
                double areaCirculo = AreaCirculo(radio);
                System.out.println("el area del circulo es de:"+areaCirculo);

            }else{
                System.out.println("salir");
            }
        }while (opcion > 0 && opcion < 5);

    }
    /**
     * manda un mensaje y recibe un dato
     * @param scanner
     * @param mensaje
     * @return
     */
    //hacer una nueva clase para almacenar los datos
    public static double calcular(Scanner scanner, String mensaje){
        System.out.println(mensaje);
        //marcaba error porque tenia que regresar (return)
        return scanner.nextDouble();
    }

    /**
     * calcular el IMC
     * @param pesoKG -> se solicitó al usuario
     * @param alturaM -> se solicitó al usuario
     * @return
     */
    public static double IMC(double pesoKG, double alturaM){
        return pesoKG/(alturaM*alturaM) ;
    }

    /**
     * clase para calcular el area de un rectángulo
     * @param base -> se solicitó anteriormente
     * @param altura -> se solicitó anteriormente
     * @return
     */
    public static double AREA(double base, double altura){
        return (base*altura);
    }

    /**
     * conversion de grados centigrados
     * @param centigrados
     * @return
     */
    public static double conversion(double centigrados){
        return (centigrados * 1.8)+32;
    }

    /**
     * clase para calcular el area de un circulo
     * @param radio
     * @return
     */
    public static double AreaCirculo(double radio){
        return VALOR_DE_PI*(radio * radio);
    }

}