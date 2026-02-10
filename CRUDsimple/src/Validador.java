import java.util.Scanner;

public class Validador {

    public int validarId(Scanner sc, String msj){
        int valor = 0;
        while (true){
            System.out.println(msj);
            if (sc.hasNextInt()){
                valor = sc.nextInt();
                if (valor>0 && valor <= 20){
                    return valor;
                }else {
                    System.out.println("El id tiene que ser mayor a 0 y menor que 20");
                }
            }else {
                System.out.println("El valor ingresado no es valido");
                sc.next();
            }
        }

    }
    public String validarNombre(Scanner sc, String msj){
        while (true){
            System.out.println(msj);
            String valor = sc.next();
            if (!valor.isEmpty()){
                return valor;
            }else{
                System.out.println("El camppo no puede quedar vacío");
                sc.next();
            }
        }

    }
}