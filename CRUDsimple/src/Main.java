import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Service personaService = new Service();
        Persona[] personas = new Persona[20];
        int opcion = 0;
        do {
            System.out.println("Menu");
            System.out.println("1) Alta");
            System.out.println("2) Buscar por ID");
            System.out.println("3) Baja lógica por ID");
            System.out.println("4) Listar activas");
            System.out.println("5) Actualizar nombre por ID (solo activas)");
            System.out.println("0) Salir");
            System.out.print("Ingresa una opcion: ");
            opcion = scanner.nextInt();

            switch (opcion){
                case 1:
                    personaService.alta(personas);
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 0:
                   System.out.println("gracias por ingresar al programa :)");
                default:
                    System.out.println("Opcion fuera de rango");
                    break;
            }
        }while (opcion != 0);
    }
}
