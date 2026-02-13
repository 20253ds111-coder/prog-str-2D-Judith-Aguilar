import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Alumno[] alumnos = new Alumno[25];

        AlumnoService service = new AlumnoService();
        Validador validador = new Validador();

        int opcion = -1;
        while (opcion != 0) {
            System.out.println("MENU");
            System.out.println("1) Alta alumno");
            System.out.println("2) Buscar por ID");
            System.out.println("3) Actualizar promedio");
            System.out.println("4) Baja lógica");
            System.out.println("5) Listar activos");
            System.out.println("6) Reportes");
            System.out.println("0) Salir");
            System.out.print("Seleccione: ");
            opcion = sc.nextInt();


            if (opcion == 1) {
                System.out.print("ID: "); int id = sc.nextInt();
                sc.nextLine();
                System.out.print("Nombre: "); String nom = sc.nextLine();
                System.out.print("Promedio: "); double prom = sc.nextDouble();

                if (validador.idValido(id, alumnos) && validador.nombreValido(nom) && validador.promedioValido(prom)) {
                    for (int i = 0; i < alumnos.length; i++) {
                        if (alumnos[i] == null) {
                            alumnos[i] = new Alumno(id, nom, prom);
                            System.out.println("Guardado");
                            break;
                        }
                    }
                } else {
                    System.out.println("Error en los datos (ID repetido o valores fuera de rango)");
                }

            } else if (opcion == 2) {
                System.out.print("ID a buscar: ");
                Alumno encontrado = service.buscarPorId(sc.nextInt(), alumnos);
                System.out.println(encontrado != null ? encontrado : "No encontrado.");

            } else if (opcion == 3) {
                System.out.print("ID para actualizar: ");
                Alumno a = service.buscarPorId(sc.nextInt(), alumnos);
                if (a != null) {
                    System.out.print("Nuevo promedio: ");
                    double p = sc.nextDouble();
                    if (validador.promedioValido(p)) a.setPromedio(p);
                }

            } else if (opcion == 4) {
                System.out.print("ID para baja: ");
                Alumno a = service.buscarPorId(sc.nextInt(), alumnos);
                if (a != null) a.setActivo(false);

            } else if (opcion == 5) {
                service.listarActivos(alumnos);

            } else if (opcion == 6) {
                service.generarReportes(alumnos);
            }
        }
    }
}