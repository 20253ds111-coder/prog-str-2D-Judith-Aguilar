import java.util.Scanner;

public class Service {
    Scanner scanner = new Scanner(System.in);
    Validador validarValor = new Validador();



    public void alta(Persona[] personas){
        // Pedimos y validamos el id nuevo
        int id = validarValor.validarId(scanner, "ingresa el nuevo id: ");
        String name = validarValor.validarNombre(scanner, "ingresa el nombre");

        for (int i = 0; i < personas.length; i++) {
            if (!(personas[i] == null)){
                personas[i].setId(id);
                personas[i].setName(name);
                personas[i].setActive(true);
                System.out.println("ingreso alta válida");
                break;
            }
        }
    }
}