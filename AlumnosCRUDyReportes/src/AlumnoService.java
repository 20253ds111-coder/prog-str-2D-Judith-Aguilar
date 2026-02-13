public class AlumnoService {

    public void listarActivos(Alumno[] lista) {
        System.out.println("Alumnos activos");
        for (Alumno a : lista) {
            if (a != null && a.isActivo()) {
                System.out.println("ID: " + a.getId() + " Nombre: " + a.getNombre() + " Prom: " + a.getPromedio());
            }
        }
    }

    public Alumno buscarPorId(int id, Alumno[] lista) {
        for (Alumno a : lista) {
            if (a != null && a.getId() == id && a.isActivo()) {
                return a;
            }
        }
        return null;
    }

    public void generarReportes(Alumno[] lista) {
        double suma = 0;
        int activos = 0, mayores8 = 0;
        Alumno mayor = null, menor = null;

        for (Alumno a : lista) {
            if (a != null && a.isActivo()) {
                suma += a.getPromedio();
                activos++;
                if (a.getPromedio() >= 8.0) mayores8++;

                if (mayor == null || a.getPromedio() > mayor.getPromedio()) mayor = a;
                if (menor == null || a.getPromedio() < menor.getPromedio()) menor = a;
            }
        }

        if (activos > 0) {
            System.out.println("Promedio General: " + (suma / activos));
            System.out.println("Mejor Alumno: " + mayor.getNombre() + " (" + mayor.getPromedio() + ")");
            System.out.println("Alumno con menor promedio: " + menor.getNombre() + " (" + menor.getPromedio() + ")");
            System.out.println("Total con promedio >= 8.0: " + mayores8);
        } else {
            System.out.println("No hay datos suficientes para reportes.");
        }
    }
}