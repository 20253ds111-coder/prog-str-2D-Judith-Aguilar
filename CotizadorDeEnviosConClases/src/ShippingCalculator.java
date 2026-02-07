public class ShippingCalculator {

    private final double IVA = 0.16;
    private final double PRECIO_BASE_ESTANDAR = 50;
    private final double PRECIO_BASE_EXPRESS = 90;
    private final double PRECIO_POR_KG = 12;

    public double calcularSubtotal(double pesoKg, int distanciaKm, int tipoServicio, boolean zonaRemota){
        double total = 0;

        if (tipoServicio == 1){
            total += PRECIO_BASE_ESTANDAR;
        } else {
            total += PRECIO_BASE_EXPRESS;
        }
        total += (pesoKg * PRECIO_POR_KG);

        if (distanciaKm <= 50){
            total += 20;
        } else if (distanciaKm >= 51 && distanciaKm <= 200){
            total += 60;
        } else {
            total += 120;
        }
        if (zonaRemota == true) {
            total = total * 1.10; // Multiplicar por 1.10 es sumar el 10%
        }
        return total;
    }
    public double calcularIVA(double subtotal){
        return subtotal * IVA;
    }
    public double calcularTotal(double subtotal, double iva){
        return subtotal + iva;
    }
    public String obtenerNombreServicio(int tipoServicio) {
        if (tipoServicio == 1) {
            return "Estándar";
        } else {
            return "Express";
        }
    }
}