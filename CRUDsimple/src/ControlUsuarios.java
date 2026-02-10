import java.util.Scanner;

public class ControlUsuarios {
    Scanner teclado = new Scanner(System.in);
    ValidarDatos herramienta = new ValidarDatos();
    private Usuario[] usuarios = new Usuario[20];
    public void registrar(Usuario[] lista) {

        int codigoNuevo = herramienta.pedirEntero(teclado, "Digita el nuevo Código: ", lista);
        int lugarVacio = -1;

        for (int i = 0; i < lista.length; i++) {
            if (lista[i] == null) {
                lugarVacio = i;
                break;
            }
        }

        if (lugarVacio == -1) {
            System.out.println("Error: La lista está llena");
            return;
        }

        while (true) {
            boolean existe = false;
            for (Usuario u : lista) {
                if (u != null && u.getCodigo() == codigoNuevo) {
                    existe = true;
                    break;
                }
            }

            if (existe) {
                System.out.println("Ese código (" + codigoNuevo + ") ya está ocupado");
                return;
            } else {
                String alias = herramienta.pedirTexto(teclado, "Escribe el nombre: ");
                lista[lugarVacio] = new Usuario(codigoNuevo, alias);
                System.out.println("¡Usuario registrado con éxito!");
                break;
            }
        }
    }

    void encontrarPorCodigo(Usuario[] lista) {
        boolean encontrado = false;
        int busqueda = herramienta.pedirEntero(teclado, "¿Qué código buscas?: ", lista);

        for (int i = 0; i < lista.length; i++) {
            if (lista[i] != null && lista[i].getCodigo() == busqueda) {
                System.out.println(lista[i]);
                encontrado = true;
                break;
            }
        }
        if (!encontrado){
            System.out.println("No existe nadie con ese código");
        }
    }

    void eliminarUsuario(Usuario[] lista){
        boolean borrado = false;
        int codigoBaja = herramienta.pedirEntero(teclado, "Código para eliminar: ", lista);

        for (int i = 0; i < lista.length; i++) {
            if (lista[i] != null && lista[i].getCodigo() == codigoBaja) {
                lista[i] = null; // Lo borramos volviéndolo null
                borrado = true;
                System.out.println("Registro eliminado.");
                break;
            }
        }
        if (!borrado){
            System.out.println("No se encontró ese código para borrar");
        }
    }

    void mostrarLista(Usuario[] lista){
        boolean hayDatos = false;
        for (int i = 0; i < lista.length; i++) {
            if (lista[i] != null) {
                System.out.println(lista[i]);
                hayDatos = true;
            }
        }
        if (!hayDatos){
            System.out.println("La lista está vacía");
        }
    }

    void cambiarNombre(Usuario[] lista){
        int codigoEditar = herramienta.pedirEntero(teclado, "Código del usuario a editar: ", lista);

        for (int i = 0; i < lista.length; i++) {
            // Verificamos que exista, coincida el ID y esté habilitado
            if (lista[i] != null && lista[i].getCodigo() == codigoEditar && lista[i].isHabilitado()) {
                String nuevoAlias = herramienta.pedirTexto(teclado, "Nuevo nombre: ");
                lista[i].setNombreCompleto(nuevoAlias);
                System.out.println("Nombre cambiado exitosamente");
                return;
            }
        }
        System.out.println("No se encontró el usuario o no está activo");
    }
}