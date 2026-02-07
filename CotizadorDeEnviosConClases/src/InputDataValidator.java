import java.util.Scanner;
public class InputDataValidator {
    public int leerIntEnRango(Scanner scanner, String msg, int min, int max){
        int value;
        while (true){
            System.out.println(msg);
            if (scanner.hasNextInt()){
                value = scanner.nextInt();
                if (value >= min && value <= max){
                    return value;
                }
                System.out.println("el dato esta fuera de rango (" + min + "-" + max + ")");
            } else {
                System.out.println("el dato no es numerico entero");
                scanner.next();
            }
        }
    }
    public double leerDoubleEnRango(Scanner sc, String msg, double min, double max){
        double value;
        while (true){
            System.out.println(msg);
            if (sc.hasNextDouble()){
                value = sc.nextDouble();
                if (value >= min && value <= max){
                    return value;
                }
                System.out.println("el dato esta fuera de rango ("+ min + "-"+ max +")");
            } else {
                System.out.println("el dato no es numerico decimal");
                sc.next();
            }
        }
    }
    public boolean leerBoolean(Scanner sc, String msg){
        while (true){
            System.out.println(msg);
            if (sc.hasNextBoolean()){
                return sc.nextBoolean();
            } else {
                System.out.println("El valor ingresado no es boolean (escribe true o false)");
                sc.next();
            }
        }
    }
}