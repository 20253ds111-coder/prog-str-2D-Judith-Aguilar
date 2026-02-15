import java.util.Scanner;

public class ValidarDatos {

    public int validarId(Scanner scanner, String mensaje){
        int valor = 0;
        while (true){
            System.out.print(mensaje);
            if (scanner.hasNextInt()){
                valor = scanner.nextInt();
                if (valor >= 0 && valor<= 24){
                    return valor;
                }else {
                    System.out.println("valor fuera de rango (0-24)");
                }
            }else {
                System.out.println("Valor no valido");
                scanner.next();
            }
        }
    }

    public String validarNombre(Scanner scanner, String mensaje){
        String valor = "";
        while (true){

            System.out.print(mensaje);
            valor = scanner.next();
            if (!(valor.isEmpty())){
                return valor;
            }else {
                System.out.println("Debe escribir algo");
                scanner.next();
            }
        }
    }

    public double validarPromedio(Scanner scanner, String mensaje){
        double valor = 0;
        while (true){
            System.out.print(mensaje);
            if (scanner.hasNextDouble()){
                valor = scanner.nextDouble();
                if (valor >= 0 && valor<=10){
                    return valor;
                }else {
                    System.out.println("valor fuera de rango (0-10)");
                }
            }else {
                System.out.println("Valor no valido");
                scanner.next();
            }
        }
    }
}
