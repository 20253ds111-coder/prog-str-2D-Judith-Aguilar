import java.util.Scanner;

public class ProcesoAlumnos {

    Scanner scanner = new Scanner(System.in);
    ValidarDatos validarDatos = new ValidarDatos();

    public void altaAlumno(Alumno[] alumnos){
        int id = validarDatos.validarId(scanner, "Ingresa el id");
        while (true) {
            boolean duplicado = false;
            for (Alumno alumno : alumnos) {
                if (alumno != null && alumno.getId() == id) {
                    duplicado = true;
                    break;
                }
            }
            if (duplicado) {
                System.out.println("El id "+id+" ya existe");
                return;
            } else {
                String nombre = validarDatos.validarNombre(scanner, "Ingresa el nombre: ");
                double promedio = validarDatos.validarPromedio(scanner, "Ingresa el promedio del alumno: ");

                alumnos[id] = new Alumno(id, nombre, promedio);
                System.out.println("alumno registrado correctamente");
                break;
            }
        }
    }

    void buscarId(Alumno[] alumnos){
        boolean alumnoEncontrado = false;
        int id = validarDatos.validarId(scanner, "Ingresar el ID a buscar");
        for (int i = 0; i <= alumnos.length; i++) {
            if (alumnos[i] != null && alumnos[i].getId() == id){
                System.out.println(alumnos[i]);
                alumnoEncontrado = true;
                break;
            }
        }
        if (alumnoEncontrado == false){
            System.out.println("Alumno no encontrado");
            return;
        }
    }

    void actualizarPromedio(Alumno[] alumno){
        boolean idEncontrado = false;
        int id = validarDatos.validarId(scanner, "Ingresa el id del usuario a actualizar: ");
        for (int i = 0; i < alumno.length; i++) {
            if (alumno[i] != null && alumno[i].getId() == id){
                double promedio = validarDatos.validarPromedio(scanner, "Ingresa el nuevo promedio: ");
                alumno[i].setPromedio(promedio);
                System.out.println("el promedio se actualizo correctamente");
                idEncontrado = true;
            }
        }
        if (!idEncontrado){
            System.out.println("No se encontro al alumno");
        }
    }

    void darDebajaAAlumno(Alumno[] alumno){
        boolean idEncontrado = false;
        int id = validarDatos.validarId(scanner, "Ingresa el id a dar de baja");
        for (int i = 0; i < alumno.length; i++) {
            if (alumno[i] != null && alumno[i].getId() == id){
                alumno[i].setActivo(false);
                System.out.println("Baja exitosa");
                idEncontrado = true;
            }
        }
        if (!(idEncontrado)){
            System.out.println("ID no encontrado");
        }
    }

    void listaActivos(Alumno[] alumno){
        boolean existenAlumnos = false;
        for (int i = 0; i < alumno.length; i++) {
            if (alumno[i] != null && alumno[i].isActivo()){
                System.out.println(alumno[i]);
                existenAlumnos = true;
            }
        }
        if (!existenAlumnos){
            System.out.println("No existen registros");
        }
    }

    void reporte(Alumno[] alumno){
        boolean alumnosRegistrados = false;

        int alumnosNoBobos = 0;
        double promedioGeneral = 0;
        double promedioMayor = 0;
        double promedioMenor = 10;
        int cantidadAlumnos = 0;
        Alumno mayor = null;
        Alumno menor = null;

        for (int i = 0; i < alumno.length; i++) {
            if (alumno[i] != null && alumno[i].isActivo()){
                promedioGeneral += alumno[i].getPromedio();
                cantidadAlumnos++;
                if (promedioMayor < alumno[i].getPromedio()){
                    promedioMayor = alumno[i].getPromedio();
                    mayor=alumno[i];
                }
                if(promedioMenor > alumno[i].getPromedio()){
                    promedioMenor = alumno[i].getPromedio();
                    menor = alumno[i];
                }
                if (alumno[i].getPromedio() >= 8){
                    alumnosNoBobos++;
                }
                alumnosRegistrados = true;
            }
        }

        if (alumnosRegistrados){
            double promedioFinal = promedioGeneral/cantidadAlumnos;
            System.out.println("El promedio general fue: "+promedioFinal);
            System.out.println("Los alumnos con iq mayor al promedio fueron "+alumnosNoBobos);
            System.out.println("El mejor promedio fue de : "+mayor);
            System.out.println("El promedio mas bajo fue de : "+menor);
        }else {
            System.out.println("No hay alumnos registrados o activos");
        }
    }
}
