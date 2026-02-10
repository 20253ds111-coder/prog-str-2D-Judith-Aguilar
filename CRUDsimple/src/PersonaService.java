import java.util.Scanner;

public class PersonaService {
    Scanner sc = new Scanner(System.in);
    Validaciones validar = new Validaciones();

    public void alta(Persona[] personas) {
        System.out.println("--- ALTA DE PERSONA ---");
        int indiceLibre = -1;
        for (int i = 0; i < personas.length; i++) {
            if (personas[i] == null) {
                indiceLibre = i;
                break;
            }
        }
        if (indiceLibre == -1) {
            System.out.println(">> Error: La lista está llena (Máx 20).");
            return;
        }
        int idNuevo = validar.pedirId(sc, "Ingresa el ID: ");

        for (Persona p : personas) {

            if (p != null && p.getId() == idNuevo) {
                System.out.println(">> Error: Ya existe una persona con ese ID (aunque esté inactiva).");
                return;
            }
        }
        String nombre = validar.pedirNombre(sc, "Ingresa el Nombre: ");

        personas[indiceLibre] = new Persona(idNuevo, nombre);
        System.out.println(">> Persona registrada con éxito.");
    }
    public void buscarPorId(Persona[] personas) {
        System.out.println("--- BUSCAR PERSONA ---");
        int idBuscar = validar.pedirId(sc, "Ingresa el ID a buscar: ");

        boolean encontrado = false;
        for (Persona p : personas) {
            // Condición: Que exista, que sea el ID y que ESTÉ ACTIVA
            if (p != null && p.getId() == idBuscar && p.isActiva()) {
                System.out.println("Resultado: " + p.toString());
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println(">> No encontrada o inactiva.");
        }
    }
    public void bajaLogica(Persona[] personas) {
        System.out.println("--- BAJA LÓGICA ---");
        int idBaja = validar.pedirId(sc, "Ingresa el ID a desactivar: ");

        for (int i = 0; i < personas.length; i++) {
            // Buscamos si existe y si está activa
            if (personas[i] != null && personas[i].getId() == idBaja) {
                if (personas[i].isActiva()) {
                    personas[i].setActiva(false); // AQUÍ ESTÁ LA BAJA LÓGICA
                    System.out.println(">> La persona con ID " + idBaja + " ha sido dada de baja.");
                } else {
                    System.out.println(">> Esa persona ya estaba dada de baja.");
                }
                return;
            }
        }
        System.out.println(">> No se encontró el ID.");
    }
    public void listarActivas(Persona[] personas) {
        System.out.println("ACTIVAS");
        boolean hayAlguien = false;
        for (Persona p : personas) {
            if (p != null && p.isActiva()) {
                System.out.println(p.toString());
                hayAlguien = true;
            }
        }
        if (!hayAlguien) {
            System.out.println("No hay personas activas registradas.");
        }
    }
    public void actualizarNombre(Persona[] personas) {
        System.out.println("ACTUALIZAR NOMBRE ");
        int idEditar = validar.pedirId(sc, "Ingresa el ID a editar: ");

        for (Persona p : personas) {
            if (p != null && p.getId() == idEditar) {
                if (p.isActiva()) {
                    System.out.println("Nombre actual: " + p.getNombre());
                    String nuevoNombre = validar.pedirNombre(sc, "Ingresa el NUEVO nombre: ");
                    p.setNombre(nuevoNombre);
                    System.out.println(">> Nombre actualizado correctamente.");
                } else {
                    System.out.println(">> Error: No se puede editar una persona inactiva.");
                }
                return;
            }
        }
        System.out.println(">> No se encontró el ID.");
    }
}