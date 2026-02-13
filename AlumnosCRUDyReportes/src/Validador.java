public class Validador {

    public boolean idValido(int id, Alumno[] lista) {
        if (id <= 0) return false;
        for (Alumno a : lista) {
            if (a != null && a.getId() == id) {
                return false;
            }
        }
        return true;
    }

    public boolean nombreValido(String nombre) {
        return nombre != null && !nombre.trim().isEmpty();
    }

    public boolean promedioValido(double promedio) {
        return promedio >= 0 && promedio <= 10;
    }
}