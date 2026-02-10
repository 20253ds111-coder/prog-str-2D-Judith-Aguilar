import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PersonaService servicio = new PersonaService();
        Persona[] personas = new Persona[20];
        int opcion = -1;
        do {
            System.out.println("Menu");
            System.out.println("1) Alta");
            System.out.println("2) Buscar por ID (solo activas)");
            System.out.println("3) Baja lógica por ID");
            System.out.println("4) Listar activas");
            System.out.println("5) Actualizar nombre por ID (solo activas)");
            System.out.println("0) Salir");
            System.out.print("Elige una opcion: ");
            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                switch (opcion) {
                    case 1:
                        servicio.alta(personas);
                        break;
                    case 2:
                        servicio.buscarPorId(personas);
                        break;
                    case 3:
                        servicio.bajaLogica(personas);
                        break;
                    case 4:
                        servicio.listarActivas(personas);
                        break;
                    case 5:
                        servicio.actualizarNombre(personas);
                        break;
                    case 0:
                        System.out.println("Saliendo del sistema...");
                        break;
                    default:
                        System.out.println(">> Error: Opción inválida. Intenta de nuevo.");
                }
            } else {
                System.out.println(">> Error: Debes escribir un número.");
                scanner.next();
            }
        } while (opcion != 0);
    }
}