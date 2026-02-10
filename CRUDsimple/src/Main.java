import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        ControlUsuarios control = new ControlUsuarios();
        Usuario[] listaUsuarios = new Usuario[20];

        int seleccion = 0;
        do {
            System.out.println("--- SISTEMA DE USUARIOS ---");
            System.out.println("1) Registrar nuevo");
            System.out.println("2) Buscar datos por Código");
            System.out.println("3) Eliminar por Código");
            System.out.println("4) Mostrar todos los activos");
            System.out.println("5) Editar nombre (solo activos)");
            System.out.println("0) Salir del programa");
            System.out.print("Elige una opcion: ");

            // Usamos nextInt y validamos estructura igual al tuyo
            seleccion = entrada.nextInt();

            switch (seleccion){
                case 1:
                    control.registrar(listaUsuarios);
                    break;
                case 2:
                    control.encontrarPorCodigo(listaUsuarios);
                    break;
                case 3:
                    control.eliminarUsuario(listaUsuarios);
                    break;
                case 4:
                    control.mostrarLista(listaUsuarios);
                    break;
                case 5:
                    control.cambiarNombre(listaUsuarios);
                    break;
                case 0:
                    System.out.println("Cerrando sistema...");
                    break;
                default:
                    System.out.println("Numero incorrecto, intenta de nuevo");
                    break;
            }
        } while (seleccion != 0);
    }
}